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
        val result = ChordDiagramRepository.findByChordName("B")

        assertNull(result)
    }
}