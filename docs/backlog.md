# Project Backlog

## 1. Purpose

This document defines the initial development backlog for the MVP.

The backlog converts the product definition, user stories, screen specification and data model into small development tasks.

---

## 2. MVP backlog

### B-001 — Create Android project

Create a new Android project using Kotlin and Jetpack Compose.

Related documents:

- MVP Definition
- Screen Specification

Status:

- Done

Notes:

- Initial Android project created with Kotlin and Jetpack Compose.
- Project pushed to GitHub.

---

### B-002 — Create basic project structure

Create the initial package structure for the app.

Initial areas:

* ui
* model
* data
* practice

Status:

- In progress

Notes:

- Initial package structure started.
- model package created.
- data and practice packages will be completed when their first files are added.

---

### B-003 — Define Chord model

Create the Chord model based on the data model document.

Related user stories:

* US-004 — Display random chord

Status:

- Done

Notes:

- Chord model and ChordType enum created.

---

### B-004 — Define ChordGroup model

Create the ChordGroup model based on the data model document.

Related user stories:

* US-001 — Select chord group

Status:

- Done

Notes:

- ChordGroup model created with a name and a list of chords.

---

### B-005 — Define PracticeSession model

Create the PracticeSession model based on the data model document.

Related user stories:

* US-003 — Start practice session
* US-006 — Pause and resume session
* US-007 — Stop session

Status:

- Done

---

### B-006 — Create predefined chord groups

Create predefined chord groups for:

* Major chords
* Minor chords
* All chords

Related user stories:

* US-001 — Select chord group

Status:

* Done

---

### B-007 — Build Practice Setup Screen UI

Create the Practice Setup Screen with:

* App title
* Short description
* Chord group selector
* BPM selector
* Start button

Related user stories:

* US-001 — Select chord group
* US-002 — Configure BPM
* US-003 — Start practice session

Status:

* In progress


Notes:

- Initial Practice Setup Screen created with title, description, chord group text, BPM text, slider and Start button.
- Screen connected to MainActivity and running on emulator.
---

### B-008 — Implement BPM selector

Allow the user to configure BPM.

Rules:

* Minimum: 30 BPM
* Maximum: 160 BPM
* Default: 60 BPM

Related user stories:

* US-002 — Configure BPM

Status:

* Done

---

### B-009 — Implement chord group selector

Allow the user to select between:

* Major chords
* Minor chords
* All chords

Related user stories:

* US-001 — Select chord group

Status:

* Done

---

### B-010 — Build Practice Session Screen UI

Create the Practice Session Screen with:

* Current chord
* BPM value
* Pulse indicator
* Pause / Resume button
* Stop button

Related user stories:

* US-004 — Display random chord
* US-005 — Metronome pulse
* US-006 — Pause and resume session
* US-007 — Stop session

Status:

* Done

---

### B-011 — Implement random chord selection

Display a random chord from the selected chord group.

Related user stories:

* US-004 — Display random chord

Status:

* Done

---

### B-012 — Implement practice timer

Implement timing logic based on BPM.

Rules:

* The chord changes on each pulse.
* The pulse interval is calculated from the BPM.

Related user stories:

* US-004 — Display random chord
* US-005 — Metronome pulse

Status:

* Done

---

### B-013 — Implement pause and resume

Allow the user to pause and resume the active practice session.

Related user stories:

* US-006 — Pause and resume session

Status:

* Done

---

### B-014 — Implement stop session

Allow the user to stop the session and return to the setup screen.

Related user stories:

* US-007 — Stop session

Status:

* Done

---

### B-015 — Update README with project status

Update the README to reflect the current MVP implementation status.

The README should mention that the app already includes a basic functional practice flow:

- Practice Setup Screen.
- Chord group selector.
- BPM selector.
- Practice Session Screen.
- Random chord display.
- Automatic chord changes based on BPM.
- Pause and resume.
- Stop session and return to setup.

Status:

* Done

---

### B-016 — Avoid repeating the same chord twice

