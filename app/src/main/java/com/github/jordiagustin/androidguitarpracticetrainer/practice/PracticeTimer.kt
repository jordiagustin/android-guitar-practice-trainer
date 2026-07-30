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
        require(bpm > 0) {
            "BPM must be greater than 0"
        }

        return 60000L / bpm
    }

    fun formatElapsedTime(elapsedSeconds: Int): String {
        val minutes = elapsedSeconds / 60
        val seconds = elapsedSeconds % 60

        return "%02d:%02d".format(minutes, seconds)
    }
}