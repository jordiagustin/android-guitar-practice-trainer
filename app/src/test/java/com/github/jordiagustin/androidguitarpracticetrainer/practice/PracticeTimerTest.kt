package com.github.jordiagustin.androidguitarpracticetrainer.practice

import org.junit.Assert.assertEquals
import org.junit.Test

class PracticeTimerTest {

    @Test
    fun calculateIntervalMillis_returns1000_whenBpmIs60() {
        val result = PracticeTimer.calculateIntervalMillis(60)

        assertEquals(1000L, result)
    }

    @Test
    fun calculateIntervalMillis_returns500_whenBpmIs120() {
        val result = PracticeTimer.calculateIntervalMillis(120)

        assertEquals(500L, result)
    }

    @Test(expected = IllegalArgumentException::class)
    fun calculateIntervalMillis_throwsException_whenBpmIsZero() {
        PracticeTimer.calculateIntervalMillis(0)
    }

    @Test
    fun formatElapsedTime_returnsZeroZero_whenElapsedSecondsIsZero() {
        val result = PracticeTimer.formatElapsedTime(0)

        assertEquals("00:00", result)
    }

    @Test
    fun formatElapsedTime_returnsZeroFive_whenElapsedSecondsIsFive() {
        val result = PracticeTimer.formatElapsedTime(5)

        assertEquals("00:05", result)
    }

    @Test
    fun formatElapsedTime_returnsOneFive_whenElapsedSecondsIsSixtyFive() {
        val result = PracticeTimer.formatElapsedTime(65)

        assertEquals("01:05", result)
    }
}