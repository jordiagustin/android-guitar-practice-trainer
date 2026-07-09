# Data Model

## 1. Purpose

This document defines the basic data model for the MVP.

The MVP uses a small set of core concepts needed to support chord change practice.

## 2. Core models

The initial data model includes three main models:

* Chord
* ChordGroup
* PracticeSession

---

## 3. Chord

A Chord represents a single guitar chord that can be displayed during a practice session.

Examples:

* A
* Am
* C
* D
* Em
* G

Initial properties:

* name
* type

Example:

```text
Chord
name: A
type: major
```

Possible chord types:

* major
* minor

Future properties may include:

* diagram image
* difficulty level
* fingering
* sound sample

These future properties are not included in the MVP.

---

## 4. ChordGroup

A ChordGroup represents a predefined group of chords that the user can select before starting a practice session.

Examples:

* Major chords
* Minor chords
* All chords

Initial properties:

* name
* chords

Example:

```text
ChordGroup
name: Major chords
chords:
- A
- B
- C
- D
- E
- F
- G
```

The selected ChordGroup determines which chords can appear during the practice session.

---

## 5. PracticeSession

A PracticeSession represents an active chord practice session.

It stores the selected configuration and the current state of the practice.

Initial properties:

* selectedChordGroup
* bpm
* currentChord
* isRunning
* isPaused

Example:

```text
PracticeSession
selectedChordGroup: Major chords
bpm: 60
currentChord: D
isRunning: true
isPaused: false
```

The PracticeSession controls which chord is currently displayed and whether the session is running, paused or stopped.

---

## 6. Out of scope

The MVP will not include models for:

* User
* Profile
* Song
* Tablature
* Tuner
* TheoryLesson
* PracticeHistory
* Statistics

These models may be considered in future versions.
