# Data Model

## 1. Purpose

This document defines the basic data model for the MVP.

The MVP uses a small set of core concepts needed to support chord change practice.

The current implementation separates:

* Core data models.
* Predefined chord data.
* Practice session runtime state.
* Practice-related helper logic.

---

## 2. Core models

The MVP includes three main core models:

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

Current properties:

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

In the current implementation, chord types are represented by `ChordType`.

Current chord types:

* MAJOR
* MINOR

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

Current properties:

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

Current properties:

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

The PracticeSession model describes the main state of a practice session.

In the current MVP implementation, some session state is managed directly by the Practice Session Screen using Compose state.

---

## 6. Runtime session state

During an active practice session, the app also tracks runtime values.

These values are currently managed by the Practice Session Screen.

Current runtime state values:

* currentChord
* isPaused
* pulseActive
* elapsedSeconds
* chordChangeCount

### currentChord

The currentChord value stores the chord currently displayed on screen.

It changes according to the selected BPM while the session is running.

The app avoids displaying the same chord twice in a row when there is more than one chord available.

### isPaused

The isPaused value stores whether the current session is paused.

When the session is paused:

* Chord changes stop.
* The visual pulse stops updating.
* Elapsed time stops increasing.
* The chord change counter stops increasing.

### pulseActive

The pulseActive value controls the visual pulse indicator.

It alternates between two visual states:

```text
Pulse ●
Pulse ○
```

### elapsedSeconds

The elapsedSeconds value stores how many seconds have passed in the current practice session.

It increases while the session is running.

It stops increasing while the session is paused.

It starts from 0 when a new session starts.

### chordChangeCount

The chordChangeCount value stores how many chord changes have occurred during the current session.

It increases when a new chord is displayed.

It does not increase while the session is paused.

It starts from 0 when a new session starts.

---

## 7. Predefined chord data

For the MVP, chord data is predefined in code.

The app currently provides:

* Major chords
* Minor chords
* All chords

The predefined data is stored in the data layer.

Current predefined groups:

```text
Major chords:
A, B, C, D, E, F, G

Minor chords:
Am, Bm, Cm, Dm, Em, Fm, Gm

All chords:
Major chords + Minor chords
```

In future versions, this data could come from:

* local database
* user configuration
* imported chord packs
* remote source

---

## 8. Practice logic components

The MVP also includes practice-related helper logic.

These components are not data models, but they support the practice session behavior.

Current practice logic components:

* PracticeConfig
* ChordSelector
* PracticeTimer

### PracticeConfig

PracticeConfig stores shared practice configuration constants.

Current responsibilities:

* Define the minimum allowed BPM.
* Define the maximum allowed BPM.
* Define the default BPM.

Current values:

```text
MIN_BPM: 30
MAX_BPM: 160
DEFAULT_BPM: 60

```

These values are used by the setup screen and the state initialization

### ChordSelector

ChordSelector provides chord selection logic.

Current responsibility:

* Select a random chord from the selected chord group.
* Avoid selecting the current chord again when there is more than one available chord.

### PracticeTimer

PracticeTimer provides timer-related calculations.

Current responsibilities:

* Convert BPM into milliseconds between beats.
* Format elapsed time as MM:SS.

Examples:

```text
60 BPM = 1000 ms
120 BPM = 500 ms
```

Elapsed time formatting examples:

```text
5 seconds = 00:05
65 seconds = 01:05
```

---

## 9. Out of scope

The MVP does not include models for:

* User
* Profile
* Song
* Tablature
* Tuner
* TheoryLesson
* PracticeHistory
* Statistics

These models may be considered in future versions.