Improve the random chord selection logic so that the same chord is not displayed twice in a row when there is more than one chord available.

Related user stories:

- US-004 — Display random chord

Status:

- Done

---

### B-017 — Add visual pulse indicator

Add a simple visual pulse indicator to the Practice Session Screen.

The indicator should change on each BPM interval to give the user visual feedback that the metronome pulse is active.

Related user stories:

- US-005 — Metronome pulse

Status:

- Done

---

### B-018 — Improve practice session display

Improve the Practice Session Screen layout to make the current chord easier to read during practice.

The current chord should be visually prominent and readable from a comfortable playing position.

Related user stories:

- US-004 — Display random chord
- US-005 — Metronome pulse

Status:

- Done

---

### B-019 — Improve Practice Setup Screen display

Improve the Practice Setup Screen layout to make the initial configuration screen clearer and easier to use.

The screen should present the app title, chord group selector, BPM selector and Start button in a more readable way.

Related user stories:

- US-001 — Select chord group
- US-002 — Configure BPM
- US-003 — Start practice session

Status:

- Done

---

### B-020 — Refactor chord selection logic

Move the random chord selection logic from the Practice Session Screen to a dedicated practice logic file.

The goal is to keep UI code focused on displaying the screen and move practice-related logic to the `practice` package.

Related user stories:

- US-004 — Display random chord

Status:

- Done

---

### B-021 — Add paused session feedback

Show a clear visual message when the practice session is paused.

The goal is to make the session state easier to understand while practicing.

Related user stories:

- US-006 — Pause and resume practice session

Status:

- Done

---

### B-022 — Add elapsed practice time

Show the elapsed practice time during an active practice session.

The timer should increase while the session is running and stop increasing while the session is paused.

Related user stories:

- US-004 — Display random chord
- US-006 — Pause and resume practice session

Status:

- Done

---

### B-023 — Reset elapsed time when session starts

Ensure that elapsed practice time starts from 00:00 every time a new practice session begins.

The timer should not keep the previous session time after stopping and starting again.

Related user stories:

- US-003 — Start practice session
- US-007 — Stop practice session

Status:

- Done

---

### B-024 — Add chord change counter

Show the number of chord changes completed during an active practice session.

The counter should increase when a new chord is displayed and should stop increasing while the session is paused.

Related user stories:

- US-004 — Display random chord
- US-006 — Pause and resume practice session

Status:

- Done

---

### B-025 — Use BPM steps of 5

Make the BPM selector increase and decrease in steps of 5 BPM.

This makes tempo selection clearer and more practical for guitar practice.

Related user stories:

- US-002 — Configure BPM

Status:

- Rejected

---

### B-025 — Add selected session summary

Improve the Practice Session Screen by grouping session information into a clearer summary.

The screen should show the selected chord group, BPM, elapsed time and chord change count in a more readable way.

Related user stories:

- US-001 — Select chord group
- US-002 — Configure BPM
- US-004 — Display random chord

Status:

- Done

---

### B-026 — Add start session summary

Show a short summary of the selected practice configuration on the Practice Setup Screen.

The summary should display the selected chord group and BPM before starting the practice session.

Related user stories:

- US-001 — Select chord group
- US-002 — Configure BPM
- US-003 — Start practice session

Status:

- Done

---

### B-027 — Improve stop button label

Rename the Stop button to make its action clearer to the user.

The button should clearly indicate that it ends the current practice session and returns to the setup screen.

Related user stories:

- US-007 — Stop practice session

Status:

- Done

---

### B-028 — Add BPM range labels

Show the minimum and maximum BPM values below the BPM slider.

The goal is to make the available tempo range clearer on the Practice Setup Screen.

Related user stories:

- US-002 — Configure BPM

Status:

- Done

---

### B-029 — Improve setup screen spacing

Improve vertical spacing on the Practice Setup Screen to make the layout easier to read.

The goal is to separate the title, chord group selector, BPM selector, selected session summary and start button more clearly.

