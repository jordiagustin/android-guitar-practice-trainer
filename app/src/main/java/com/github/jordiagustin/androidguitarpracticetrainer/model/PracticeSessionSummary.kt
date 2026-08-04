package com.github.jordiagustin.androidguitarpracticetrainer.model

/**
 * Represents the final summary of a completed practice session.
 */
data class PracticeSessionSummary(
    val chordNames: List<String>,
    val bpm: Int,
    val elapsedSeconds: Int,
    val chordChangeCount: Int
)