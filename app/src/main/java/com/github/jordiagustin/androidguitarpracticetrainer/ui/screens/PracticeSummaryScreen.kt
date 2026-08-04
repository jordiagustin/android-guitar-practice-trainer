package com.github.jordiagustin.androidguitarpracticetrainer.ui.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.navigationBarsPadding
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.github.jordiagustin.androidguitarpracticetrainer.model.PracticeSessionSummary
import com.github.jordiagustin.androidguitarpracticetrainer.practice.PracticeTimer

private const val SUMMARY_TITLE = "Practice finished"
private const val TIME_LABEL = "Time"
private const val CHANGES_LABEL = "Changes"
private const val BPM_LABEL = "BPM"
private const val CHORDS_LABEL = "Chords"
private const val START_NEW_SESSION_LABEL = "Start new session"

private val ScreenPadding = 24.dp
private val SmallSpacing = 8.dp
private val MediumSpacing = 16.dp
private val ExtraLargeSpacing = 32.dp

private val TitleFontSize = 28.sp
private val BodyFontSize = 18.sp

@Composable
fun PracticeSummaryScreen(
    summary: PracticeSessionSummary,
    onStartNewSession: () -> Unit
) {
    val formattedTime = PracticeTimer.formatElapsedTime(summary.elapsedSeconds)

    val chordNames = summary.chordNames
        .sorted()
        .joinToString(", ")

    Column(
        modifier = Modifier
            .fillMaxSize()
            .navigationBarsPadding()
            .padding(ScreenPadding),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = SUMMARY_TITLE,
            fontSize = TitleFontSize,
            fontWeight = FontWeight.Bold,
            textAlign = TextAlign.Center
        )

        Spacer(modifier = Modifier.height(ExtraLargeSpacing))

        Text(
            text = "$TIME_LABEL: $formattedTime",
            fontSize = BodyFontSize
        )

        Spacer(modifier = Modifier.height(SmallSpacing))

        Text(
            text = "$CHANGES_LABEL: ${summary.chordChangeCount}",
            fontSize = BodyFontSize
        )

        Spacer(modifier = Modifier.height(SmallSpacing))

        Text(
            text = "$BPM_LABEL: ${summary.bpm}",
            fontSize = BodyFontSize
        )

        Spacer(modifier = Modifier.height(MediumSpacing))

        Text(
            text = "$CHORDS_LABEL: $chordNames",
            fontSize = BodyFontSize,
            textAlign = TextAlign.Center
        )

        Spacer(modifier = Modifier.height(ExtraLargeSpacing))

        Button(
            onClick = onStartNewSession
        ) {
            Text(
                text = START_NEW_SESSION_LABEL,
                fontSize = BodyFontSize
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun PracticeSummaryScreenPreview() {
    PracticeSummaryScreen(
        summary = PracticeSessionSummary(
            chordNames = listOf("A", "D", "Em"),
            bpm = 60,
            elapsedSeconds = 155,
            chordChangeCount = 47
        ),
        onStartNewSession = {}
    )
}