package com.github.jordiagustin.androidguitarpracticetrainer.ui.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Slider
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableFloatStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.RadioButton
import androidx.compose.runtime.mutableStateOf
import com.github.jordiagustin.androidguitarpracticetrainer.data.ChordRepository
import com.github.jordiagustin.androidguitarpracticetrainer.model.ChordGroup
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.sp
import com.github.jordiagustin.androidguitarpracticetrainer.practice.PracticeConfig
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll

/**
 * Initial screen used to configure a chord practice session.
 *
 * For the MVP, this screen allows the user to choose a chord group,
 * configure the BPM value and start the practice session.
 */

private val ScreenPadding = 24.dp
private const val START_PRACTICE_LABEL = "Start Practice"

private const val APP_TITLE = "Guitar Practice Trainer"
private const val APP_DESCRIPTION = "Practice chord changes with random prompts and a configurable tempo."
private const val CHORD_GROUP_LABEL = "Chord group"
private const val BPM_LABEL = "BPM"
private const val SELECTED_SESSION_LABEL = "Selected session"

private val TitleFontSize = 28.sp
private val SectionTitleFontSize = 20.sp
private val DescriptionFontSize = 16.sp
private val BodyFontSize = 18.sp
private val SmallFontSize = 14.sp
private val BpmFontSize = 22.sp
@Composable
fun PracticeSetupScreen(
    onStartPractice: (ChordGroup, Int) -> Unit
) {
    var bpm by remember { mutableFloatStateOf(PracticeConfig.DEFAULT_BPM.toFloat()) }
    val chordGroups = ChordRepository.chordGroups
    var selectedChordGroup by remember { mutableStateOf(chordGroups.first())}

    Column(
        modifier = Modifier
            .fillMaxSize()
            .verticalScroll(rememberScrollState())
            .padding(ScreenPadding),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = APP_TITLE,
            fontSize = TitleFontSize,
            fontWeight = FontWeight.Bold,
            textAlign = TextAlign.Center
        )

        Spacer(modifier = Modifier.height(12.dp))

        Text(
            text = APP_DESCRIPTION,
            fontSize = DescriptionFontSize,
            textAlign = TextAlign.Center
        )

        Spacer(modifier = Modifier.height(32.dp))

        Text(
            text = CHORD_GROUP_LABEL,
            fontSize = SectionTitleFontSize,
            fontWeight = FontWeight.Bold
        )

        Spacer(modifier = Modifier.height(8.dp))

        chordGroups.forEach { chordGroup ->
            Row(
                verticalAlignment = Alignment.CenterVertically
            ) {
                RadioButton(
                    selected = chordGroup == selectedChordGroup,
                    onClick = {
                        selectedChordGroup = chordGroup
                    }
                )

                Text(text = chordGroup.name)
            }
        }

        Spacer(modifier = Modifier.height(24.dp))

        Text(
            text = "$BPM_LABEL: ${bpm.toInt()}",
            fontSize = BpmFontSize,
            fontWeight = FontWeight.Bold
        )

        Slider(
            value = bpm,
            onValueChange = { newValue ->
                bpm = newValue
            },
            valueRange = PracticeConfig.MIN_BPM.toFloat()..PracticeConfig.MAX_BPM.toFloat()
        )

        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Text(
                text = "${PracticeConfig.MIN_BPM} BPM",
                fontSize = SmallFontSize
            )

            Text(
                text = "${PracticeConfig.MAX_BPM} BPM",
                fontSize = SmallFontSize
            )
        }

        Spacer(modifier = Modifier.height(24.dp))

        Text(
            text = SELECTED_SESSION_LABEL,
            fontSize = BodyFontSize,
            fontWeight = FontWeight.Bold
        )

        Spacer(modifier = Modifier.height(8.dp))

        Text(
            text = "${selectedChordGroup.name} · ${bpm.toInt()} BPM",
            fontSize = BodyFontSize
        )

        Spacer(modifier = Modifier.height(24.dp))

        Button(
            onClick = {
                onStartPractice(selectedChordGroup, bpm.toInt())
            }
        ) {
            Text(
                text = START_PRACTICE_LABEL,
                fontSize = BodyFontSize
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun PracticeSetupScreenPreview() {
    PracticeSetupScreen(
        onStartPractice = {_, _ ->}
    )
}