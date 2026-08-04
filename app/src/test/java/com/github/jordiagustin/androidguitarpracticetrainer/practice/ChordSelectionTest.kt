package com.github.jordiagustin.androidguitarpracticetrainer.practice

import com.github.jordiagustin.androidguitarpracticetrainer.model.Chord
import com.github.jordiagustin.androidguitarpracticetrainer.model.ChordType
import org.junit.Assert.assertEquals
import org.junit.Assert.assertFalse
import org.junit.Assert.assertTrue
import org.junit.Test

class ChordSelectionTest {

    private val chordA = Chord("A", ChordType.MAJOR)
    private val chordD = Chord("D", ChordType.MAJOR)

    @Test
    fun updateSelectedChords_addsChord_whenCheckedIsTrue() {
        val selectedChords = listOf(chordA)

        val result = ChordSelection.updateSelectedChords(
            selectedChords = selectedChords,
            chord = chordD,
            checked = true
        )

        assertTrue(result.contains(chordA))
        assertTrue(result.contains(chordD))
        assertEquals(2, result.size)
    }

    @Test
    fun updateSelectedChords_removesChord_whenCheckedIsFalse() {
        val selectedChords = listOf(chordA, chordD)

        val result = ChordSelection.updateSelectedChords(
            selectedChords = selectedChords,
            chord = chordD,
            checked = false
        )

        assertTrue(result.contains(chordA))
        assertFalse(result.contains(chordD))
        assertEquals(1, result.size)
    }

    @Test
    fun updateSelectedChords_keepsListUnchanged_whenRemovingChordThatIsNotSelected() {
        val selectedChords = listOf(chordA)

        val result = ChordSelection.updateSelectedChords(
            selectedChords = selectedChords,
            chord = chordD,
            checked = false
        )

        assertEquals(selectedChords, result)
    }

    @Test
    fun updateSelectedChords_doesNotDuplicateChord_whenCheckedChordAlreadyExists() {
        val selectedChords = listOf(chordA)

        val result = ChordSelection.updateSelectedChords(
            selectedChords = selectedChords,
            chord = chordA,
            checked = true
        )

        assertEquals(1, result.size)
        assertEquals(chordA, result.first())
    }
}

