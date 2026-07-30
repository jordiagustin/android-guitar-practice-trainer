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

- Done

---

### B-024 — Add chord change counter

Show the number of chord changes completed during an active practice session.

The counter should increase when a new chord is displayed and should stop increasing while the session is paused.

Related user stories:

- US-004 — Display random chord
- US-006 — Pause and resume practice session

Status:

- Done

---

### B-025 — Use BPM steps of 5

Make the BPM selector increase and decrease in steps of 5 BPM.

This makes tempo selection clearer and more practical for guitar practice.

Related user stories:

- US-002 — Configure BPM

Status:

- Rejected

---

### B-025 — Add selected session summary

Improve the Practice Session Screen by grouping session information into a clearer summary.

The screen should show the selected chord group, BPM, elapsed time and chord change count in a more readable way.

Related user stories:

- US-001 — Select chord group
- US-002 — Configure BPM
- US-004 — Display random chord

Status:

- Done

---

### B-026 — Add start session summary

Show a short summary of the selected practice configuration on the Practice Setup Screen.

The summary should display the selected chord group and BPM before starting the practice session.

Related user stories:

- US-001 — Select chord group
- US-002 — Configure BPM
- US-003 — Start practice session

Status:

- Done

---

### B-027 — Improve stop button label

Rename the Stop button to make its action clearer to the user.

The button should clearly indicate that it ends the current practice session and returns to the setup screen.

Related user stories:

- US-007 — Stop practice session

Status:

- Done

---

### B-028 — Add BPM range labels

Show the minimum and maximum BPM values below the BPM slider.

The goal is to make the available tempo range clearer on the Practice Setup Screen.

Related user stories:

- US-002 — Configure BPM

Status:

- Done

---

### B-029 — Improve setup screen spacing

Improve vertical spacing on the Practice Setup Screen to make the layout easier to read.

The goal is to separate the title, chord group selector, BPM selector, selected session summary and start button more clearly.

Related user stories:

- US-001 — Select chord group
- US-002 — Configure BPM
- US-003 — Start practice session

Status:

- Done

---

### B-030 — Improve session screen spacing

Improve vertical spacing on the Practice Session Screen to make the current chord, pulse indicator, session summary and controls easier to read.

The goal is to make the active practice screen clearer while the user is playing guitar.

Related user stories:

- US-004 — Display random chord
- US-005 — Metronome pulse
- US-006 — Pause and resume practice session
- US-007 — Stop practice session

Status:

- Done

---

### B-031 — Extract BPM range constants

Extract the minimum and maximum BPM values into constants.

The goal is to avoid duplicated hardcoded BPM values and make future changes easier.

Related user stories:

- US-002 — Configure BPM

Status:

- Done

---

### B-032 — Extract practice timer interval calculation

Move the BPM interval calculation to a dedicated practice logic file.

The goal is to keep timer-related practice logic outside the UI layer and make the code easier to maintain.

Related user stories:

- US-002 — Configure BPM
- US-005 — Metronome pulse

Status:

- Done

---

### B-033 — Extract elapsed time formatting

Move elapsed time formatting logic to a dedicated practice logic component.

The goal is to keep the Practice Session Screen focused on UI and move time formatting logic outside the screen.

Related user stories:

- US-006 — Pause and resume practice session

Status:

- Done

---

### B-034 — Update README with current MVP features

Update the README file to reflect the current MVP status and implemented features.

The goal is to keep the project documentation aligned with the actual app functionality.

Related tasks:

- B-020 — Refactor chord selection logic
- B-021 — Add paused session feedback
- B-022 — Add elapsed practice time
- B-024 — Add chord change counter
- B-025 — Add selected session summary
- B-026 — Add start session summary

Status:

- Done

---

### B-035 — Create screen specification document

Create a screen specification document describing the current MVP screens.

The goal is to document the implemented Practice Setup Screen and Practice Session Screen.

Related tasks:

- B-018 — Improve practice session display
- B-019 — Improve Practice Setup Screen display
- B-021 — Add paused session feedback
- B-022 — Add elapsed practice time
- B-024 — Add chord change counter
- B-025 — Add selected session summary
- B-026 — Add start session summary
- B-028 — Add BPM range labels

Status:

- Done

---

### B-036 — Add screen specification to README

Add the screen specification document to the README documentation section.

The goal is to make the new screen specification easy to find from the project README.

Related tasks:

- B-035 — Create screen specification document

Status:

- Done

---

### B-037 — Update navigation flow document

Update the navigation flow document to match the current MVP app flow.

The goal is to clearly document how the user moves between the Practice Setup Screen and the Practice Session Screen.

Related tasks:

- B-003 — Define Chord model
- B-004 — Define ChordGroup model
- B-010 — Build Practice Session Screen UI
- B-014 — Implement stop session
- B-027 — Improve stop button label

Status:

- Done

---

### B-038 — Update user stories

Update the user stories document to match the current MVP functionality.

The goal is to keep user-facing requirements aligned with the implemented practice flow.

Related tasks:

- B-016 — Avoid repeating the same chord twice
- B-021 — Add paused session feedback
- B-022 — Add elapsed practice time
- B-024 — Add chord change counter
- B-025 — Add selected session summary
- B-026 — Add start session summary
- B-027 — Improve stop button label

Status:

- Done

---

### B-039 — Update data model document

Update the data model document to reflect the current MVP state and practice-related runtime values.

The goal is to document the main data models and session state values used by the app.

Related tasks:

- B-003 — Define Chord model
- B-004 — Define ChordGroup model
- B-005 — Define PracticeSession model
- B-022 — Add elapsed practice time
- B-024 — Add chord change counter
- B-032 — Extract practice timer interval calculation
- B-033 — Extract elapsed time formatting

Status:

- Done

---

### B-040 — Update MVP definition

Update the MVP definition document to match the current implemented feature set.

The goal is to keep the MVP scope aligned with the current functional version of the app.

Related tasks:

- B-016 — Avoid repeating the same chord twice
- B-021 — Add paused session feedback
- B-022 — Add elapsed practice time
- B-024 — Add chord change counter
- B-025 — Add selected session summary
- B-026 — Add start session summary
- B-027 — Improve stop button label

Status:

- Done

---

### B-041 — Update product definition

Update the product definition document to reflect the current MVP direction and implemented functionality.

The goal is to keep the product description aligned with the current app scope.

Related tasks:

- B-034 — Update README with current MVP features
- B-035 — Create screen specification document
- B-038 — Update user stories
- B-040 — Update MVP definition

Status:

- Done