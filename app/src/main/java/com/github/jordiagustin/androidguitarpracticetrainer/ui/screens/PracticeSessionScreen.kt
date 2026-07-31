package com.github.jordiagustin.androidguitarpracticetrainer.ui.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.github.jordiagustin.androidguitarpracticetrainer.data.ChordRepository
import com.github.jordiagustin.androidguitarpracticetrainer.model.ChordGroup
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import kotlinx.coroutines.delay
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import com.github.jordiagustin.androidguitarpracticetrainer.practice.ChordSelector
import com.github.jordiagustin.androidguitarpracticetrainer.practice.PracticeTimer
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import android.media.AudioManager
import android.media.ToneGenerator
import androidx.compose.runtime.DisposableEffect
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.foundation.Canvas
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import com.github.jordiagustin.androidguitarpracticetrainer.data.ChordDiagramRepository
import com.github.jordiagustin.androidguitarpracticetrainer.model.ChordDiagram
import com.github.jordiagustin.androidguitarpracticetrainer.model.StringStatus
import android.graphics.Paint
import android.graphics.Typeface
import androidx.compose.ui.graphics.nativeCanvas

/**
 * Screen used during an active chord practice session.
 *
 * For the MVP, this screen displays the current chord, the selected BPM,
 * a simple pulse indicator and basic session controls.
 */

private val ScreenPadding = 24.dp

private const val PAUSE_LABEL = "Pause"
private const val RESUME_LABEL = "Resume"
private const val END_SESSION_LABEL = "End Session"

private const val CURRENT_CHORD_LABEL = "Current chord"
private const val PULSE_ACTIVE_LABEL = "Pulse ●"
private const val PULSE_INACTIVE_LABEL = "Pulse ○"
private const val PAUSED_LABEL = "Paused"
private const val SESSION_LABEL = "Session"
private const val TIME_LABEL = "Time"
private const val CHANGES_LABEL = "Changes"

private val CurrentChordFontSize = 72.sp
private val SectionTitleFontSize = 20.sp
private val PulseFontSize = 24.sp
private val BodyFontSize = 18.sp

private val SmallSpacing = 8.dp
private val MediumSpacing = 16.dp
private val ButtonSpacing = 24.dp
private val ExtraLargeSpacing = 32.dp

private const val CHORD_DIAGRAM_PLACEHOLDER_LABEL = "Chord diagram"
private const val CHORD_DIAGRAM_PLACEHOLDER_TEXT = "diagram coming soon"

private val ChordDiagramHeight = 160.dp

private const val OPEN_STRING_LABEL = "O"
private const val MUTED_STRING_LABEL = "X"
@Composable
fun PracticeSessionScreen(
    chordGroup: ChordGroup,
    bpm: Int,
    isSoundEnabled: Boolean,
    onStopPractice: () -> Unit
) {
    var currentChord by remember(chordGroup) {
        mutableStateOf(
            ChordSelector.getRandomChordExcludingCurrent(
                chords = chordGroup.chords,
                currentChord = null
            )
        )
    }

    var isPaused by remember {
        mutableStateOf(false)
    }

    var pulseActive by remember {
        mutableStateOf(false)
    }

    var elapsedSeconds by remember {
        mutableStateOf(0)
    }

    var chordChangeCount by remember {
        mutableStateOf(0)
    }

    val toneGenerator = remember {
        ToneGenerator(AudioManager.STREAM_MUSIC, 80)
    }

    DisposableEffect(Unit) {
        onDispose {
            toneGenerator.release()
        }
    }

    LaunchedEffect(chordGroup, bpm) {
        val intervalMillis = PracticeTimer.calculateIntervalMillis(bpm)

        while (true) {
            delay(intervalMillis)

            if (!isPaused) {
                pulseActive = !pulseActive

                if (isSoundEnabled) {
                    toneGenerator.startTone(
                        ToneGenerator.TONE_PROP_BEEP,
                        80
                    )
                }

                currentChord = ChordSelector.getRandomChordExcludingCurrent(
                    chords = chordGroup.chords,
                    currentChord = currentChord
                )

                chordChangeCount++
            }
        }
    }

    LaunchedEffect(Unit) {
        while (true) {
            delay(1000L)

            if (!isPaused) {
                elapsedSeconds++
            }
        }
    }

    val formattedTime = PracticeTimer.formatElapsedTime(elapsedSeconds)

    val currentChordDiagram = ChordDiagramRepository.findByChordName(
        chordName = currentChord.name
    )

    Column(
        modifier = Modifier
            .fillMaxSize()
            .verticalScroll(rememberScrollState())
            .padding(ScreenPadding),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        Text(
            text = CURRENT_CHORD_LABEL,
            fontSize = 20.sp
        )

        Spacer(modifier = Modifier.height(MediumSpacing))

        Text(
            text = currentChord.name,
            fontSize = CurrentChordFontSize,
            fontWeight = FontWeight.Bold
        )

        Spacer(modifier = Modifier.height(MediumSpacing))

        ChordDiagramView(
            chordName = currentChord.name,
            chordDiagram = currentChordDiagram
        )

        Text(
            text = if (pulseActive) PULSE_ACTIVE_LABEL else PULSE_INACTIVE_LABEL,
            fontSize = PulseFontSize
        )

        if (isPaused) {
            Spacer(modifier = Modifier.height(SmallSpacing))

            Text(
                text = PAUSED_LABEL,
                fontSize = SectionTitleFontSize,
                fontWeight = FontWeight.Bold
            )
        }

        Spacer(modifier = Modifier.height(ExtraLargeSpacing))

        Text(
            text = SESSION_LABEL,
            fontSize = BodyFontSize,
            fontWeight = FontWeight.Bold
        )

        Spacer(modifier = Modifier.height(SmallSpacing))

        Text(
            text = formatSessionConfigurationSummary(
                chordGroupName = chordGroup.name,
                bpm = bpm
            ),
            fontSize = BodyFontSize
        )


        Text(
            text = formatSessionProgressSummary(
                formattedTime = formattedTime,
                chordChangeCount = chordChangeCount
            ),
            fontSize = BodyFontSize
        )

        Text(
            text = "Time: $formattedTime",
            fontSize = BodyFontSize
        )

        Spacer(modifier = Modifier.height(ExtraLargeSpacing))

        Row(
            horizontalArrangement = Arrangement.spacedBy(
                space = ButtonSpacing,
                alignment = Alignment.CenterHorizontally
            ),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Button(
                onClick = {
                    isPaused = !isPaused
                }
            ) {
                Text(
                    text = if (isPaused) RESUME_LABEL else PAUSE_LABEL
                )
            }

            Button(
                onClick = onStopPractice
            ) {
                Text(text = END_SESSION_LABEL)
            }
        }
    }
}

