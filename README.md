# Android Guitar Practice Trainer

Android Guitar Practice Trainer is a personal Android project focused on helping guitar learners practice chord changes with a configurable tempo.

The goal of the app is to provide a simple practice tool where users can select groups of chords, set a BPM value, and practice chord changes while the app displays random chords on screen.

## Project status

Current status: **Core MVP completed**

The app includes a functional two-screen practice flow with:

- Chord group selection.
- BPM configuration.
- Random chord changes.
- Prevention of repeated chords twice in a row.
- Visual pulse indicator.
- Pause / Resume support.
- Elapsed practice time.
- Chord change counter.
- Start and active session summaries.
- Unit tests for practice logic.
- Project documentation.

Next development phase: product improvements such as metronome sound, chord diagrams and visual design improvements.

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

## Current project structure

The project separates basic responsibilities into packages:

- `model`: core data models such as chords, chord groups and practice sessions.
- `data`: predefined chord data used by the MVP.
- `practice`: practice-related logic such as chord selection and timer calculations.
- `ui.screens`: Jetpack Compose screens.
- `ui.theme`: Compose theme configuration.

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
- `docs/screen-specification.md`

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

## Tests

The project includes basic unit tests for practice logic components.

Current tested components:

- `PracticeTimer`
- `ChordSelector`

The tests verify:

- BPM interval calculation.
- Elapsed time formatting.
- Invalid BPM validation.
- Random chord selection from a chord list.
- Prevention of repeated chords when alternatives exist.
- Empty chord list validation.

To run the tests:

```bash
./gradlew test
```

## How to run the project

1. Clone the repository:

```bash
git clone https://github.com/jordiagustin/android-guitar-practice-trainer.git
```

2. Open the project with Android Studio.

3. Wait for Gradle Sync to finish.

4. Select an Android emulator or a connected Android device.

5. Run the app using the Android Studio **Run** button.

The project should open directly on the **Practice Setup Screen**.

---

## Tests

The project includes basic unit tests for practice logic components.

Current tested components:

- `PracticeTimer`
- `ChordSelector`

The tests verify:

- BPM interval calculation.
- Elapsed time formatting.
- Invalid BPM validation.
- Random chord selection from a chord list.
- Prevention of repeated chords when alternatives exist.
- Empty chord list validation.

To run the unit tests on macOS or Linux:

```bash
./gradlew test
```

To run the unit tests on Windows:

```bash
.\gradlew test
```

## Architecture overview

The project is organized into small packages with clear responsibilities.

- `model`: contains the core data models, such as `Chord`, `ChordGroup`, `ChordType` and `PracticeSession`.
- `data`: contains predefined chord data used by the MVP.
- `practice`: contains practice-related logic, such as chord selection, BPM configuration and timer calculations.
- `ui.screens`: contains the Jetpack Compose screens.
- `ui.theme`: contains the Compose theme configuration.
- `app/src/test`: contains unit tests for practice logic.

This separation keeps UI code focused on presentation while practice logic remains easier to test and maintain.

---

## Roadmap

Possible future improvements:

- Add metronome sound.
- Add chord diagrams.
- Allow custom chord groups.
- Allow changing chords every 2 or 4 beats.
- Add practice history.
- Add basic session statistics.
- Improve visual design.
- Add dark mode support.
- Add instrument-specific practice modes.

---

