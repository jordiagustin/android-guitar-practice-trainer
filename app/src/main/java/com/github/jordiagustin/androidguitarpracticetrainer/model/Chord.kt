package com.github.jordiagustin.androidguitarpracticetrainer.model

data class Chord (
    val name: String,
    val type: ChordType
)

enum class ChordType{
    MAJOR,
    MINOR
}