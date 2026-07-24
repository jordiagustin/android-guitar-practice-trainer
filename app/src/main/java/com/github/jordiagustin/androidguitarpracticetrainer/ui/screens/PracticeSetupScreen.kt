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

/**
 * Initial screen used to configure a chord practice session.
 *
 * For the MVP, this screen allows the user to choose a chord group,
 * configure the BPM value and start the practice session.
 */
@Composable
fun PracticeSetupScreen() {

    var bmp by remember { mutableFloatStateOf(60f) }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(24.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(text = "Guitar Practice Trainer")

        Spacer(modifier = Modifier.height(16.dp))

        Text(text = "Practice chord changes with random prompts and a configurable tempo.")

        Spacer(modifier = Modifier.height(32.dp))

        Text(text = "Chord group: Major chords")

        Spacer(modifier = Modifier.height(16.dp))

        Text(text = "BPM: ${bmp.toInt()}")

        Slider(
            value = bmp,
            onValueChange = { newValue ->
                bmp = newValue
            },
            valueRange = 30f..160f
        )

        Spacer(modifier = Modifier.height(32.dp))

        Button(
            onClick = {
                // Navigation will be implemented later.
            }
        ) {
            Text(text = "Start Practice")
        }
    }
}

@Preview(showBackground = true)
@Composable
fun PracticeSetupScreenPreview() {
    PracticeSetupScreen()
}