Related user stories:

- US-001 — Select chord group
- US-002 — Configure BPM
- US-003 — Start practice session

Status:

- Done

---

### B-030 — Improve session screen spacing

Improve vertical spacing on the Practice Session Screen to make the current chord, pulse indicator, session summary and controls easier to read.

The goal is to make the active practice screen clearer while the user is playing guitar.

Related user stories:

- US-004 — Display random chord
- US-005 — Metronome pulse
- US-006 — Pause and resume practice session
- US-007 — Stop practice session

Status:

- Done

---

### B-031 — Extract BPM range constants

Extract the minimum and maximum BPM values into constants.

The goal is to avoid duplicated hardcoded BPM values and make future changes easier.

Related user stories:

- US-002 — Configure BPM

Status:

- Done

---

### B-032 — Extract practice timer interval calculation

Move the BPM interval calculation to a dedicated practice logic file.

The goal is to keep timer-related practice logic outside the UI layer and make the code easier to maintain.

Related user stories:

- US-002 — Configure BPM
- US-005 — Metronome pulse

Status:

- Done

---

### B-033 — Extract elapsed time formatting

Move elapsed time formatting logic to a dedicated practice logic component.

The goal is to keep the Practice Session Screen focused on UI and move time formatting logic outside the screen.

Related user stories:

- US-006 — Pause and resume practice session

Status:

- Done

---

### B-034 — Update README with current MVP features

Update the README file to reflect the current MVP status and implemented features.

The goal is to keep the project documentation aligned with the actual app functionality.

Related tasks:

- B-020 — Refactor chord selection logic
- B-021 — Add paused session feedback
- B-022 — Add elapsed practice time
- B-024 — Add chord change counter
- B-025 — Add selected session summary
- B-026 — Add start session summary

Status:

- Done

---

### B-035 — Create screen specification document

Create a screen specification document describing the current MVP screens.

The goal is to document the implemented Practice Setup Screen and Practice Session Screen.

Related tasks:

- B-018 — Improve practice session display
- B-019 — Improve Practice Setup Screen display
- B-021 — Add paused session feedback
- B-022 — Add elapsed practice time
- B-024 — Add chord change counter
- B-025 — Add selected session summary
- B-026 — Add start session summary
- B-028 — Add BPM range labels

Status:

- Done

---

### B-036 — Add screen specification to README

Add the screen specification document to the README documentation section.

The goal is to make the new screen specification easy to find from the project README.

Related tasks:

- B-035 — Create screen specification document

Status:

- Done

---

### B-037 — Update navigation flow document

Update the navigation flow document to match the current MVP app flow.

The goal is to clearly document how the user moves between the Practice Setup Screen and the Practice Session Screen.

Related tasks:

- B-003 — Define Chord model
- B-004 — Define ChordGroup model
- B-010 — Build Practice Session Screen UI
- B-014 — Implement stop session
- B-027 — Improve stop button label

Status:

- Done

---

### B-038 — Update user stories

Update the user stories document to match the current MVP functionality.

The goal is to keep user-facing requirements aligned with the implemented practice flow.

Related tasks:

- B-016 — Avoid repeating the same chord twice
- B-021 — Add paused session feedback
- B-022 — Add elapsed practice time
- B-024 — Add chord change counter
- B-025 — Add selected session summary
- B-026 — Add start session summary
- B-027 — Improve stop button label

Status:

- Done

---

### B-039 — Update data model document

Update the data model document to reflect the current MVP state and practice-related runtime values.

The goal is to document the main data models and session state values used by the app.

Related tasks:

- B-003 — Define Chord model
- B-004 — Define ChordGroup model
- B-005 — Define PracticeSession model
- B-022 — Add elapsed practice time
- B-024 — Add chord change counter
- B-032 — Extract practice timer interval calculation
- B-033 — Extract elapsed time formatting

Status:

- Done

---

### B-040 — Update MVP definition

Update the MVP definition document to match the current implemented feature set.

