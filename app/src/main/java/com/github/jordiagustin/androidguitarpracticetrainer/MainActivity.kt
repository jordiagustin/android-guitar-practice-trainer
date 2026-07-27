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
import com.github.jordiagustin.androidguitarpracticetrainer.model.ChordGroup


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            AndroidGuitarPracticeTrainerTheme {
                var isPracticeSessionActive by remember { mutableStateOf(false) }

                var activeChordGroup by remember {
                    mutableStateOf(ChordRepository.chordGroups.first())
                }

                var activeBpm by remember {
                    mutableStateOf(60)
                }

                if (isPracticeSessionActive) {
                    PracticeSessionScreen(
                        chordGroup = activeChordGroup,
                        bmp = activeBpm,
                        onStopPractice = {
                            isPracticeSessionActive = false
                        }
                    )
                } else {
                    PracticeSetupScreen(
                        onStartPractice = { selectedChordGroup, selectedBpm ->
                            activeChordGroup = selectedChordGroup
                            activeBpm = selectedBpm
                            isPracticeSessionActive = true
                        }
                    )
                }
            }
        }
    }
}
