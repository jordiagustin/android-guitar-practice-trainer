package com.github.jordiagustin.androidguitarpracticetrainer.practice

import com.github.jordiagustin.androidguitarpracticetrainer.model.Chord

object ChordSelection {

    fun updateSelectedChords(
        selectedChords: List<Chord>,
        chord: Chord,
        checked: Boolean
    ): List<Chord> {
        return if (checked) {
            selectedChords + chord
        } else {
            selectedChords - chord
        }
    }
}