The goal is to keep the MVP scope aligned with the current functional version of the app.

Related tasks:

- B-016 — Avoid repeating the same chord twice
- B-021 — Add paused session feedback
- B-022 — Add elapsed practice time
- B-024 — Add chord change counter
- B-025 — Add selected session summary
- B-026 — Add start session summary
- B-027 — Improve stop button label

Status:

- Done

---

### B-041 — Update product definition

Update the product definition document to reflect the current MVP direction and implemented functionality.

The goal is to keep the product description aligned with the current app scope.

Related tasks:

- B-034 — Update README with current MVP features
- B-035 — Create screen specification document
- B-038 — Update user stories
- B-040 — Update MVP definition

Status:

- Done

---

### B-042 — Extract default BPM constant

Extract the default BPM value into a constant.

The goal is to avoid duplicated hardcoded default BPM values and make future changes easier.

Related user stories:

- US-002 — Configure BPM

Status:

- Done

---

### B-043 — Extract BPM constants to shared file

Move BPM-related constants to a shared practice configuration file.

The goal is to avoid duplicating BPM values across screens and activity code.

Related tasks:

- B-031 — Extract BPM range constants
- B-042 — Extract default BPM constant

Status:

- Done

---

### B-044 — Document practice configuration constants

Update the data model document to mention the shared practice configuration constants.

The goal is to document where BPM range and default BPM values are defined in the code.

Related tasks:

- B-031 — Extract BPM range constants
- B-042 — Extract default BPM constant
- B-043 — Extract BPM constants to shared config

Status:

- Done

---

### B-045 — Make setup screen scrollable

Make the Practice Setup Screen vertically scrollable.

The goal is to ensure that all setup controls remain accessible on smaller screens or different device sizes.

Related user stories:

- US-001 — Select chord group
- US-002 — Configure BPM
- US-003 — Start practice session

Status:

- Done

---

### B-046 — Make session screen scrollable

Make the Practice Session Screen vertically scrollable.

The goal is to ensure that the current chord, session summary and controls remain accessible on smaller screens or different device sizes.

Related user stories:

- US-004 — Display random chord
- US-005 — Metronome pulse
- US-006 — Pause and resume practice session
- US-007 — End session

Status:

- Done

---

### B-047 — Extract screen padding values

Extract repeated screen padding values into named constants.

The goal is to avoid duplicated layout values and make spacing easier to adjust in the future.

Related tasks:

- B-029 — Improve setup screen spacing
- B-030 — Improve session screen spacing
- B-045 — Make setup screen scrollable
- B-046 — Make session screen scrollable

Status:

- Done

---

### B-048 — Extract button labels

Extract repeated button label text into named constants.

The goal is to make UI text easier to maintain and reduce hardcoded strings inside composable layout code.

Related tasks:

- B-027 — Improve stop button label

Status:

- Done

---

### B-049 — Extract session text labels

Extract static text labels from the Practice Session Screen into named constants.

The goal is to make the session screen code easier to maintain and reduce hardcoded UI strings inside the composable layout.

Related tasks:

- B-021 — Add paused session feedback
- B-025 — Add selected session summary
- B-048 — Extract button labels

Status:

- Done

---

### B-050 — Extract setup text labels

Extract static text labels from the Practice Setup Screen into named constants.

The goal is to make the setup screen code easier to maintain and reduce hardcoded UI strings inside the composable layout.

Related tasks:

- B-026 — Add start session summary
- B-028 — Add BPM range labels
- B-048 — Extract button labels

Status:

- Done

---

### B-051 — Extract common font sizes

Extract repeated font size values into named constants.

The goal is to make the UI code easier to read and make future visual adjustments simpler.

Related tasks:

- B-018 — Improve practice session display
- B-019 — Improve Practice Setup Screen display
- B-049 — Extract session text labels
- B-050 — Extract setup text labels

Status:

- Done

---

### B-052 — Extract common spacing values

Extract repeated vertical spacing values into named constants.

The goal is to make layout spacing easier to read and adjust in the future.

