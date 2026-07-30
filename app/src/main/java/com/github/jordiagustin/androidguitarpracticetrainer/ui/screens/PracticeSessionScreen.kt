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
import com.github.jordiagustin.androidguitarpracticetrainer.model.Chord
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import com.github.jordiagustin.androidguitarpracticetrainer.practice.ChordSelector

/**
 * Screen used during an active chord practice session.
 *
 * For the MVP, this screen displays the current chord, the selected BPM,
 * a simple pulse indicator and basic session controls.
 */

/*private fun getRandomChordExcludingCurrent(
    chords: List<Chord>,
    currentChord: Chord?
): Chord {
    val availableChords = chords.filter { chord ->
        chord != currentChord
    }

    return if (availableChords.isNotEmpty()){
        availableChords.random()
    } else {
        chords.random()
    }
}*/
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

    LaunchedEffect(chordGroup, bpm) {
        val intervalMillis = 60000L / bpm

        while (true) {
            delay(intervalMillis)

            if (!isPaused) {
                pulseActive = !pulseActive
                currentChord = ChordSelector.getRandomChordExcludingCurrent(
                    chords = chordGroup.chords,
                    currentChord = currentChord
                )
            }
        }
    }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(24.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        Text(
            text = "Current chord",
            fontSize = 20.sp
        )

        Spacer(modifier = Modifier.height(16.dp))

        Text(
            text = currentChord.name,
            fontSize = 72.sp,
            fontWeight = FontWeight.Bold
        )

        Spacer(modifier = Modifier.height(8.dp))

        Text(
            text = if (pulseActive) "Pulse ●" else "Pulse ○",
            fontSize = 24.sp
        )

        if (isPaused) {
            Spacer(modifier = Modifier.height(8.dp))

            Text(
                text = "Paused",
                fontSize = 20.sp,
                fontWeight = FontWeight.Bold
            )
        }

        Spacer(modifier = Modifier.height(32.dp))

        Text(
            text = chordGroup.name,
            fontSize = 18.sp
        )

        Text(
            text = "BPM: $bpm",
            fontSize = 18.sp
        )

        Spacer(modifier = Modifier.height(32.dp))

        Row {
            Button(
                onClick = {
                    isPaused = !isPaused
                }
            ) {
                Text(
                    text = if (isPaused) "Resume" else "Pause"
                )
            }

            Spacer(modifier = Modifier.padding(8.dp))

            Button(
                onClick = onStopPractice
            ) {
                Text(text = "Stop")
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
