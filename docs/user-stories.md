# User Stories

## 1. Practice setup

### US-001 — Select chord group

As a guitar learner,
I want to select a chord group,
so that I can practice only the type of chords I want to improve.

Acceptance criteria:

* The user can choose between Major chords, Minor chords and All chords.
* The selected chord group is used when starting the practice session.
* A default chord group is selected when opening the screen.

---

### US-002 — Configure BPM

As a guitar learner,
I want to configure the practice tempo in BPM,
so that I can practice chord changes at a speed that matches my current level.

Acceptance criteria:

* The user can set the BPM value.
* The BPM value cannot be lower than 30.
* The BPM value cannot be higher than 160.
* The default BPM value is 60.

---

### US-003 — Start practice session

As a guitar learner,
I want to start a practice session,
so that the app begins showing random chords at the selected tempo.

Acceptance criteria:

* The user can start the session from the setup screen.
* The session uses the selected chord group.
* The session uses the selected BPM value.
* The first chord is displayed when the session starts.

## 2. Practice session

### US-004 — Display random chord

As a guitar learner,
I want the app to display random chords,
so that I can practice reacting to different chord changes.

Acceptance criteria:

* The app displays one chord at a time.
* The chord is selected from the selected chord group.
* The chord is shown in large text.
* The chord changes according to the BPM timing.

---

### US-005 — Metronome pulse

As a guitar learner,
I want to hear or see a metronome pulse,
so that I can keep a steady rhythm while practicing.

Acceptance criteria:

* The app provides a pulse at the configured BPM.
* The pulse is synchronized with chord changes.
* The pulse is active while the session is running.
* The pulse stops when the session is stopped.

---

### US-006 — Pause and resume session

As a guitar learner,
I want to pause and resume the practice session,
so that I can stop temporarily without losing my current configuration.

Acceptance criteria:

* The user can pause an active session.
* The chord stops changing while paused.
* The user can resume the session.
* The session continues using the same BPM and chord group.

---

### US-007 — Stop session

As a guitar learner,
I want to stop the practice session,
so that I can return to the setup screen and change the practice configuration.

Acceptance criteria:

* The user can stop an active session.
* The metronome pulse stops.
* The app returns to the setup screen.
* The previous configuration may remain selected.
