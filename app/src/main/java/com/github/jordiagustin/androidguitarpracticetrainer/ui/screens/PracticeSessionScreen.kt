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
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

/**
 * Screen used during an active chord practice session.
 *
 * For the MVP, this screen displays the current chord, the selected BPM,
 * a simple pulse indicator and basic session controls.
 */
@Composable
fun PracticeSessionScreen(
    onStopPractice: () -> Unit
) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(24.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(text = "Current chord")

        Spacer(modifier = Modifier.height(16.dp))

        Text(text = "A")

        Spacer(modifier = Modifier.height(32.dp))

        Text(text = "BPM: 60")

        Spacer(modifier = Modifier.height(16.dp))

        Text(text = "Pulse")

        Spacer(modifier = Modifier.height(32.dp))

        Row {
            Button(
                onClick = {
                    // Pause and resume logic will be implemented later.
                }
            ) {
                Text(text = "Pause")
            }

            Spacer(modifier = Modifier.padding(8.dp))

            Button(
                onClick = onStopPractice
            ){
                Text(text = "Stop")
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun PracticeSessionScreenPreview() {
    PracticeSessionScreen(
        onStopPractice = {}
    )
}

