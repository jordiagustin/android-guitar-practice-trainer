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
import androidx.compose.material3.Checkbox
import com.github.jordiagustin.androidguitarpracticetrainer.model.ChordType
import com.github.jordiagustin.androidguitarpracticetrainer.model.Chord
import com.github.jordiagustin.androidguitarpracticetrainer.practice.ChordSelection
import androidx.compose.foundation.layout.navigationBarsPadding
import androidx.compose.foundation.layout.FlowRow
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.width

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

private const val CUSTOM_SELECTION_LABEL = "Custom selection"
private const val CHORDS_LABEL = "chords"

private const val SELECT_CHORDS_HELPER_TEXT = "Chord groups preselect chords. You can customize the selection below."

private val TitleFontSize = 28.sp
private val SectionTitleFontSize = 20.sp
private val DescriptionFontSize = 16.sp
private val BodyFontSize = 18.sp
private val SmallFontSize = 14.sp
private val BpmFontSize = 22.sp

private val SmallSpacing = 8.dp
private val MediumSpacing = 12.dp
private val LargeSpacing = 24.dp
private val ExtraLargeSpacing = 32.dp
private val BottomSpacing = 50.dp

private const val METRONOME_SOUND_LABEL = "Metronome sound"

private const val SELECT_CHORDS_LABEL = "Select chords"

private const val NO_CHORDS_SELECTED_MESSAGE = "Select at least one chord to start practice"

private const val SELECTED_CHORD_COUNT_LABEL = "Selected chords"

private const val SELECT_ALL_LABEL = "Select all"
private const val CLEAR_ALL_LABEL = "Clear all"

private const val MAX_VISIBLE_CHORD_NAMES_IN_SUMMARY = 5

@Composable
fun PracticeSetupScreen(
    onStartPractice: (ChordGroup, Int, Boolean) -> Unit
) {
    var bpm by remember { mutableFloatStateOf(PracticeConfig.DEFAULT_BPM.toFloat()) }
    var isSoundEnabled by remember {
        mutableStateOf(true)
    }
    val chordGroups = ChordRepository.chordGroups
    var selectedChordGroup by remember { mutableStateOf(chordGroups.first())}
    var selectedChords by remember {
        mutableStateOf(selectedChordGroup.chords)
    }
    val canStartPractice = selectedChords.isNotEmpty()
    val majorSelectedGroupChords = selectedChordGroup.chords
        .filter { chord -> chord.type == ChordType.MAJOR }
        .sortedBy { chord -> chord.name }

    val minorSelectedGroupChords = selectedChordGroup.chords
        .filter { chord -> chord.type == ChordType.MINOR }
        .sortedBy { chord -> chord.name }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .verticalScroll(rememberScrollState())
            .navigationBarsPadding()
            .padding(ScreenPadding),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        Spacer(modifier = Modifier.height(MediumSpacing))

        Text(
            text = APP_TITLE,
            fontSize = TitleFontSize,
            fontWeight = FontWeight.Bold,
            textAlign = TextAlign.Center
        )

        Spacer(modifier = Modifier.height(MediumSpacing))

        Text(
            text = APP_DESCRIPTION,
            fontSize = DescriptionFontSize,
            textAlign = TextAlign.Center
        )

        Spacer(modifier = Modifier.height(ExtraLargeSpacing))

        Text(
            text = CHORD_GROUP_LABEL,
            fontSize = SectionTitleFontSize,
            fontWeight = FontWeight.Bold
        )

        Spacer(modifier = Modifier.height(SmallSpacing))

        FlowRow(
            horizontalArrangement = Arrangement.spacedBy(SmallSpacing),
            verticalArrangement = Arrangement.spacedBy(SmallSpacing)
        ) {
            chordGroups.forEach { chordGroup ->
                Row(
                    modifier = Modifier.clickable {
                        selectedChordGroup = chordGroup
                        selectedChords = chordGroup.chords
                    },
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    RadioButton(
                        selected = chordGroup == selectedChordGroup,
                        onClick = {
                            selectedChordGroup = chordGroup
                            selectedChords = chordGroup.chords
                        }
                    )

                    Text(text = chordGroup.name)
                }
            }
        }

        Spacer(modifier = Modifier.height(LargeSpacing))

        Text(
            text = SELECT_CHORDS_LABEL,
            fontSize = SectionTitleFontSize,
            fontWeight = FontWeight.Bold
        )

        Spacer(modifier = Modifier.height(SmallSpacing))

        Text(
            text = SELECT_CHORDS_HELPER_TEXT,
            fontSize = SmallFontSize,
            textAlign = TextAlign.Center
        )

        Spacer(modifier = Modifier.height(SmallSpacing))

        Row(
            horizontalArrangement = Arrangement.spacedBy(SmallSpacing),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Button(
                onClick = {
                    selectedChords = selectedChordGroup.chords
                }
            ) {
                Text(text = SELECT_ALL_LABEL)
            }

            Button(
                onClick = {
                    selectedChords = emptyList()
                }
            ) {
                Text(text = CLEAR_ALL_LABEL)
            }
        }

        Spacer(modifier = Modifier.height(SmallSpacing))

        ChordCheckboxSection(
            title = "Major chords",
            chords = majorSelectedGroupChords,
            selectedChords = selectedChords,
            onChordSelectionChanged = { chord, checked ->
                selectedChords = ChordSelection.updateSelectedChords(
                    selectedChords = selectedChords,
                    chord = chord,
                    checked = checked
                )
            }
        )

        if (
            majorSelectedGroupChords.isNotEmpty() &&
            minorSelectedGroupChords.isNotEmpty()
        ) {
            Spacer(modifier = Modifier.height(SmallSpacing))
        }

        ChordCheckboxSection(
            title = "Minor chords",
            chords = minorSelectedGroupChords,
            selectedChords = selectedChords,
            onChordSelectionChanged = { chord, checked ->
                selectedChords = ChordSelection.updateSelectedChords(
                    selectedChords = selectedChords,
                    chord = chord,
                    checked = checked
                )
            }
        )

        Spacer(modifier = Modifier.height(SmallSpacing))

        Text(
            text = "$SELECTED_CHORD_COUNT_LABEL: ${selectedChords.size}",
            fontSize = BodyFontSize,
            fontWeight = FontWeight.Bold
        )

        Spacer(modifier = Modifier.height(LargeSpacing))

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

        Spacer(modifier = Modifier.height(LargeSpacing))

        Text(
            text = SELECTED_SESSION_LABEL,
            fontSize = BodyFontSize,
            fontWeight = FontWeight.Bold
        )

        Spacer(modifier = Modifier.height(SmallSpacing))

        val selectedChordNames = selectedChords
            .map { chord -> chord.name }
            .sorted()
            .joinToString(", ")

        Text(
            text = formatSelectedSessionSummary(
                selectedChordNames = selectedChordNames,
                selectedChordCount = selectedChords.size,
                bpm = bpm.toInt()
            ),
            fontSize = BodyFontSize
        )

        Spacer(modifier = Modifier.height(LargeSpacing))

        Row(
            verticalAlignment = Alignment.CenterVertically
        ) {
            Checkbox(
                checked = isSoundEnabled,
                onCheckedChange = { checked ->
                    isSoundEnabled = checked
                }
            )

            Text(
                text = METRONOME_SOUND_LABEL,
                fontSize = BodyFontSize
            )
        }

        Spacer(modifier = Modifier.height(LargeSpacing))

        Spacer(modifier = Modifier.height(LargeSpacing))

        if (!canStartPractice) {
            Text(
                text = NO_CHORDS_SELECTED_MESSAGE,
                fontSize = SmallFontSize
            )

            Spacer(modifier = Modifier.height(SmallSpacing))
        }

        Button(
            enabled = canStartPractice,
            onClick = {
                onStartPractice(
                    ChordGroup(
                        name = "$CUSTOM_SELECTION_LABEL · ${selectedChords.size} $CHORDS_LABEL",
                        chords = selectedChords
                    ),
                    bpm.toInt(),
                    isSoundEnabled
                )
            }
        ) {
            Text(
                text = START_PRACTICE_LABEL,
                fontSize = BodyFontSize
            )
        }

        Spacer(modifier = Modifier.height(BottomSpacing))

    }
}