Related tasks:

- B-029 — Improve setup screen spacing
- B-030 — Improve session screen spacing
- B-047 — Extract screen padding values
- B-051 — Extract common font sizes

Status:

- Done

---

### B-053 — Extract setup summary text formatting

Extract the selected session summary text formatting into a private function.

The goal is to keep the Practice Setup Screen layout cleaner and make summary formatting easier to maintain.

Related tasks:

- B-026 — Add start session summary
- B-050 — Extract setup text labels

Status:

- Done

---

### B-054 — Extract active session summary text formatting

Extract the active session summary text formatting into private functions.

The goal is to keep the Practice Session Screen layout cleaner and make session summary formatting easier to maintain.

Related tasks:

- B-025 — Add selected session summary
- B-049 — Extract session text labels
- B-053 — Extract setup summary text formatting

Status:

- Done

---

### B-055 — Validate BPM before timer calculation

Add basic validation to the BPM interval calculation.

The goal is to prevent invalid BPM values from causing timer calculation errors.

Related tasks:

- B-032 — Extract practice timer interval calculation
- B-043 — Extract BPM constants to shared config

Status:

- Done

---

### B-056 — Validate chord list before selection

Add basic validation to the chord selection logic.

The goal is to prevent empty chord lists from causing random selection errors.

Related tasks:

- B-016 — Avoid repeating the same chord twice
- B-020 — Refactor chord selection logic

Status:

- Done

---

### B-057 — Document testable practice logic

Document that the practice logic has been separated from the UI and can be unit tested in future iterations.

The goal is to make the project architecture clearer and prepare for future testing work.

Related tasks:

- B-020 — Refactor chord selection logic
- B-032 — Extract practice timer interval calculation
- B-033 — Extract elapsed time formatting
- B-043 — Extract BPM constants to shared config
- B-055 — Validate BPM timer calculation
- B-056 — Validate chord list selection

Status:

- Done

---

### B-058 — Add unit tests for PracticeTimer

Add basic unit tests for the PracticeTimer logic.

The goal is to verify BPM interval calculation, elapsed time formatting and invalid BPM validation.

Related tasks:

- B-032 — Extract practice timer interval calculation
- B-033 — Extract elapsed time formatting
- B-055 — Validate BPM timer calculation
- B-057 — Document testable practice logic

Status:

- To do

---

### B-059 — Add unit tests for ChordSelector

Add basic unit tests for the ChordSelector logic.

The goal is to verify random chord selection, repeated chord prevention and empty chord list validation.

Related tasks:

- B-016 — Avoid repeating the same chord twice
- B-020 — Refactor chord selection logic
- B-056 — Validate chord list selection
- B-057 — Document testable practice logic

Status:

- Done

---

### B-060 — Document unit tests

Document the current unit tests added to the project.

The goal is to explain which practice logic components are covered by tests and how to run them.

Related tasks:

- B-058 — Add unit tests for PracticeTimer
- B-059 — Add unit tests for ChordSelector

Status:

- Done

---

### B-061 — Review backlog status

Review the backlog and make sure completed tasks are marked as Done.

The goal is to keep the backlog consistent with the current project progress.

Related tasks:

- B-001 to B-060

Status:

- Done

---

### B-062 — Add run instructions to README

Add basic instructions to the README explaining how to open, run and test the project.

The goal is to make the project easier to understand and execute from a fresh clone.

Related tasks:

- B-034 — Update README with current MVP features
- B-058 — Add unit tests for PracticeTimer
- B-059 — Add unit tests for ChordSelector
- B-060 — Document unit tests

Status:

- Done

---

### B-063 — Add architecture section to README

Add a short architecture section to the README explaining the main project packages.

The goal is to make the project structure easier to understand for reviewers and future contributors.

Related tasks:

- B-020 — Refactor chord selection logic
- B-032 — Extract practice timer interval calculation
- B-043 — Extract BPM constants to shared config
- B-058 — Add unit tests for PracticeTimer
- B-059 — Add unit tests for ChordSelector

