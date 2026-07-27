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

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            AndroidGuitarPracticeTrainerTheme {
                var isPracticeSessionActive by remember { mutableStateOf(false) }

                if (isPracticeSessionActive) {
                    PracticeSessionScreen(
                        onStopPractice = {
                            isPracticeSessionActive = false
                        }
                    )
                } else {
                    PracticeSetupScreen(
                        onStartPractice = {
                            isPracticeSessionActive = true
                        }
                    )
                }
            }
        }
    }
}
