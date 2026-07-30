package com.github.jordiagustin.androidguitarpracticetrainer.practice

import com.github.jordiagustin.androidguitarpracticetrainer.model.Chord
import com.github.jordiagustin.androidguitarpracticetrainer.model.ChordType
import org.junit.Assert.assertEquals
import org.junit.Assert.assertNotEquals
import org.junit.Assert.assertTrue
import org.junit.Test

class ChordSelectorTest {

    private val chordA = Chord("A", ChordType.MAJOR)
    private val chordD = Chord("D", ChordType.MAJOR)
    private val chordE = Chord("E", ChordType.MAJOR)

    @Test
    fun getRandomChordExcludingCurrent_returnsChordFromList() {
        val chords = listOf(chordA, chordD, chordE)

        val result = ChordSelector.getRandomChordExcludingCurrent(
            chords = chords,
            currentChord = null
        )

        assertTrue(chords.contains(result))
    }

    @Test
    fun getRandomChordExcludingCurrent_doesNotReturnCurrentChord_whenAlternativeExists() {
        val chords = listOf(chordA, chordD, chordE)

        val result = ChordSelector.getRandomChordExcludingCurrent(
            chords = chords,
            currentChord = chordA
        )

        assertNotEquals(chordA, result)
    }

    @Test
    fun getRandomChordExcludingCurrent_returnsCurrentChord_whenOnlyOneChordExists() {
        val chords = listOf(chordA)

        val result = ChordSelector.getRandomChordExcludingCurrent(
            chords = chords,
            currentChord = chordA
        )

        assertEquals(chordA, result)
    }

    @Test(expected = IllegalArgumentException::class)
    fun getRandomChordExcludingCurrent_throwsException_whenChordListIsEmpty() {
        ChordSelector.getRandomChordExcludingCurrent(
            chords = emptyList(),
            currentChord = null
        )
    }
}