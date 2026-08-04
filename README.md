# Android Guitar Practice Trainer

Android Guitar Practice Trainer is a focused practice app for training guitar chord changes with custom chord selection, BPM-based prompts, optional metronome sound and generated chord diagrams.

The goal of the app is to provide a simple practice tool where users can choose the exact chords they want to practice, set a BPM value, and train chord changes while the app displays random chord prompts on screen.

## Project status

Current status: **Core MVP completed and expanded with post-MVP product improvements**

The app includes a functional three-screen practice flow:

```text
Practice Setup → Practice Session → Practice Summary
```

Current capabilities include:

- Custom chord selection before starting a practice session.
- Chord group presets.
- Select all and Clear all chord actions.
- BPM configuration.
- Random chord changes.
- Prevention of repeated chords twice in a row when alternatives exist.
- Visual pulse indicator.
- Optional metronome sound.
- Pause / Resume support.
- Elapsed practice time.
- Chord change counter.
- Generated chord diagrams for supported major and minor chords.
- Support for fretted positions, open strings, muted strings and barre chord diagrams.
- Final practice summary after ending a session.
- Unit tests for practice logic, chord selection and chord diagram data.
- Project documentation.

Next development phase: visual design improvements, practice history, saved practice presets and release preparation.

## Screenshots

Screenshots will be added to show the main app flow:

- Practice Setup Screen
- Practice Session Screen
- Practice Summary Screen

Planned screenshots:

- Custom chord selection and BPM setup.
- Active practice session with chord diagram.
- Final practice summary after ending a session.

## Main goal

The app focuses on one core use case:

- Practicing guitar chord changes using custom chord selection, random chord prompts and a configurable tempo.

## Current features

- Chord group selector:
  - Major chords
  - Minor chords
  - All chords
- Custom chord selection before starting a practice session.
- Compact chord checkbox layout grouped by chord type.
- Select all and Clear all actions for faster chord selection.
- Setup and session summaries show selected chord names or chord count.
- BPM selector:
  - Minimum: 30 BPM
  - Maximum: 160 BPM
  - Default: 60 BPM
- Practice session screen.
- Random chord display.
- Automatic chord changes based on BPM.
- Prevention of repeated chords twice in a row when alternatives exist.
- Visual pulse indicator.
- Optional metronome sound.
- Metronome sound can be enabled or disabled before starting a session.
- Pause / Resume control.
- End Session control.
- Generated chord diagrams for supported major and minor chords.
- Chord diagrams show fretted positions, open strings, muted strings and barre positions.
- Final practice summary after ending a session.
- Summary includes elapsed time, chord changes, BPM and practiced chords.

## Tech stack

Current technologies:

- Kotlin
- Jetpack Compose
- Android Studio
- Material 3
- Git / GitHub

## Current project structure

The project separates basic responsibilities into packages:

- `model`: core data models such as chords, chord groups, chord diagrams and practice session summaries.
- `data`: predefined chord and chord diagram data.
- `practice`: practice-related logic such as chord selection, random chord selection and timer calculations.
- `ui.screens`: Jetpack Compose screens.
- `ui.components`: reusable UI components.
- `ui.theme`: Compose theme configuration.
- `app/src/test`: unit tests.

```text
app/src/main/java/com/github/jordiagustin/androidguitarpracticetrainer/
├── data
│   ├── ChordDiagramRepository.kt
│   └── ChordRepository.kt
├── model
│   ├── Chord.kt
│   ├── ChordDiagram.kt
│   ├── ChordGroup.kt
│   ├── PracticeSession.kt
│   └── PracticeSessionSummary.kt
├── practice
│   ├── ChordSelection.kt
│   ├── ChordSelector.kt
│   ├── PracticeConfig.kt
│   └── PracticeTimer.kt
├── ui
│   ├── components
│   │   └── ChordDiagramView.kt
│   ├── screens
│   │   ├── PracticeSetupScreen.kt
│   │   ├── PracticeSessionScreen.kt
│   │   └── PracticeSummaryScreen.kt
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

## Tests

The project includes unit tests for practice logic and chord diagram data.

Current tested components:

- `PracticeTimer`
- `ChordSelector`
- `ChordSelection`
- `ChordDiagramRepository`

The tests verify:

- BPM interval calculation.
- Elapsed time formatting.
- Invalid BPM validation.
- Random chord selection from a chord list.
- Prevention of repeated chords when alternatives exist.
- Empty chord list validation.
- Adding and removing selected chords.
- Prevention of duplicate selected chords.
- Chord diagram lookup by chord name.
- Missing chord diagram behavior.
- Barre chord diagram data.
- Diagram availability for all currently supported chords.

To run the unit tests on macOS or Linux:

```bash
./gradlew test
```

To run the unit tests on Windows:

```bash
.\gradlew test
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

## Physical device testing

The app has been installed and tested on a physical Android device.

Validated behavior:

- App installation from Android Studio.
- Practice setup flow.
- Custom chord selection.
- Select all and Clear all chord actions.
- Practice session flow.
- Pause / Resume controls.
- End Session control.
- Practice summary screen.
- Optional metronome sound.
- Chord diagram display on a real screen.

## Architecture overview

The project is organized into small packages with clear responsibilities.

- `model`: contains the core data models, such as `Chord`, `ChordGroup`, `ChordType`, `ChordDiagram` and `PracticeSessionSummary`.
- `data`: contains predefined chord data and chord diagram data.
- `practice`: contains practice-related logic, such as chord selection, BPM configuration and timer calculations.
- `ui.components`: contains reusable UI components, such as the generated chord diagram view.
- `ui.screens`: contains the Jetpack Compose screens.
- `ui.theme`: contains the Compose theme configuration.
- `app/src/test`: contains unit tests for practice logic and chord diagram data.

This separation keeps UI code focused on presentation while practice logic remains easier to test and maintain.

## Roadmap

Possible future improvements:

- Improve visual design.
- Add saved practice presets.
- Add practice history.
- Allow changing chords every 2 or 4 beats.
- Add additional chord types.
- Add additional practice modes.
- Add dark mode support.
- Prepare signed release build.
- Prepare Google Play internal testing release.