# Android Guitar Practice Trainer

Android Guitar Practice Trainer is a personal Android project focused on helping guitar learners practice chord changes with a configurable tempo.

The goal of the app is to provide a simple practice tool where users can select groups of chords, set a BPM value, and practice chord changes while the app displays random chords on screen.

## Project status

This project currently includes a basic functional MVP practice flow.

The app can:

- Display a Practice Setup Screen.
- Let the user select a chord group.
- Let the user configure the BPM value.
- Start a practice session.
- Display a random chord from the selected chord group.
- Change chords automatically according to the selected BPM.
- Pause and resume the practice session.
- Stop the session and return to the setup screen.

## Main goal

The first version of the app focuses on one core feature:

- Practicing chord changes using random chord prompts and a configurable tempo.

## Current MVP features

- Chord group selector:
  - Major chords
  - Minor chords
  - All chords
- BPM selector:
  - Minimum: 30 BPM
  - Maximum: 160 BPM
  - Default: 60 BPM
- Practice session screen.
- Random chord display.
- Automatic chord changes based on BPM.
- Pause / Resume control.
- Stop session control.

## Tech stack

Current technologies:

- Kotlin
- Jetpack Compose
- Android Studio
- Material 3
- Git / GitHub

## Project structure

```text
app/src/main/java/com/github/jordiagustin/androidguitarpracticetrainer/
├── data
│   └── ChordRepository.kt
├── model
│   ├── Chord.kt
│   ├── ChordGroup.kt
│   └── PracticeSession.kt
├── practice
├── ui
│   ├── screens
│   │   ├── PracticeSetupScreen.kt
│   │   └── PracticeSessionScreen.kt
│   └── theme
└── MainActivity.kt
```

## Documentation

Project documentation is available in the `/docs` folder.

Current documents:

- `product-definition.md`
- `mvp-definition.md`
- `user-stories.md`
- `navigation-flow.md`
- `screen-specification.md`
- `data-model.md`
- `backlog.md`

## Future improvements

Possible future improvements include:

- Avoid repeating the same chord twice in a row.
- Improve the visual design of the practice screens.
- Add a metronome sound.
- Add a visual pulse indicator.
- Add manual chord selection.
- Add chord diagrams.
- Add practice history.
- Add basic music theory content.
- Add an independent metronome tool.
- Add a guitar tuner.