Status:

- Done

---

### B-064 — Add roadmap section to README

Add a short roadmap section to the README describing possible future improvements.

The goal is to show the intended direction of the project beyond the current MVP.

Related tasks:

- B-034 — Update README with current MVP features
- B-041 — Update product definition
- B-063 — Add architecture section to README

Status:

- Done

---

### B-065 — Mark MVP core as completed

Mark the core MVP as completed in the README and backlog.

The goal is to clearly indicate that the app already has a functional MVP practice flow before starting product improvements such as metronome sound and chord diagrams.

Related tasks:

- B-001 to B-064

Status:

- Done

---

### B-066 — Add metronome sound

Add a simple metronome sound during the practice session.

The sound should play on each BPM pulse while the session is running and should stop while the session is paused.

Related user stories:

- US-005 — Metronome pulse
- US-006 — Pause and resume session

Status:

- Done

---

### B-067 — Add metronome sound toggle

Add an option to enable or disable the metronome sound during practice setup.

The goal is to let the user decide whether the practice session should use sound or only the visual pulse.

Related tasks:

- B-066 — Add metronome sound

Status:

- Done

---

### B-068 — Document metronome sound toggle

Update documentation to mention that metronome sound can be enabled or disabled from the setup screen.

The goal is to keep project documentation aligned with the current practice session configuration options.

Related tasks:

- B-066 — Add metronome sound
- B-067 — Add metronome sound toggle

Status:

- Done

---

### B-069 — Improve session control button spacing

Increase the horizontal spacing between the Pause / Resume button and the End Session button.

The goal is to make the session controls easier to read and tap.

Related tasks:

- B-027 — Improve stop button label
- B-047 — Extract screen padding values
- B-052 — Extract common spacing values

Status:

- Done

---

### B-070 — Add chord diagram placeholder

Add a visual placeholder area in the Practice Session Screen where chord diagrams will be displayed in a future version.

The goal is to prepare the UI for chord diagrams without adding real chord images yet.

Related tasks:

- B-010 — Create Practice Session Screen
- B-018 — Improve session display
- B-069 — Improve session control button spacing

Status:

- Done

---

### B-071 — Extract chord diagram placeholder into its own composable

Extract the chord diagram placeholder UI from PracticeSessionScreen into a dedicated composable function.

The goal is to keep PracticeSessionScreen easier to read and prepare the UI for future real chord diagrams.

Related tasks:

- B-070 — Add chord diagram placeholder

Status:

- Done

---

### B-072 — Show current chord name inside diagram placeholder

Display the current chord name inside the chord diagram placeholder.

The goal is to make the placeholder more informative while preparing the UI for future real chord diagrams.

Related tasks:

- B-070 — Add chord diagram placeholder
- B-071 — Extract chord diagram placeholder into its own composable

Status:

- Done

---

### B-073 — Center session action buttons

Center the Pause / Resume and End Session buttons horizontally in the Practice Session Screen.

The goal is to improve the visual alignment of the session controls.

Related tasks:

- B-069 — Improve session control button spacing

Status:

- Done

---

### B-074 — Draw basic chord diagram grid

Draw a basic guitar chord diagram grid inside the chord diagram placeholder.

The goal is to make the placeholder visually closer to a real chord diagram while keeping the implementation simple.

Related tasks:

- B-070 — Add chord diagram placeholder
- B-071 — Extract chord diagram placeholder into its own composable
- B-072 — Show current chord name inside diagram placeholder

Status:

- Done

---

### B-075 — Create chord diagram data model

Create data classes to represent guitar chord diagram information.

The goal is to store fret positions, open strings and muted strings as structured data that can later be drawn in the chord diagram UI.

Related tasks:

- B-074 — Draw basic chord diagram grid

Status:

- Done

---

### B-076 — Add basic chord diagrams repository

Create a repository with basic chord diagram data for common major chords.

The goal is to provide structured chord diagram information that can later be rendered by the UI.

