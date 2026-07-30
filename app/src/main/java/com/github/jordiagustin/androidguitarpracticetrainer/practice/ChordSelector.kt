package com.github.jordiagustin.androidguitarpracticetrainer.practice

import com.github.jordiagustin.androidguitarpracticetrainer.model.Chord

/**
 * Provides chord selection logic for practice sessions.
 *
 * This object keeps chord selection rules outside the UI layer.
 */
object ChordSelector {

    /**
     * Returns a random chord from the given list, avoiding the current chord
     * when there is more than one chord available.
     */
    fun getRandomChordExcludingCurrent(
        chords: List<Chord>,
        currentChord: Chord?
    ): Chord {
        require(chords.isNotEmpty()) {
            "Chord list must not be empty"
        }

        val availableChords = chords.filter { chord ->
            chord != currentChord
        }

        return if (availableChords.isNotEmpty()) {
            availableChords.random()
        } else {
            chords.random()
        }
    }