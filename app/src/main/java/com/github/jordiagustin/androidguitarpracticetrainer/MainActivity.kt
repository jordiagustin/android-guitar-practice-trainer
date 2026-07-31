package com.github.jordiagustin.androidguitarpracticetrainer

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import com.github.jordiagustin.androidguitarpracticetrainer.ui.screens.PracticeSetupScreen
import com.github.jordiagustin.androidguitarpracticetrainer.ui.theme.AndroidGuitarPracticeTrainerTheme
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import com.github.jordiagustin.androidguitarpracticetrainer.ui.screens.PracticeSessionScreen
import com.github.jordiagustin.androidguitarpracticetrainer.data.ChordRepository
import com.github.jordiagustin.androidguitarpracticetrainer.practice.PracticeConfig

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            AndroidGuitarPracticeTrainerTheme {
                var isPracticeSessionActive by remember {
                    mutableStateOf(false)
                }

                var activeChordGroup by remember {
                    mutableStateOf(ChordRepository.chordGroups.first())
                }

                var activeBpm by remember {
                    mutableStateOf(PracticeConfig.DEFAULT_BPM)
                }

                var activeSoundEnabled by remember {
                    mutableStateOf(true)
                }

                if (isPracticeSessionActive) {
                    PracticeSessionScreen(
                        chordGroup = activeChordGroup,
                        bpm = activeBpm,
                        isSoundEnabled = activeSoundEnabled,
                        onStopPractice = {
                            isPracticeSessionActive = false
                        }
                    )
                } else {
                    PracticeSetupScreen(
                        onStartPractice = { selectedChordGroup, selectedBpm, selectedSoundEnabled ->
                            activeChordGroup = selectedChordGroup
                            activeBpm = selectedBpm
                            activeSoundEnabled = selectedSoundEnabled
                            isPracticeSessionActive = true
                        }
                    )
                }
            }
        }
    }
}
