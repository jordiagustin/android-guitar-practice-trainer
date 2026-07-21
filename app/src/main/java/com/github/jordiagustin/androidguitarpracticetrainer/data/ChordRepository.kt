package com.github.jordiagustin.androidguitarpracticetrainer.data

import com.github.jordiagustin.androidguitarpracticetrainer.model.Chord
import com.github.jordiagustin.androidguitarpracticetrainer.model.ChordGroup
import com.github.jordiagustin.androidguitarpracticetrainer.model.ChordType

/**
 * Provides the predefined chord data used by the app.
 *
 * For the MVP, the chord groups are defined directly in code.
 * In future versions, this data could come from a database or user configuration.
 */
object ChordRepository {

    val majorChords = listOf(
        Chord("A", ChordType.MAJOR),
        Chord("B", ChordType.MAJOR),
        Chord("C", ChordType.MAJOR),
        Chord("D", ChordType.MAJOR),
        Chord("E", ChordType.MAJOR),
        Chord("F", ChordType.MAJOR),
        Chord("G", ChordType.MAJOR)
    )

    val minorChords = listOf(
        Chord("Am", ChordType.MINOR),
        Chord("Bm", ChordType.MINOR),
        Chord("Cm", ChordType.MINOR),
        Chord("Dm", ChordType.MINOR),
        Chord("Em", ChordType.MINOR),
        Chord("Fm", ChordType.MINOR),
        Chord("Gm", ChordType.MINOR)
    )

    val chordGroups = listOf(
        ChordGroup(
            name = "Major chords",
            chords = majorChords
        ),
        ChordGroup(
            name = "Minor chords",
            chords = minorChords
        ),
        ChordGroup(
            name = "All chords",
            chords = majorChords + minorChords
        )
    )
}