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

/**
 * Initial screen used to configure a chord practice session.
 *
 * For the MVP, this screen allows the user to choose a chord group,
 * configure the BPM value and start the practice session.
 */

private const val MIN_BPM = 30
private const val MAX_BPM = 160

@Composable
fun PracticeSetupScreen(
    onStartPractice: (ChordGroup, Int) -> Unit
) {
    var bpm by remember { mutableFloatStateOf(60f) }
    val chordGroups = ChordRepository.chordGroups
    var selectedChordGroup by remember { mutableStateOf(chordGroups.first())}

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(24.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = "Guitar Practice Trainer",
            fontSize = 28.sp,
            fontWeight = FontWeight.Bold,
            textAlign = TextAlign.Center
        )

        Spacer(modifier = Modifier.height(12.dp))

        Text(
            text = "Practice chord changes with random prompts and a configurable tempo.",
            fontSize = 16.sp,
            textAlign = TextAlign.Center
        )

        Spacer(modifier = Modifier.height(32.dp))

        Text(
            text = "Chord group",
            fontSize = 20.sp,
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
            text = "BPM: ${bpm.toInt()}",
            fontSize = 22.sp,
            fontWeight = FontWeight.Bold
        )

        Slider(
            value = bpm,
            onValueChange = { newValue ->
                bpm = newValue
            },
            valueRange = MIN_BPM.toFloat()..MAX_BPM.toFloat()
        )

        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Text(
                text = "$MIN_BPM BPM",
                fontSize = 14.sp
            )

            Text(
                text = "$MAX_BPM BPM",
                fontSize = 14.sp
            )
        }

        Spacer(modifier = Modifier.height(24.dp))

        Text(
            text = "Selected session",
            fontSize = 18.sp,
            fontWeight = FontWeight.Bold
        )

        Spacer(modifier = Modifier.height(8.dp))

        Text(
            text = "${selectedChordGroup.name} · ${bpm.toInt()} BPM",
            fontSize = 18.sp
        )

        Spacer(modifier = Modifier.height(24.dp))

        Button(
            onClick = {
                onStartPractice(selectedChordGroup, bpm.toInt())
            }
        ) {
            Text(
                text = "Start Practice",
                fontSize = 18.sp
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