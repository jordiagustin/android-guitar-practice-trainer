1. Purpose

This document summarizes the main Android development concepts practiced while building Android Guitar Practice Trainer.

The goal is to document the project as a learning and portfolio exercise, not only as a finished app.

2. Kotlin fundamentals

The project practices basic Kotlin concepts such as:

Data classes.
Enum classes.
Objects.
Functions.
Immutable and mutable values.
Lists and filtering.
Null-safe values.
Basic validation with require.

Examples in the project:

Chord
ChordGroup
ChordType
PracticeSession
PracticeSessionSummary
ChordSelector
PracticeTimer
3. Jetpack Compose UI

The project uses Jetpack Compose to build the app interface.

Concepts practiced:

Composable functions.
Screen-based UI structure.
Text, Button, Checkbox, RadioButton and Slider components.
Layouts using Column, Row and FlowRow.
Spacing and padding with Modifier.
Scrollable screens.
Basic visual polish.
Preview functions.

Main screens:

PracticeSetupScreen
PracticeSessionScreen
PracticeSummaryScreen

Reusable UI components:

ChordDiagramView
4. Compose state management

The app practices basic Compose state management.

Concepts practiced:

remember
mutableStateOf
mutableFloatStateOf
UI recomposition
Passing state between composables
Updating state from user actions

Examples:

Selected chord group.
Selected chords.
BPM value.
Metronome sound setting.
Current chord.
Pause state.
Elapsed time.
Chord change counter.
Practice summary state.
5. Callback-based screen communication

The app uses callbacks to communicate between screens.

Concepts practiced:

Passing functions as parameters.
Sending selected setup values to the session screen.
Sending final session results to the summary screen.
Keeping screen logic separated from app navigation state.

Examples:

onStartPractice
onEndSession
onStartNewSession
6. Basic app flow

The app implements a simple three-screen flow:

Practice Setup → Practice Session → Practice Summary

This flow helped practice:

Screen switching.
Shared state in MainActivity.
Passing data between screens.
Resetting state for a new session.
Avoiding unsafe null assertions.
7. Timer and session logic

The practice session uses timer-based behavior.

Concepts practiced:

LaunchedEffect
Coroutine delay.
BPM to milliseconds conversion.
Repeated timed updates.
Pause / Resume behavior.
Separating timer calculation logic from UI code.

Examples:

PracticeTimer.calculateIntervalMillis
PracticeTimer.formatElapsedTime
8. Random chord selection logic

The app includes random chord selection logic.

Concepts practiced:

Selecting random items from a list.
Avoiding repeated values when alternatives exist.
Handling edge cases.
Rejecting invalid empty lists.

Example:

ChordSelector.getRandomChordExcludingCurrent
9. Custom chord selection logic

The app supports selecting the exact chords used in a practice session.

Concepts practiced:

Checkbox-based selection.
Adding and removing items from a list.
Avoiding duplicate selected chords.
Disabling actions when state is invalid.
Extracting selection logic away from the UI.

Example:

ChordSelection.updateSelectedChords
10. Generated chord diagrams

The project includes generated chord diagrams drawn from structured data.

Concepts practiced:

Modeling visual data.
Drawing custom UI with Canvas.
Representing fretted, open and muted strings.
Representing barre chords.
Keeping diagrams data-driven instead of image-based.

Examples:

ChordDiagram
StringPosition
StringStatus
BarrePosition
ChordDiagramRepository
ChordDiagramView
11. Unit testing

The project includes unit tests for non-UI logic.

Tested components:

PracticeTimer
ChordSelector
ChordSelection
ChordDiagramRepository

Concepts practiced:

Testing expected outputs.
Testing invalid inputs.
Testing edge cases.
Testing data availability.
Keeping logic separated from UI to make it easier to test.
12. Project organization

The project is organized into packages with separate responsibilities.

Main packages:

model
data
practice
ui.screens
ui.components
ui.theme

This helped practice a basic separation between:

Data models.
Predefined data.
Practice logic.
UI screens.
Reusable UI components.
Tests.
13. Git and GitHub workflow

The project was developed using Git and GitHub.

Concepts practiced:

Creating a repository.
Making incremental commits.
Pushing changes to GitHub.
Updating documentation.
Keeping a backlog.
Preparing the repository for portfolio presentation.
14. Manual testing

The app was tested on a physical Android device.

Validated areas:

App installation.
Practice setup flow.
Custom chord selection.
Practice session flow.
Pause / Resume.
End Session.
Practice summary screen.
Optional metronome sound.
Generated chord diagrams.
15. Summary

This project was useful to practice a complete small Android app workflow:

Define a focused product idea.
Build a functional MVP.
Add controlled post-MVP improvements.
Separate logic from UI.
Add unit tests.
Document the project.
Prepare the repository for portfolio use.

