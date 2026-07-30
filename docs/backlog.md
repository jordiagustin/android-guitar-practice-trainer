# Project Backlog

## 1. Purpose

This document defines the initial development backlog for the MVP.

The backlog converts the product definition, user stories, screen specification and data model into small development tasks.

---

## 2. MVP backlog

### B-001 — Create Android project

Create a new Android project using Kotlin and Jetpack Compose.

Related documents:

- MVP Definition
- Screen Specification

Status:

- Done

Notes:

- Initial Android project created with Kotlin and Jetpack Compose.
- Project pushed to GitHub.

---

### B-002 — Create basic project structure

Create the initial package structure for the app.

Initial areas:

* ui
* model
* data
* practice

Status:

- In progress

Notes:

- Initial package structure started.
- model package created.
- data and practice packages will be completed when their first files are added.

---

### B-003 — Define Chord model

Create the Chord model based on the data model document.

Related user stories:

* US-004 — Display random chord

Status:

- Done

Notes:

- Chord model and ChordType enum created.

---

### B-004 — Define ChordGroup model

Create the ChordGroup model based on the data model document.

Related user stories:

* US-001 — Select chord group

Status:

- Done

Notes:

- ChordGroup model created with a name and a list of chords.

---

### B-005 — Define PracticeSession model

Create the PracticeSession model based on the data model document.

Related user stories:

* US-003 — Start practice session
* US-006 — Pause and resume session
* US-007 — Stop session

Status:

- Done

---

### B-006 — Create predefined chord groups

Create predefined chord groups for:

* Major chords
* Minor chords
* All chords

Related user stories:

* US-001 — Select chord group

Status:

* Done

---

### B-007 — Build Practice Setup Screen UI

Create the Practice Setup Screen with:

* App title
* Short description
* Chord group selector
* BPM selector
* Start button

Related user stories:

* US-001 — Select chord group
* US-002 — Configure BPM
* US-003 — Start practice session

Status:

* In progress


Notes:

- Initial Practice Setup Screen created with title, description, chord group text, BPM text, slider and Start button.
- Screen connected to MainActivity and running on emulator.
---

### B-008 — Implement BPM selector

Allow the user to configure BPM.

Rules:

* Minimum: 30 BPM
* Maximum: 160 BPM
* Default: 60 BPM

Related user stories:

* US-002 — Configure BPM

Status:

* Done

---

### B-009 — Implement chord group selector

Allow the user to select between:

* Major chords
* Minor chords
* All chords

Related user stories:

* US-001 — Select chord group

Status:

* Done

---

### B-010 — Build Practice Session Screen UI

Create the Practice Session Screen with:

* Current chord
* BPM value
* Pulse indicator
* Pause / Resume button
* Stop button

Related user stories:

* US-004 — Display random chord
* US-005 — Metronome pulse
* US-006 — Pause and resume session
* US-007 — Stop session

Status:

* Done

---

### B-011 — Implement random chord selection

Display a random chord from the selected chord group.

Related user stories:

* US-004 — Display random chord

Status:

* Done

---

### B-012 — Implement practice timer

Implement timing logic based on BPM.

Rules:

* The chord changes on each pulse.
* The pulse interval is calculated from the BPM.

Related user stories:

* US-004 — Display random chord
* US-005 — Metronome pulse

Status:

* Done

---

### B-013 — Implement pause and resume

Allow the user to pause and resume the active practice session.

Related user stories:

* US-006 — Pause and resume session

Status:

* Done

---

### B-014 — Implement stop session

Allow the user to stop the session and return to the setup screen.

Related user stories:

* US-007 — Stop session

Status:

* Done

---

### B-015 — Update README with project status

Update the README to reflect the current MVP implementation status.

The README should mention that the app already includes a basic functional practice flow:

- Practice Setup Screen.
- Chord group selector.
- BPM selector.
- Practice Session Screen.
- Random chord display.
- Automatic chord changes based on BPM.
- Pause and resume.
- Stop session and return to setup.

Status:

* Done

---

### B-016 — Avoid repeating the same chord twice

Improve the random chord selection logic so that the same chord is not displayed twice in a row when there is more than one chord available.

Related user stories:

- US-004 — Display random chord

Status:

- Done

---

### B-017 — Add visual pulse indicator

Add a simple visual pulse indicator to the Practice Session Screen.

The indicator should change on each BPM interval to give the user visual feedback that the metronome pulse is active.

Related user stories:

- US-005 — Metronome pulse

Status:

- Done

---

### B-018 — Improve practice session display

Improve the Practice Session Screen layout to make the current chord easier to read during practice.

The current chord should be visually prominent and readable from a comfortable playing position.

Related user stories:

- US-004 — Display random chord
- US-005 — Metronome pulse

Status:

- Done

---

### B-019 — Improve Practice Setup Screen display

Improve the Practice Setup Screen layout to make the initial configuration screen clearer and easier to use.

The screen should present the app title, chord group selector, BPM selector and Start button in a more readable way.

Related user stories:

- US-001 — Select chord group
- US-002 — Configure BPM
- US-003 — Start practice session

Status:

- Done

---

### B-020 — Refactor chord selection logic

Move the random chord selection logic from the Practice Session Screen to a dedicated practice logic file.

The goal is to keep UI code focused on displaying the screen and move practice-related logic to the `practice` package.

Related user stories:

- US-004 — Display random chord

Status:

- Done

---

### B-021 — Add paused session feedback

Show a clear visual message when the practice session is paused.

The goal is to make the session state easier to understand while practicing.

Related user stories:

- US-006 — Pause and resume practice session

Status:

- Done

---

### B-022 — Add elapsed practice time

Show the elapsed practice time during an active practice session.

The timer should increase while the session is running and stop increasing while the session is paused.

Related user stories:

- US-004 — Display random chord
- US-006 — Pause and resume practice session

Status:

- Done

---

### B-023 — Reset elapsed time when session starts

Ensure that elapsed practice time starts from 00:00 every time a new practice session begins.

The timer should not keep the previous session time after stopping and starting again.

Related user stories:

- US-003 — Start practice session
- US-007 — Stop practice session

Status:

- To do