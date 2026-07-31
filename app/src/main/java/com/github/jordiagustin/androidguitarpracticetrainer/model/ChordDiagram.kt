package com.github.jordiagustin.androidguitarpracticetrainer.model

/**
 * Represents the visual diagram information for a guitar chord.
 *
 * Strings are represented from left to right as they appear in a standard chord diagram:
 * string 6, string 5, string 4, string 3, string 2, string 1.
 */
data class ChordDiagram(
    val chordName: String,
    val stringPositions: List<StringPosition>,
    val barrePositions: List<BarrePosition> = emptyList()
)

/**
 * Represents the position of a single guitar string in a chord diagram.
 */
data class StringPosition(
    val stringNumber: Int,
    val fret: Int?,
    val status: StringStatus
)

/**
 * Represents a barre position in a chord diagram.
 *
 * A barre covers multiple strings on the same fret.
 */
data class BarrePosition(
    val fret: Int,
    val startString: Int,
    val endString: Int
)

/**
 * Defines whether a string is played open, fretted or muted.
 */
enum class StringStatus {
    OPEN,
    FRETTED,
    MUTED
}
