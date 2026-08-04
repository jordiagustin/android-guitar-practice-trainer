# MVP Definition

## 1. MVP goal

The original goal of the MVP was to build a simple Android app that allows users to practice guitar chord changes using random chord prompts and a configurable tempo.

The MVP was designed to be small, functional and realistic as a first portfolio version.

The original MVP focused on one core use case:

**Start a chord change practice session and follow random chord prompts at a selected BPM.**

The core MVP has been completed. The app now also includes post-MVP product improvements such as custom chord selection, generated chord diagrams, optional metronome sound and a final practice summary screen.

---

## 2. Main feature

The main feature of the app is:

**Practice Chords**

This feature allows the user to:

* Select a predefined chord group.
* Customize the exact chords used in the session.
* Set a BPM value.
* Enable or disable metronome sound.
* Review the selected session configuration.
* Start a practice session.
* Practice random chord changes.
* View generated chord diagrams.
* Pause and resume the session.
* End the session.
* Review a final practice summary.

---

## 3. Current screens

The app currently includes the following screens:

1. Practice Setup Screen
2. Practice Session Screen
3. Practice Summary Screen

---

## 3.1 Practice Setup Screen

This screen allows the user to configure the practice session before starting.

It includes:

* App title.
* Short app description.
* Chord group selector.
* Custom chord selection.
* Compact chord checkbox layout grouped by chord type.
* Select all and Clear all chord actions.
* Selected chord count.
* BPM selector.
* Minimum and maximum BPM labels.
* Metronome sound toggle.
* Selected session summary.
* Start Practice button.

Chord groups preselect a set of chords, but the user can customize the final chord selection before starting the session.

The Start Practice button is disabled when no chords are selected.

The selected session summary shows the selected chords or chord count, plus the selected BPM.

Example:

```text
Selected session
Custom selection · A, D, Em · 3 chords · 60 BPM
```

When many chords are selected, the summary is shortened to keep it readable.

Example:

```text
Selected session
Custom selection · 14 chords · 60 BPM
```

---

## 3.2 Practice Session Screen

This screen is used during the active practice session.

It includes:

* Current chord displayed in large text.
* Generated chord diagram.
* Visual pulse indicator.
* Paused session feedback.
* Active session summary.
* Selected chord names or selected chord count.
* Current BPM value.
* Elapsed practice time.
* Chord change counter.
* Pause / Resume button.
* End Session button.

The active session summary shows the selected chords or chord count, BPM, elapsed time and chord change count.

Example:

```text
Session
Custom selection · A, D, Em · 60 BPM
Time: 00:15 · Changes: 3
```

During the session, the app randomly displays chords from the selected chord list.

The app avoids displaying the same chord twice in a row when there is more than one chord available.

When metronome sound is enabled, the app plays a short beep on each pulse.

---

## 3.3 Practice Summary Screen

This screen is shown after the user ends an active practice session.

It includes:

* Practice finished title.
* Session result card.
* Final elapsed practice time.
* Final chord change counter.
* Session BPM.
* Practiced chord names.
* Start new session button.

Example:

```text
Practice finished

Session result

Time: 02:35
Changes: 47
BPM: 80

Chords:
A, D, Em
```

When the user presses Start new session, the app returns to the Practice Setup Screen.

---

## 4. Chord groups

The app includes predefined chord groups.

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

The user can start from one of these groups and then customize the selected chords manually.

---

## 5. Custom chord selection

The app supports custom chord selection before starting a practice session.

The user can:

* Select individual chords.
* Clear all selected chords.
* Select all chords from the current group.
* See the selected chord count.
* Review selected chord names or chord count in the setup summary.

This allows focused practice with specific chord combinations.

Example:

```text
A, D, Em
```

---

## 6. BPM configuration

The user can configure the tempo in BPM.

The allowed BPM range is:

* Minimum: 30 BPM
* Maximum: 160 BPM
* Default: 60 BPM

The selected BPM is used to calculate:

* Chord change interval.
* Visual pulse timing.
* Optional metronome sound timing.

---

## 7. Chord change behavior

Each visual pulse changes the displayed chord while the session is running.

Example:

* Pulse 1: A
* Pulse 2: D
* Pulse 3: Em
* Pulse 4: G

The app avoids displaying the same chord twice in a row when there is more than one selected chord available.

This keeps the logic simple while making practice more useful.

In future versions, the app may allow changing chords every 2 or 4 beats.

---

## 8. Chord diagrams

The app includes generated chord diagrams for all currently supported major and minor chords.

Chord diagrams are generated from structured data instead of image files.

The diagrams show:

* Fretted positions.
* Open strings.
* Muted strings.
* Barre chord positions.

This keeps the diagrams lightweight, consistent and easier to maintain.

---

## 9. Session controls

The practice session supports:

* Start session.
* Pause session.
* Resume session.
* End session.
* Start new session from the summary screen.

When the session is paused:

* Chord changes stop.
* The visual pulse stops updating.
* Metronome sound stops.
* Elapsed time stops increasing.
* The chord change counter stops increasing.
* A paused feedback message is shown.

When the session is resumed:

* Chord changes continue.
* The visual pulse continues updating.
* Metronome sound continues if enabled.
* Elapsed time continues increasing.
* The chord change counter continues increasing.

When the session is ended:

* The app creates a final practice summary.
* The app navigates to the Practice Summary Screen.
* The user can start a new session from the summary screen.

---

## 10. Session tracking

The app includes basic session tracking during an active practice session and in the final summary.

Current tracking values:

* Elapsed practice time.
* Chord change counter.
* Session BPM.
* Practiced chords.

Elapsed practice time is displayed in MM:SS format.

Example:

```text
Time: 00:45
```

The chord change counter shows how many chord changes occurred during the session.

Example:

```text
Changes: 12
```

Both values reset when a new session starts.

---

## 11. What the original MVP did not include

The original MVP did not include:

* Custom chord selection.
* Generated chord diagrams.
* Metronome sound.
* Practice summary screen.
* Compact chord selection layout.
* Chord diagram barre support.

These features have now been added as post-MVP product improvements.

The app still does not include:

* Tuner.
* Theory section.
* Tablatures.
* Practice history.
* Saved practice presets.
* User accounts.
* Database.
* Cloud sync.
* Advanced metronome settings.
* Changing chords every 2 or 4 beats.

These features may be considered in future versions.

---

## 12. Original MVP success criteria

The original MVP was considered complete when:

* The user could select a chord group.
* The user could set a BPM value.
* The user could start a practice session.
* The app displayed random chords based on the selected group.
* The displayed chord changed according to the BPM.
* The app avoided showing the same chord twice in a row.
* The user could pause and resume the session.
* The user could end the session.
* The app showed a visual pulse indicator.
* The app showed elapsed practice time.
* The app showed a chord change counter.
* The project was documented in GitHub.

These criteria have been completed.

---

## 13. Current status

The core MVP is completed.

The app now includes additional post-MVP functionality:

* Custom chord selection.
* Compact chord selection layout.
* Optional metronome sound.
* Generated chord diagrams for supported major and minor chords.
* Barre chord support.
* Final practice summary screen.
* Physical device testing.
* Unit tests for practice logic, chord selection and chord diagram data.

The app has been tested on a physical Android device to verify the practice flow, custom chord selection, metronome sound, chord diagram display and final summary screen outside the emulator.