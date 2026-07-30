package com.github.jordiagustin.androidguitarpracticetrainer.practice

/**
 * Provides timer-related calculations for practice sessions.
 */
object PracticeTimer {

    /**
     * Converts BPM into milliseconds between beats.
     *
     * Example:
     * 60 BPM = 1000 ms
     * 120 BPM = 500 ms
     */
    fun calculateIntervalMillis(bpm: Int): Long {
        return 60000L / bpm
    }
}