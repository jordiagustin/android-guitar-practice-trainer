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
@Composable
fun PracticeSessionScreen(
    chordGroup: ChordGroup,
    bpm: Int,
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

    LaunchedEffect(chordGroup, bpm) {
        val intervalMillis = PracticeTimer.calculateIntervalMillis(bpm)

        while (true) {
            delay(intervalMillis)

            if (!isPaused) {
                pulseActive = !pulseActive
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

        Spacer(modifier = Modifier.height(16.dp))

        Text(
            text = currentChord.name,
            fontSize = CurrentChordFontSize,
            fontWeight = FontWeight.Bold
        )

        Spacer(modifier = Modifier.height(8.dp))

        Text(
            text = if (pulseActive) PULSE_ACTIVE_LABEL else PULSE_INACTIVE_LABEL,
            fontSize = PulseFontSize
        )

        if (isPaused) {
            Spacer(modifier = Modifier.height(8.dp))

            Text(
                text = PAUSED_LABEL,
                fontSize = SectionTitleFontSize,
                fontWeight = FontWeight.Bold
            )
        }

        Spacer(modifier = Modifier.height(32.dp))

        Text(
            text = SESSION_LABEL,
            fontSize = BodyFontSize,
            fontWeight = FontWeight.Bold
        )

        Spacer(modifier = Modifier.height(8.dp))

        Text(
            text = "${chordGroup.name} · $bpm BPM",
            fontSize = BodyFontSize
        )


        Text(
            text = "$TIME_LABEL: $formattedTime · $CHANGES_LABEL: $chordChangeCount",
            fontSize = BodyFontSize
        )

        Text(
            text = "Time: $formattedTime",
            fontSize = BodyFontSize
        )

        Spacer(modifier = Modifier.height(32.dp))

        Row {
            Button(
                onClick = {
                    isPaused = !isPaused
                }
            ) {
                Text(
                    text = if (isPaused) RESUME_LABEL else PAUSE_LABEL
                )
            }

            Spacer(modifier = Modifier.padding(8.dp))

            Button(
                onClick = onStopPractice
            ) {
                Text(text = END_SESSION_LABEL)
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun PracticeSessionScreenPreview() {
    PracticeSessionScreen(
        chordGroup = ChordRepository.chordGroups.first(),
        bpm = 60,
        onStopPractice = {}
    )
}