Related tasks:

- B-075 — Create chord diagram data model

Status:

- Done

---

### B-077 — Load chord diagram for current chord

Load chord diagram data for the currently displayed chord.

The goal is to connect the Practice Session Screen with the chord diagram repository before rendering real finger positions.

Related tasks:

- B-075 — Create chord diagram data model
- B-076 — Add basic chord diagram repository

Status:

- Done

---

### B-078 — Draw fretted finger positions

Draw finger position dots on the chord diagram grid for fretted strings.

The goal is to render the basic visual position of each chord using the chord diagram data.

Related tasks:

- B-074 — Draw basic chord diagram grid
- B-075 — Create chord diagram data model
- B-076 — Add basic chord diagrams repository
- B-077 — Load chord diagram for current chord

Status:

- Done

---

### B-079 — Draw open and muted string indicators

Draw open string and muted string indicators above the chord diagram grid.

The goal is to show which strings should be played open and which strings should not be played.

Related tasks:

- B-075 — Create chord diagram data model
- B-076 — Add basic chord diagram repository
- B-078 — Draw fretted finger positions

Status:

- Done

---

### B-080 — Add basic minor chord diagrams

Add basic chord diagram data for common open minor chords.

The goal is to support visual diagrams for Am, Dm and Em during practice sessions.

Related tasks:

- B-075 — Create chord diagram data model
- B-076 — Add basic chord diagram repository
- B-079 — Draw open and muted string indicators

Status:

- Done

---

### B-081 — Hide placeholder text when diagram exists

Hide the placeholder text when a chord diagram is available.

The goal is to make real chord diagrams clearer and avoid text overlapping the grid or finger positions.

Related tasks:

- B-077 — Load chord diagram for current chord
- B-078 — Draw fretted finger positions
- B-079 — Draw open and muted string indicators
- B-080 — Add basic minor chord diagrams

Status:

- Done

---

### B-082 — Rename chord diagram composable

Rename the chord diagram placeholder composable to better reflect its current responsibility.

The goal is to make the UI code easier to understand now that the composable renders real chord diagram information.

Related tasks:

- B-071 — Extract chord diagram placeholder into its own composable
- B-078 — Draw fretted finger positions
- B-079 — Draw open and muted string indicators
- B-081 — Hide placeholder text when diagram exists

Status:

- Done

---

### B-083 — Rename chord diagram placeholder constants

Rename chord diagram constants to better reflect the current responsibility of the chord diagram UI.

The goal is to make the code easier to understand after replacing the placeholder with a real diagram view.

Related tasks:

- B-082 — Rename chord diagram composable

Status:

- Done

---

### B-084 — Extract chord diagram drawing constants

Extract chord diagram drawing values into named constants.

The goal is to make the chord diagram drawing code easier to understand and adjust.

Related tasks:

- B-074 — Draw basic chord diagram grid
- B-078 — Draw fretted finger positions
- B-079 — Draw open and muted string indicators

Status:

- Done

---

### B-085 — Extract chord diagram view into its own file

Move the chord diagram composable from PracticeSessionScreen.kt into its own UI file.

The goal is to keep PracticeSessionScreen focused on session layout and state, while keeping chord diagram rendering isolated and easier to maintain.

Related tasks:

- B-082 — Rename chord diagram composable
- B-084 — Extract chord diagram drawing constants

Status:

- Done

---

### B-086 — Add tests for chord diagram repository

Add unit tests for the chord diagram repository.

The goal is to verify that existing chord diagrams can be found by name and that missing diagrams return null.

Related tasks:

- B-075 — Create chord diagram data model
- B-076 — Add basic chord diagram repository
- B-080 — Add basic minor chord diagrams

Status:

- Done

---

### B-087 — Add barre chord support to data model

Add data model support for barre chord positions.

The goal is to represent chords where one finger covers multiple strings on the same fret, preparing the app to support chords such as F and B.

Related tasks:

