package com.github.jordiagustin.androidguitarpracticetrainer.model

/**
 * Represents an active chord practice session.
 *
 * A practice session stores the selected chord group, the configured BPM,
 * the current displayed chord and the current session state.
 */
data class PracticeSession(
    val selectedChordGroup: ChordGroup,
    val bpm: Int,
    val currentChord: Chord?, // El ? vol dir que pot ser un Chord o pot ser null. Ens va bé perquè una sessió pot existir abans que s’hagi mostrat el primer acord.
    val isRunning: Boolean,
    val isPaused: Boolean
)