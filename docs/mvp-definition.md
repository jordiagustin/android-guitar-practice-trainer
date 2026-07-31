# MVP Definition

## 1. MVP goal

The goal of the MVP is to build a simple Android app that allows users to practice guitar chord changes using random chord prompts and a configurable tempo.

The MVP is small, functional and realistic as a first portfolio version.

The current MVP focuses on one core use case:

**Start a chord change practice session and follow random chord prompts at a selected BPM.**

---

## 2. Main feature

The MVP includes one main feature:

**Practice Chords**

This feature allows the user to:

* Select a predefined chord group.
* Set a BPM value.
* Review the selected session configuration.
* Start a practice session.
* Practice random chord changes.
* Pause and resume the session.
* End the session and return to the setup screen.

---

## 3. MVP screens

The MVP includes the following screens:

1. Practice Setup Screen
2. Practice Session Screen

---

## 3.1 Practice Setup Screen

This screen allows the user to configure the practice session before starting.

It includes:

* App title.
* Short app description.
* Chord group selector.
* BPM selector.
* Minimum and maximum BPM labels.
* Selected session summary.
* Start Practice button.

The selected session summary shows the selected chord group and BPM before starting.

Example:

```text
Selected session
Major chords · 60 BPM
```

---

## 3.2 Practice Session Screen

This screen is used during the active practice session.

It includes:

* Current chord displayed in large text.
* Visual pulse indicator.
* Paused session feedback.
* Active session summary.
* Selected chord group.
* Current BPM value.
* Elapsed practice time.
* Chord change counter.
* Pause / Resume button.
* End Session button.

The active session summary shows the selected chord group, BPM, elapsed time and chord change count.

Example:

```text
Session
Major chords · 60 BPM
Time: 00:15 · Changes: 3
```

---

## 4. Chord groups

The MVP includes predefined chord groups.

### Major chords

* A
* B
* C
* D
* E
* F
* G

### Minor chords

* Am
* Bm
* Cm
* Dm
* Em
* Fm
* Gm

### All chords

Includes both major and minor chords.

---

## 5. BPM configuration

The user can configure the tempo in BPM.

For the MVP, the allowed BPM range is:

* Minimum: 30 BPM
* Maximum: 160 BPM
* Default: 60 BPM

The BPM selector allows fine adjustment of the tempo.

The selected BPM is used to calculate the chord change interval and the visual pulse timing.

---

## 6. Chord change behavior

Each visual pulse changes the displayed chord while the session is running.

Example:

* Pulse 1: A
* Pulse 2: D
* Pulse 3: Em
* Pulse 4: G

The app avoids displaying the same chord twice in a row when there is more than one chord available in the selected group.

This keeps the logic simple while making practice more useful.

In future versions, the app may allow changing chords every 2 or 4 beats.

---

## 7. Session controls

The practice session supports:

* Start session.
* Pause session.
* Resume session.
* End session.

When the session is paused:

* Chord changes stop.
* The visual pulse stops updating.
* Elapsed time stops increasing.
* The chord change counter stops increasing.
* A paused feedback message is shown.

When the session is resumed:

* Chord changes continue.
* The visual pulse continues updating.
* Elapsed time continues increasing.
* The chord change counter continues increasing.

When the session is ended:

* The app returns to the Practice Setup Screen.
* A new session can be started.

---

## 8. Session tracking

The MVP includes basic session tracking during an active practice session.

Current tracking values:

* Elapsed practice time.
* Chord change counter.

Elapsed practice time is displayed in MM:SS format.

Example:

```text
Time: 00:45
```

The chord change counter shows how many chord changes have occurred during the current session.

Example:

```text
Changes: 12
```

Both values reset when a new session starts.

---

## 9. What the MVP does not include

The MVP does not include:

* Manual chord selection.
* Tuner.
* Theory section.
* Tablatures.
* Practice history.
* User accounts.
* Database.
* Cloud sync.
* Advanced metronome settings.
* Chord diagrams.
* Metronome sound.
* Custom chord groups.
* Changing chords every 2 or 4 beats.

These features may be considered in future versions.

---

## 10. Success criteria

The MVP will be considered complete when:

* The user can select a chord group.
* The user can set a BPM value.
* The user can start a practice session.
* The app displays random chords based on the selected group.
* The displayed chord changes according to the BPM.
* The app avoids showing the same chord twice in a row.
* The user can pause and resume the session.
* The user can end the session and return to the setup screen.
* The app shows a visual pulse indicator.
* The app shows elapsed practice time.
* The app shows a chord change counter.
* The project is documented in GitHub.

## Current status

The core MVP is completed.

The app now includes additional post-MVP functionality, including generated chord diagrams for supported major and minor chords.

Chord diagrams are generated from structured data instead of image files.

The app has also been tested on a physical Android device to verify the practice flow, metronome sound and chord diagram display outside the emulator.