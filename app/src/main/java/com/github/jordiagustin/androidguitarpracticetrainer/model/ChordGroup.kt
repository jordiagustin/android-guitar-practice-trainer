package com.github.jordiagustin.androidguitarpracticetrainer.model

/**
 * Represents a selectable group of guitar chords used during a practice session.
 *
 * A chord group contains a display name and a list of chords.
 */
data class ChordGroup (
    val name: String,
    val chords: List<Chord>
)