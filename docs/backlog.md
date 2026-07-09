# Project Backlog

## 1. Purpose

This document defines the initial development backlog for the MVP.

The backlog converts the product definition, user stories, screen specification and data model into small development tasks.

---

## 2. MVP backlog

### B-001 — Create Android project

Create a new Android project using Kotlin and Jetpack Compose.

Related documents:

* MVP Definition
* Screen Specification

Status:

* To do

---

### B-002 — Create basic project structure

Create the initial package structure for the app.

Initial areas:

* ui
* model
* data
* practice

Status:

* To do

---

### B-003 — Define Chord model

Create the Chord model based on the data model document.

Related user stories:

* US-004 — Display random chord

Status:

* To do

---

### B-004 — Define ChordGroup model

Create the ChordGroup model based on the data model document.

Related user stories:

* US-001 — Select chord group

Status:

* To do

---

### B-005 — Define PracticeSession model

Create the PracticeSession model based on the data model document.

Related user stories:

* US-003 — Start practice session
* US-006 — Pause and resume session
* US-007 — Stop session

Status:

* To do

---

### B-006 — Create predefined chord groups

Create predefined chord groups for:

* Major chords
* Minor chords
* All chords

Related user stories:

* US-001 — Select chord group

Status:

* To do

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

* To do

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

* To do

---

### B-009 — Implement chord group selector

Allow the user to select between:

* Major chords
* Minor chords
* All chords

Related user stories:

* US-001 — Select chord group

Status:

* To do

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

* To do

---

### B-011 — Implement random chord selection

Display a random chord from the selected chord group.

Related user stories:

* US-004 — Display random chord

Status:

* To do

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

* To do

---

### B-013 — Implement pause and resume

Allow the user to pause and resume the active practice session.

Related user stories:

* US-006 — Pause and resume session

Status:

* To do

---

### B-014 — Implement stop session

Allow the user to stop the session and return to the setup screen.

Related user stories:

* US-007 — Stop session

Status:

* To do

---

### B-015 — Update README with project status

Update the README once the MVP implementation starts.

Status:

* To do