private fun formatSelectedSessionSummary(
    selectedChordNames: String,
    selectedChordCount: Int,
    bpm: Int
): String {
    return if (selectedChordCount <= MAX_VISIBLE_CHORD_NAMES_IN_SUMMARY) {
        "$CUSTOM_SELECTION_LABEL · $selectedChordNames · $selectedChordCount $CHORDS_LABEL · $bpm BPM"
    } else {
        "$CUSTOM_SELECTION_LABEL · $selectedChordCount $CHORDS_LABEL · $bpm BPM"
    }
}

@Composable
private fun ChordCheckboxSection(
    title: String,
    chords: List<Chord>,
    selectedChords: List<Chord>,
    onChordSelectionChanged: (Chord, Boolean) -> Unit
) {
    if (chords.isNotEmpty()) {
        Text(
            text = title,
            fontSize = BodyFontSize,
            fontWeight = FontWeight.Bold
        )

        FlowRow(
            horizontalArrangement = Arrangement.spacedBy(SmallSpacing),
            verticalArrangement = Arrangement.spacedBy(SmallSpacing)
        ) {
            chords.forEach { chord ->
                val isSelected = selectedChords.contains(chord)

                Row(
                    modifier = Modifier.clickable {
                        onChordSelectionChanged(chord, !isSelected)
                    },
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Checkbox(
                        checked = isSelected,
                        onCheckedChange = { checked ->
                            onChordSelectionChanged(chord, checked)
                        }
                    )

                    Spacer(modifier = Modifier.width(2.dp))

                    Text(
                        text = chord.name,
                        fontSize = BodyFontSize
                    )
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun PracticeSetupScreenPreview() {
    PracticeSetupScreen(
        onStartPractice = { _, _, _ -> }
    )
}