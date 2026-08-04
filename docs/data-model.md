# Data Model

## 1. Purpose

This document defines the current data model and supporting logic for the Android Guitar Practice Trainer app.

The app uses a small set of core concepts to support chord change practice, custom chord selection, generated chord diagrams and final practice summaries.

The current implementation separates:

* Core data models.
* Predefined chord data.
* Generated chord diagram data.
* Practice session runtime state.
* Practice-related helper logic.
* Testable practice logic.

---

## 2. Core models

The app currently includes the following main models:

* Chord
* ChordGroup
* ChordDiagram
* StringPosition
* BarrePosition
* PracticeSession
* PracticeSessionSummary

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

In the current implementation, chord types are represented by `ChordType`.

Current chord types:

* MAJOR
* MINOR

---

## 4. ChordGroup

A ChordGroup represents a group of chords that can be used during a practice session.

Examples:

* Major chords
* Minor chords
* All chords
* Custom selection

Current properties:

* name
* chords

Example:

```text
ChordGroup
name: Custom selection · 3 chords
chords:
- A
- D
- Em
```

Predefined chord groups are provided by the data layer.

When the user customizes the selected chords, the app creates a temporary custom ChordGroup for the active session.

---

## 5. ChordDiagram

A ChordDiagram represents the visual information needed to draw a guitar chord diagram.

Chord diagrams are represented using structured data instead of image files.

Current properties:

* chordName
* stringPositions
* barrePositions

Example:

```text
ChordDiagram
chordName: F
stringPositions:
- string 6, fret 1, fretted
- string 5, fret 3, fretted
- string 4, fret 3, fretted
- string 3, fret 2, fretted
- string 2, fret 1, fretted
- string 1, fret 1, fretted
barrePositions:
- fret 1, string 6 to string 1
```

Generated chord diagrams currently support:

* Fretted positions.
* Open strings.
* Muted strings.
* Barre chord positions.

---

## 6. StringPosition

A StringPosition represents the state of one guitar string inside a chord diagram.

Current properties:

* stringNumber
* fret
* status

Example:

```text
StringPosition
stringNumber: 5
fret: 2
status: FRETTED
```

The `status` value is represented by `StringStatus`.

Current string statuses:

* OPEN
* FRETTED
* MUTED

A fretted string has a fret number.

Open and muted strings use `fret = null`.

---

## 7. BarrePosition

A BarrePosition represents a barre chord position.

A barre position defines one finger covering multiple strings on the same fret.

Current properties:

* fret
* startString
* endString

Example:

```text
BarrePosition
fret: 1
startString: 6
endString: 1
```

This is used for chords such as F, B, Bm, Cm, Fm and Gm.

---

## 8. PracticeSession

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
selectedChordGroup: Custom selection · 3 chords
bpm: 60
currentChord: D
isRunning: true
isPaused: false
```

The PracticeSession model describes the main state of a practice session.

In the current implementation, some session state is managed directly by the Practice Session Screen using Compose state.

---

## 9. PracticeSessionSummary

A PracticeSessionSummary represents the final result of a completed practice session.

Current properties:

* chordNames
* bpm
* elapsedSeconds
* chordChangeCount

Example:

```text
PracticeSessionSummary
chordNames:
- A
- D
- Em
bpm: 60
elapsedSeconds: 155
chordChangeCount: 47
```

This model is created when the user ends a practice session.

It is passed from the Practice Session Screen to the Practice Summary Screen.

---

## 10. Runtime session state

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

The app avoids displaying the same chord twice in a row when there is more than one selected chord available.

### isPaused

The isPaused value stores whether the current session is paused.

When the session is paused:

* Chord changes stop.
* The visual pulse stops updating.
* Metronome sound stops.
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

## 11. Predefined chord data

Chord data is predefined in code.

The app currently provides:

* Major chords
* Minor chords
* All chords

The predefined chord data is stored in the data layer.

Current predefined groups:

```text
Major chords:
A, B, C, D, E, F, G

Minor chords:
Am, Bm, Cm, Dm, Em, Fm, Gm

All chords:
Major chords + Minor chords
```

The user can start from one of these groups and then customize the final selected chord list before starting a session.

In future versions, this data could come from:

* local database
* user configuration
* saved practice presets
* imported chord packs
* remote source

---

## 12. Chord diagram data

Chord diagram data is predefined in code.

The chord diagram repository provides generated diagram information for all currently supported chords.

Current supported chord diagrams:

```text
Major chords:
A, B, C, D, E, F, G

Minor chords:
Am, Bm, Cm, Dm, Em, Fm, Gm
```

The chord diagram repository allows the app to find a diagram by chord name.

If a diagram is not found, the UI can display a fallback placeholder message.

---

## 13. Practice logic components

The app includes practice-related helper logic.

These components are not data models, but they support the practice session behavior.

Current practice logic components:

* PracticeConfig
* ChordSelector
* ChordSelection
* PracticeTimer
* ChordDiagramRepository

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

These values are used by the setup screen and the app state initialization.

### ChordSelector

ChordSelector provides random chord selection logic.

Current responsibilities:

* Select a random chord from the selected chord list.
* Avoid selecting the current chord again when there is more than one available chord.
* Reject empty chord lists.

### ChordSelection

ChordSelection provides custom chord selection logic.

Current responsibilities:

* Add a chord when it is selected.
* Remove a chord when it is unselected.
* Avoid duplicate selected chords.
* Keep the selection unchanged when removing a chord that is not selected.

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

### ChordDiagramRepository

ChordDiagramRepository provides predefined chord diagram data.

Current responsibilities:

* Store chord diagram data.
* Find chord diagrams by chord name.
* Return null when a chord diagram does not exist.

---

## 14. Testability note

The current practice logic is separated from the UI layer.

The following components contain logic that can be unit tested:

* PracticeConfig
* ChordSelector
* PracticeTimer
* ChordSelection
* ChordDiagramRepository

The project currently includes unit tests for:

* PracticeTimer
* ChordSelector
* ChordSelection
* ChordDiagramRepository

These tests are located under:

```text
app/src/test/java/com/github/jordiagustin/androidguitarpracticetrainer/practice/
app/src/test/java/com/github/jordiagustin/androidguitarpracticetrainer/data/
```

Practice timer tests verify that:

* BPM values are converted into the correct interval in milliseconds.
* Invalid BPM values are rejected.
* Elapsed practice time is formatted correctly.

Chord selector tests verify that:

* A random chord is returned from the provided list.
* The same chord is not returned twice in a row when alternatives exist.
* A single-chord list still works.
* Empty chord lists are rejected.

Chord selection tests verify that:

* Chords are added when selected.
* Chords are removed when unselected.
* Removing a chord that is not selected keeps the list unchanged.
* Selecting an already selected chord does not create duplicates.

Chord diagram repository tests verify that:

* Existing chord diagrams can be found by chord name.
* Missing chord diagrams return null.
* Barre chord data is stored correctly.
* Every chord currently used by the app has a corresponding chord diagram.

---

## 15. Out of scope

The app currently does not include models for:

* User
* Profile
* Song
* Tablature
* Tuner
* TheoryLesson
* PracticeHistory
* Statistics
* SavedPracticePreset

These models may be considered in future versions.