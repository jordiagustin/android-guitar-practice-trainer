# Navigation Flow

## 1. Current navigation approach

The app uses a simple three-screen navigation flow focused on chord change practice.

The goal is to keep the app focused, functional and easy to use while allowing the user to configure a practice session, practice chord changes and review the final session result.

## 2. Screens

The app includes the following screens:

1. Practice Setup Screen
2. Practice Session Screen
3. Practice Summary Screen

## 3. Navigation diagram

```text
Practice Setup Screen
        |
        | Start Practice
        v
Practice Session Screen
        |
        | End Session
        v
Practice Summary Screen
        |
        | Start new session
        v
Practice Setup Screen
```

Pause and Resume happen inside the Practice Session Screen and do not change the current screen.

## 4. Practice Setup Screen

This is the first screen shown when the app starts.

The user can configure the practice session before starting.

Main elements:

* App title.
* Short app description.
* Chord group selector.
* Individual chord selection.
* Select all and Clear all chord actions.
* Selected chord count.
* BPM selector.
* Minimum and maximum BPM labels.
* Metronome sound toggle.
* Selected session summary.
* Start Practice button.

User actions:

* Select chord group.
* Customize selected chords.
* Select all chords in the current group.
* Clear all selected chords.
* Change BPM value.
* Enable or disable metronome sound.
* Review the selected session summary.
* Start practice session.

Chord groups preselect a set of chords, but the user can customize the final chord selection before starting the session.

The Start Practice button is disabled when no chords are selected.

When the user presses Start Practice, the app navigates to the Practice Session Screen.

The selected chords, BPM and metronome sound setting are passed from the setup screen to the session screen.

## 5. Practice Session Screen

This screen is shown while the user is practicing.

Main elements:

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

User actions:

* Pause the session.
* Resume the session.
* End the session.

During the session, the app randomly displays chords from the selected chord list.

The app avoids showing the same chord twice in a row when alternatives exist.

The chord changes follow the selected BPM.

When metronome sound is enabled, the app plays a short beep on each pulse.

When the user presses End Session, the app creates a final session summary and navigates to the Practice Summary Screen.

## 6. Practice Summary Screen

This screen is shown after the user ends an active practice session.

Its purpose is to show the final result of the completed practice session before returning to setup.

Main elements:

* Practice finished title.
* Session result card.
* Final elapsed practice time.
* Final chord change counter.
* Session BPM.
* Practiced chord names.
* Start new session button.

User actions:

* Review the completed practice session result.
* Start a new session.

When the user presses Start new session, the app returns to the Practice Setup Screen.

## 7. Navigation rules

* The app starts on the Practice Setup Screen.
* The Start Practice button opens the Practice Session Screen.
* The End Session button opens the Practice Summary Screen.
* The Start new session button returns to the Practice Setup Screen.
* The Pause button does not change screen.
* The Resume button does not change screen.
* The selected chords, BPM and metronome sound setting are passed from the setup screen to the session screen.
* The final elapsed time, chord change counter, BPM and practiced chords are passed from the session screen to the summary screen.
* A new practice session starts with its own elapsed time and chord change counter.

## 8. Pause / Resume behavior

Pause and Resume only affect the active session state.

When the session is paused:

* Chord changes stop.
* The visual pulse stops updating.
* Metronome sound stops.
* Elapsed time stops increasing.
* The chord change counter stops increasing.
* The user stays on the Practice Session Screen.

When the session is resumed:

* Chord changes continue.
* The visual pulse continues updating.
* Metronome sound continues if enabled.
* Elapsed time continues increasing.
* The chord change counter continues increasing.
* The user stays on the Practice Session Screen.

## 9. Flow summary

```text
Configure practice
        ↓
Practice chord changes
        ↓
Review session result
        ↓
Start a new session
```

## 10. Future navigation

Future versions may include additional screens or sections such as:

* Saved practice presets
* Practice history
* Settings
* Additional chord types
* Additional practice modes

These sections are intentionally excluded from the current version to keep the app focused and achievable.