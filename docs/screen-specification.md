# Screen Specification

This document describes the MVP screens of the Android Guitar Practice Trainer app.

The MVP contains two main screens:

1. Practice Setup Screen
2. Practice Session Screen

---

## 1. Practice Setup Screen

The Practice Setup Screen is the first screen shown when the app starts.

Its purpose is to let the user configure a practice session before starting.

### Content

The screen includes:

- App title.
- Short description of the app.
- Chord group selector.
- BPM selector.
- Minimum and maximum BPM labels.
- Selected session summary.
- Start Practice button.
- Metronome sound toggle.
- Individual chord selection.
- Select all and Clear all chord actions.
- Selected chord count.

### Chord group selector

The user can select one predefined chord group.

Current available groups:

- Major chords
- Minor chords
- All chords

Only one chord group can be selected at a time.

### BPM selector

The user can configure the practice tempo using a slider.

Current BPM range:

- Minimum: 30 BPM
- Maximum: 160 BPM

The selected BPM is displayed on screen.

### Selected session summary

Before starting the session, the screen shows a short summary of the selected configuration.

Example:

```text
Selected session
Major chords · 60 BPM
```

### Metronome sound toggle

The user can enable or disable metronome sound before starting a practice session.

When enabled, the Practice Session Screen plays a short beep on each pulse.

When disabled, the visual pulse and chord changes continue without sound.

### Start Practice button

The Start Practice button starts a new practice session using the selected chord group and BPM.

When pressed, the app navigates to the Practice Session Screen.

### Custom chord selection

The user can customize which chords will be used during the practice session.

Chord groups preselect a set of chords, but the user can manually select or unselect individual chords before starting.

The screen also provides Select all and Clear all actions.

The Start Practice button is disabled when no chords are selected.

Chord checkboxes are grouped by chord type and displayed in a compact wrapping layout to reduce vertical scrolling on mobile screens.

---

## 2. Practice Session Screen

The Practice Session Screen is shown during an active practice session.

Its purpose is to guide the user through chord changes using random chord prompts and a visual pulse.

When using custom chord selection, the active session summary shows the selected chord names.

### Content

The screen includes:

- Current chord.
- Generated chord diagram.
- Visual pulse indicator.
- Paused session feedback.
- Active session summary.
- Elapsed practice time.
- Chord change counter.
- Pause / Resume button.
- End Session button.
- When using custom chord selection, the active session summary shows the selected chord names.

### Current chord

The current chord is displayed prominently in large text.

This allows the user to read the chord while practicing guitar.

### Visual pulse indicator

The screen shows a simple pulse indicator.

Example:

```text
Pulse ●
Pulse ○
```

The pulse changes according to the selected BPM.

### Paused feedback

When the session is paused, the screen displays:

```text
Paused
```

The chord, elapsed time and chord change counter stop updating while paused.

### Active session summary

The screen shows the selected chord group, BPM, elapsed time and chord change counter.

Example:

```text
Session
Major chords · 60 BPM
Time: 00:15 · Changes: 3
```

### Elapsed practice time

The elapsed time shows how long the current session has been active.

Format:

```text
MM:SS
```

The timer pauses when the session is paused.

### Chord diagrams

The screen displays a generated chord diagram for the current chord when available.

The diagram shows fret positions, open strings, muted strings and barre chords.

If a diagram is not available for a chord, the screen displays a placeholder message.

### Chord change counter

The chord change counter shows how many chord changes have occurred during the current session.

The counter increases when a new chord is displayed.

The counter does not increase while the session is paused.

### Pause / Resume button

The user can pause and resume the session.

When running, the button displays:

```text
Pause
```

When paused, the button displays:

```text
Resume
```

### End Session button

The End Session button stops the current practice session and returns the user to the Practice Setup Screen.

### Custom chord selection

The user can customize which chords will be used during the practice session.

Chord groups preselect a set of chords, but the user can manually select or unselect individual chords before starting.

The screen also provides Select all and Clear all actions.

The Start Practice button is disabled when no chords are selected.