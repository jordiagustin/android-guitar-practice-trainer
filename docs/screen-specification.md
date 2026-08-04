# Screen Specification

The app contains three main screens:

1. Practice Setup Screen
2. Practice Session Screen
3. Practice Summary Screen

---

## 1. Practice Setup Screen

The Practice Setup Screen is the first screen shown when the app starts.

Its purpose is to let the user configure a practice session before starting.

### Content

The screen includes:

- App title.
- Short description of the app.
- Chord group selector.
- Individual chord selection.
- Select all and Clear all chord actions.
- Selected chord count.
- BPM selector.
- Minimum and maximum BPM labels.
- Metronome sound toggle.
- Selected session summary.
- Start Practice button.

### Chord group selector

The user can select one predefined chord group.

Current available groups:

- Major chords
- Minor chords
- All chords

Only one chord group can be selected at a time.

Chord groups preselect a set of chords, but the user can customize the final chord selection before starting the session.

### Custom chord selection

The user can customize which chords will be used during the practice session.

The user can manually select or unselect individual chords before starting.

The screen also provides Select all and Clear all actions.

Chord checkboxes are grouped by chord type and displayed in a compact wrapping layout to reduce vertical scrolling on mobile screens.

The screen displays the number of selected chords.

The Start Practice button is disabled when no chords are selected.

### BPM selector

The user can configure the practice tempo using a slider.

Current BPM range:

- Minimum: 30 BPM
- Maximum: 160 BPM

The selected BPM is displayed on screen.

### Metronome sound toggle

The user can enable or disable metronome sound before starting a practice session.

When enabled, the Practice Session Screen plays a short beep on each pulse.

When disabled, the visual pulse and chord changes continue without sound.

### Selected session summary

Before starting the session, the screen shows a short summary of the selected configuration.

When a small number of chords is selected, the summary shows the selected chord names.

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

### Start Practice button

The Start Practice button starts a new practice session using the selected chords, BPM and metronome sound setting.

When pressed, the app navigates to the Practice Session Screen.

---

## 2. Practice Session Screen

The Practice Session Screen is shown during an active practice session.

Its purpose is to guide the user through chord changes using random chord prompts, a visual pulse and optional metronome sound.

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

### Current chord

The current chord is displayed prominently in large text.

This allows the user to read the chord while practicing guitar.

### Chord diagrams

The screen displays a generated chord diagram for the current chord when available.

The diagram shows fret positions, open strings, muted strings and barre chords.

If a diagram is not available for a chord, the screen displays a placeholder message.

### Visual pulse indicator

The screen shows a simple pulse indicator.

Example:

```text
Pulse ●
Pulse ○
```

The pulse changes according to the selected BPM.

When metronome sound is enabled, the app plays a short beep on each pulse.

### Paused feedback

When the session is paused, the screen displays:

```text
Paused
```

While paused:

- Chord changes stop.
- The visual pulse stops updating.
- Metronome sound stops.
- Elapsed time stops increasing.
- The chord change counter stops increasing.

### Active session summary

The screen shows the selected chords or selected chord count, BPM, elapsed time and chord change counter.

Example with a small chord selection:

```text
Session
Custom selection · A, D, Em · 60 BPM
Time: 00:15 · Changes: 3
```

Example with many selected chords:

```text
Session
Custom selection · 14 chords · 60 BPM
Time: 00:15 · Changes: 3
```

### Elapsed practice time

The elapsed time shows how long the current session has been active.

Format:

```text
MM:SS
```

The timer pauses when the session is paused.

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

The End Session button stops the current practice session.

When pressed, the app creates a final session summary and navigates to the Practice Summary Screen.

---

## 3. Practice Summary Screen

The Practice Summary Screen is shown after the user ends an active practice session.

Its purpose is to show the final result of the completed practice session before returning to setup.

### Content

The screen includes:

- Practice finished title.
- Session result card.
- Final elapsed practice time.
- Final chord change counter.
- Session BPM.
- Practiced chord names.
- Start new session button.

### Session result

The session result card displays the final practice statistics.

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

### Start new session button

The Start new session button returns the user to the Practice Setup Screen.