private fun formatSessionConfigurationSummary(
    chordGroupName: String,
    bpm: Int
): String {
    return "$chordGroupName · $bpm BPM"
}

private fun formatSessionProgressSummary(
    formattedTime: String,
    chordChangeCount: Int
): String {
    return "$TIME_LABEL: $formattedTime · $CHANGES_LABEL: $chordChangeCount"
}

@Composable
private fun ChordDiagramView(
    chordName: String,
    chordDiagram: ChordDiagram?
) {
    Text(
        text = if (chordDiagram != null) {
            chordName
        } else {
            "$chordName $CHORD_DIAGRAM_PLACEHOLDER_TEXT"
        },
        fontSize = BodyFontSize,
        fontWeight = FontWeight.Bold
    )

    Spacer(modifier = Modifier.height(SmallSpacing))

    Box(
        modifier = Modifier
            .fillMaxWidth()
            .height(ChordDiagramHeight)
            .border(1.dp, Color.Gray),
        contentAlignment = Alignment.Center
    ) {
        Canvas(
            modifier = Modifier.fillMaxSize()
        ) {
            val horizontalPadding = 32f
            val verticalPadding = 16f

            val diagramLeft = horizontalPadding
            val diagramRight = size.width - horizontalPadding
            val diagramTop = verticalPadding
            val diagramBottom = size.height - verticalPadding

            val stringCount = 6
            val fretCount = 5

            for (stringIndex in 0 until stringCount) {
                val x = diagramLeft +
                        (diagramRight - diagramLeft) * stringIndex / (stringCount - 1)

                drawLine(
                    color = Color.Gray,
                    start = Offset(x, diagramTop),
                    end = Offset(x, diagramBottom),
                    strokeWidth = 2f
                )
            }

            for (fretIndex in 0..fretCount) {
                val y = diagramTop +
                        (diagramBottom - diagramTop) * fretIndex / fretCount

                drawLine(
                    color = Color.Gray,
                    start = Offset(diagramLeft, y),
                    end = Offset(diagramRight, y),
                    strokeWidth = 2f
                )
            }
            chordDiagram?.stringPositions
                ?.filter { stringPosition ->
                    stringPosition.status == StringStatus.FRETTED &&
                            stringPosition.fret != null
                }
                ?.forEach { stringPosition ->
                    val stringIndex = 6 - stringPosition.stringNumber

                    val x = diagramLeft +
                            (diagramRight - diagramLeft) * stringIndex / (stringCount - 1)

                    val fret = stringPosition.fret ?: return@forEach

                    val y = diagramTop +
                            (diagramBottom - diagramTop) * (fret - 0.5f) / fretCount

                    drawCircle(
                        color = Color.Black,
                        radius = 10f,
                        center = Offset(x, y)
                    )
                }
            chordDiagram?.stringPositions
                ?.filter { stringPosition ->
                    stringPosition.status == StringStatus.OPEN ||
                            stringPosition.status == StringStatus.MUTED
                }
                ?.forEach { stringPosition ->
                    val stringIndex = 6 - stringPosition.stringNumber

                    val x = diagramLeft +
                            (diagramRight - diagramLeft) * stringIndex / (stringCount - 1)

                    val y = diagramTop - 6f

                    val label = when (stringPosition.status) {
                        StringStatus.OPEN -> OPEN_STRING_LABEL
                        StringStatus.MUTED -> MUTED_STRING_LABEL
                        StringStatus.FRETTED -> ""
                    }

                    drawContext.canvas.nativeCanvas.drawText(
                        label,
                        x,
                        y,
                        Paint().apply {
                            color = android.graphics.Color.BLACK
                            textAlign = Paint.Align.CENTER
                            textSize = 28f
                            typeface = Typeface.DEFAULT_BOLD
                        }
                    )
                }
        }

        if (chordDiagram == null) {
            Text(
                text = "$chordName $CHORD_DIAGRAM_PLACEHOLDER_TEXT",
                fontSize = BodyFontSize,
                textAlign = TextAlign.Center
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun PracticeSessionScreenPreview() {
    PracticeSessionScreen(
        chordGroup = ChordRepository.chordGroups.first(),
        bpm = 60,
        isSoundEnabled = true,
        onStopPractice = {}
    )
}