- B-075 — Create chord diagram data model
- B-076 — Add basic chord diagram repository
- B-086 — Add chord diagram repository tests

Status:

- Done

---

### B-088 — Draw barre chord positions

Draw barre chord positions on the chord diagram grid.

The goal is to visually represent chords where one finger covers multiple strings on the same fret.

Related tasks:

- B-087 — Add barre chord support to data model

Status:

- Done

---

### B-089 — Add F major chord diagram

Add chord diagram data for F major using barre chord support.

The goal is to provide a real diagram for F major instead of showing the missing diagram placeholder.

Related tasks:

- B-087 — Add barre chord support to data model
- B-088 — Draw barre chord positions

Status:

- Done

---

### B-090 — Improve chord diagram aspect ratio

Adjust the chord diagram size to make it visually closer to a real guitar chord diagram.

The goal is to avoid a flattened diagram by using a narrower and taller drawing area.

Related tasks:

- B-074 — Draw basic chord diagram grid
- B-085 — Extract chord diagram view into its own file
- B-089 — Add F major chord diagram

Status:

- Done

---

### B-091 — Add tests for barre chord diagram data

Add unit tests to verify that barre chord diagrams are stored correctly.

The goal is to ensure that F major includes barre position data and can be loaded from the chord diagram repository.

Related tasks:

- B-087 — Add barre chord support to data model
- B-088 — Draw barre chord positions
- B-089 — Add F major chord diagram

Status:

- Done

---

### B-092 — Add B major chord diagram

Add chord diagram data for B major using barre chord support.

The goal is to provide a real diagram for B major instead of showing the missing diagram placeholder.

Related tasks:

- B-087 — Add barre chord support to data model
- B-088 — Draw barre chord positions
- B-091 — Add tests for barre chord diagram data

Status:

- Done

---

### B-093 — Add remaining minor chord diagrams

Add chord diagram data for the remaining minor chords currently used by the app.

The goal is to reduce missing diagram placeholders during minor chord practice.

Related tasks:

- B-080 — Add basic minor chord diagrams
- B-087 — Add barre chord support to data model
- B-092 — Add B major chord diagram

Status:

- Done

---

### B-094 — Document chord diagram feature

Update project documentation to mention that the Practice Session Screen displays generated chord diagrams for supported chords.

The goal is to keep the documentation aligned with the current app features.

Related tasks:

- B-074 — Draw basic chord diagram grid
- B-078 — Draw fretted finger positions
- B-079 — Draw open and muted string indicators
- B-093 — Add remaining minor chord diagrams

Status:

- Done

---

### B-095 — Update README feature list for chord diagrams

Review and update the README feature list to clearly mention generated chord diagrams, open/muted strings and barre chord support.

The goal is to make the GitHub project description reflect the current app capabilities.

Related tasks:

- B-094 — Document chord diagram feature

Status:

- Done

---

### B-096 — Add tests for all supported chord diagrams

Add unit tests to verify that every chord currently used by the app has a chord diagram.

The goal is to prevent missing diagrams when using the predefined chord groups.

Related tasks:

- B-076 — Add basic chord diagram repository
- B-080 — Add basic minor chord diagrams
- B-093 — Add remaining minor chord diagrams
- B-095 — Update README feature list for chord diagrams

Status:

- Done

---

### B-097 — Document chord diagram repository tests

Update documentation to mention that chord diagram repository behavior is covered by unit tests.

The goal is to keep the testing documentation aligned with the current test coverage.

Related tasks:

- B-086 — Add tests for chord diagram repository
- B-091 — Add tests for barre chord diagram data
- B-096 — Add tests for all supported chord diagrams

Status:

- Done

---

### B-098 — Review current MVP status

Review the current MVP documentation and update the project status after adding generated chord diagrams.

The goal is to clearly reflect that the app now goes beyond the initial core MVP with chord diagram support.

Related tasks:

- B-065 — Mark core MVP completed
- B-094 — Document chord diagram feature
- B-095 — Update README feature list for chord diagrams

Status:

- To do