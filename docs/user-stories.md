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
* The selected chord group is shown in the selected session summary.

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
* The selected BPM is shown in the selected session summary.
* The setup screen shows the minimum and maximum BPM values.

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
* The elapsed time starts from 00:00 when a new session starts.
* The chord change counter starts from 0 when a new session starts.

---

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
* The same chord is not displayed twice in a row when there is more than one chord available.

---

### US-005 — Metronome pulse

As a guitar learner,  
I want to see a metronome pulse,  
so that I can keep a steady rhythm while practicing.

Acceptance criteria:

* The app provides a visual pulse at the configured BPM.
* The pulse is synchronized with chord changes.
* The pulse is active while the session is running.
* The pulse stops updating while the session is paused.
* The pulse stops when the session is ended.

---

### US-006 — Pause and resume session

As a guitar learner,  
I want to pause and resume the practice session,  
so that I can stop temporarily without losing my current configuration.

Acceptance criteria:

* The user can pause an active session.
* The chord stops changing while paused.
* The visual pulse stops updating while paused.
* The elapsed time stops increasing while paused.
* The chord change counter stops increasing while paused.
* The screen shows a paused feedback message while paused.
* The user can resume the session.
* The session continues using the same BPM and chord group.

---

### US-007 — End session

As a guitar learner,  
I want to end the practice session,  
so that I can return to the setup screen and change the practice configuration.

Acceptance criteria:

* The user can end an active session.
* The visual pulse stops.
* The app returns to the setup screen.
* The previous configuration may remain selected.
* A new session starts with its own elapsed time and chord change counter.

---

### US-008 — View elapsed practice time

As a guitar learner,  
I want to see how long I have been practicing,  
so that I can track the duration of my current session.

Acceptance criteria:

* The app shows elapsed practice time during an active session.
* The time is displayed in MM:SS format.
* The elapsed time increases while the session is running.
* The elapsed time stops increasing while the session is paused.
* The elapsed time resets when a new session starts.

---

### US-009 — View chord change count

As a guitar learner,  
I want to see how many chord changes I have completed,  
so that I can track my practice activity during the session.

Acceptance criteria:

* The app shows the number of chord changes during an active session.
* The counter increases when a new chord is displayed.
* The counter does not increase while the session is paused.
* The counter resets when a new session starts.

---

### US-010 — View active session summary

As a guitar learner,  
I want to see a summary of my active practice session,  
so that I can quickly confirm the selected chord group, BPM, elapsed time and chord change count.

Acceptance criteria:

* The session screen shows the selected chord group.
* The session screen shows the selected BPM.
* The session screen shows the elapsed practice time.
* The session screen shows the chord change counter.