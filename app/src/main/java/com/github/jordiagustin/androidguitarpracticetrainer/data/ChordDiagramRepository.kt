package com.github.jordiagustin.androidguitarpracticetrainer.data

import com.github.jordiagustin.androidguitarpracticetrainer.model.ChordDiagram
import com.github.jordiagustin.androidguitarpracticetrainer.model.StringPosition
import com.github.jordiagustin.androidguitarpracticetrainer.model.StringStatus

/**
 * Provides predefined chord diagram data used by the app.
 *
 * String order follows a standard chord diagram from left to right:
 * string 6, string 5, string 4, string 3, string 2, string 1.
 */
object ChordDiagramRepository {

    val chordDiagrams = listOf(
        ChordDiagram(
            chordName = "A",
            stringPositions = listOf(
                StringPosition(6, null, StringStatus.MUTED),
                StringPosition(5, null, StringStatus.OPEN),
                StringPosition(4, 2, StringStatus.FRETTED),
                StringPosition(3, 2, StringStatus.FRETTED),
                StringPosition(2, 2, StringStatus.FRETTED),
                StringPosition(1, null, StringStatus.OPEN)
            )
        ),
        ChordDiagram(
            chordName = "C",
            stringPositions = listOf(
                StringPosition(6, null, StringStatus.MUTED),
                StringPosition(5, 3, StringStatus.FRETTED),
                StringPosition(4, 2, StringStatus.FRETTED),
                StringPosition(3, null, StringStatus.OPEN),
                StringPosition(2, 1, StringStatus.FRETTED),
                StringPosition(1, null, StringStatus.OPEN)
            )
        ),
        ChordDiagram(
            chordName = "D",
            stringPositions = listOf(
                StringPosition(6, null, StringStatus.MUTED),
                StringPosition(5, null, StringStatus.MUTED),
                StringPosition(4, null, StringStatus.OPEN),
                StringPosition(3, 2, StringStatus.FRETTED),
                StringPosition(2, 3, StringStatus.FRETTED),
                StringPosition(1, 2, StringStatus.FRETTED)
            )
        ),
        ChordDiagram(
            chordName = "E",
            stringPositions = listOf(
                StringPosition(6, null, StringStatus.OPEN),
                StringPosition(5, 2, StringStatus.FRETTED),
                StringPosition(4, 2, StringStatus.FRETTED),
                StringPosition(3, 1, StringStatus.FRETTED),
                StringPosition(2, null, StringStatus.OPEN),
                StringPosition(1, null, StringStatus.OPEN)
            )
        ),
        ChordDiagram(
            chordName = "G",
            stringPositions = listOf(
                StringPosition(6, 3, StringStatus.FRETTED),
                StringPosition(5, 2, StringStatus.FRETTED),
                StringPosition(4, null, StringStatus.OPEN),
                StringPosition(3, null, StringStatus.OPEN),
                StringPosition(2, null, StringStatus.OPEN),
                StringPosition(1, 3, StringStatus.FRETTED)
            )
        ),
        ChordDiagram(
            chordName = "Am",
            stringPositions = listOf(
                StringPosition(6, null, StringStatus.MUTED),
                StringPosition(5, null, StringStatus.OPEN),
                StringPosition(4, 2, StringStatus.FRETTED),
                StringPosition(3, 2, StringStatus.FRETTED),
                StringPosition(2, 1, StringStatus.FRETTED),
                StringPosition(1, null, StringStatus.OPEN)
            )
        ),
        ChordDiagram(
            chordName = "Dm",
            stringPositions = listOf(
                StringPosition(6, null, StringStatus.MUTED),
                StringPosition(5, null, StringStatus.MUTED),
                StringPosition(4, null, StringStatus.OPEN),
                StringPosition(3, 2, StringStatus.FRETTED),
                StringPosition(2, 3, StringStatus.FRETTED),
                StringPosition(1, 1, StringStatus.FRETTED)
            )
        ),
        ChordDiagram(
            chordName = "Em",
            stringPositions = listOf(
                StringPosition(6, null, StringStatus.OPEN),
                StringPosition(5, 2, StringStatus.FRETTED),
                StringPosition(4, 2, StringStatus.FRETTED),
                StringPosition(3, null, StringStatus.OPEN),
                StringPosition(2, null, StringStatus.OPEN),
                StringPosition(1, null, StringStatus.OPEN)
            )
        )
    )

    fun findByChordName(chordName: String): ChordDiagram? {
        return chordDiagrams.firstOrNull { chordDiagram ->
            chordDiagram.chordName == chordName
        }
    }
}