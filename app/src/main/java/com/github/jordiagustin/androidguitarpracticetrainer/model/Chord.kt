package com.github.jordiagustin.androidguitarpracticetrainer.model

/**
 * Represents a single guitar chord that can be displayed during practice.
 */
data class Chord (
    val name: String,
    val type: ChordType
)

/**
 * Defines the supported chord types for the MVP.
 */
enum class ChordType{
    MAJOR,
    MINOR
}