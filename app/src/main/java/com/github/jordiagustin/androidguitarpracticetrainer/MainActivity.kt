package com.github.jordiagustin.androidguitarpracticetrainer

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import com.github.jordiagustin.androidguitarpracticetrainer.ui.screens.PracticeSetupScreen
import com.github.jordiagustin.androidguitarpracticetrainer.ui.theme.AndroidGuitarPracticeTrainerTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            AndroidGuitarPracticeTrainerTheme {
                PracticeSetupScreen()
            }
        }
    }
}
