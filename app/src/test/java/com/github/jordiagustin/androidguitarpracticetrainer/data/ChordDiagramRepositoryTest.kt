package com.github.jordiagustin.androidguitarpracticetrainer.data

import org.junit.Assert.assertEquals
import org.junit.Assert.assertNotNull
import org.junit.Assert.assertNull
import org.junit.Test

class ChordDiagramRepositoryTest {

    @Test
    fun findByChordName_returnsDiagram_whenMajorChordExists() {
        val result = ChordDiagramRepository.findByChordName("A")

        assertNotNull(result)
        assertEquals("A", result?.chordName)
    }

    @Test
    fun findByChordName_returnsDiagram_whenMinorChordExists() {
        val result = ChordDiagramRepository.findByChordName("Am")

        assertNotNull(result)
        assertEquals("Am", result?.chordName)
    }

    @Test
    fun findByChordName_returnsNull_whenChordDoesNotExist() {
        val result = ChordDiagramRepository.findByChordName("Cm")

        assertNull(result)
    }

    @Test
    fun findByChordName_returnsBarrePosition_whenFChordExists() {
        val result = ChordDiagramRepository.findByChordName("F")

        assertNotNull(result)
        assertEquals("F", result?.chordName)
        assertEquals(1, result?.barrePositions?.size)
        assertEquals(1, result?.barrePositions?.first()?.fret)
        assertEquals(6, result?.barrePositions?.first()?.startString)
        assertEquals(1, result?.barrePositions?.first()?.endString)
    }

    @Test
    fun findByChordName_returnsBarrePosition_whenBChordExists() {
        val result = ChordDiagramRepository.findByChordName("B")

        assertNotNull(result)
        assertEquals("B", result?.chordName)
        assertEquals(1, result?.barrePositions?.size)
        assertEquals(2, result?.barrePositions?.first()?.fret)
        assertEquals(5, result?.barrePositions?.first()?.startString)
        assertEquals(1, result?.barrePositions?.first()?.endString)
    }
}