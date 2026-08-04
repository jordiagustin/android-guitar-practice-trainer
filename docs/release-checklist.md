Release Checklist
1. Purpose

This document tracks the remaining tasks needed before presenting Android Guitar Practice Trainer as a portfolio-ready Android app.

The goal is not to publish the app immediately, but to prepare the project so it looks clean, functional and understandable for GitHub, interviews and possible future release builds.

2. Current project status

Current status:

Core MVP completed.
Post-MVP improvements added.
Custom chord selection implemented.
Optional metronome sound implemented.
Generated chord diagrams implemented.
Practice summary screen implemented.
Basic visual polish applied.
Unit tests added.
Physical device testing completed.
Project documentation reviewed.
3. Code readiness

Before creating a release build, verify:

The app compiles without errors.
Unit tests pass.
There are no obvious unused imports.
There are no temporary debug messages.
There are no hardcoded test-only values.
Main navigation flow works correctly.
No known crash exists in the main practice flow.

Recommended command on macOS or Linux:

./gradlew test

Recommended command on Windows:

.\gradlew test
4. Manual testing checklist

Test the following flow on a physical Android device:

Open the app.
Review the Practice Setup Screen.
Select a chord group.
Select individual chords.
Use Select all.
Use Clear all.
Confirm Start Practice is disabled when no chords are selected.
Select a small set of chords.
Change BPM.
Enable metronome sound.
Start practice.
Confirm chord changes follow the selected BPM.
Confirm the same chord is not repeated twice in a row when alternatives exist.
Confirm chord diagrams are displayed.
Pause the session.
Confirm time, pulse, sound and chord changes stop while paused.
Resume the session.
End the session.
Review the Practice Summary Screen.
Start a new session.
5. Documentation readiness

Before presenting the project, verify that these files are updated:

README.md
docs/product-definition.md
docs/mvp-definition.md
docs/user-stories.md
docs/navigation-flow.md
docs/screen-specification.md
docs/data-model.md
docs/backlog.md

The documentation should describe:

The three-screen app flow.
Custom chord selection.
Optional metronome sound.
Generated chord diagrams.
Practice summary screen.
Current tested components.
Future roadmap.
6. GitHub presentation readiness

Before sharing the repository, verify:

The README clearly explains what the app does.
The README includes the current feature list.
The README explains how to run the project.
The README explains how to run tests.
The repository has a clear project structure.
The backlog shows completed work and next steps.
The documentation folder is organized.
No local or private files are committed.
7. Possible visual assets

Before a public release or portfolio presentation, consider adding:

App icon.
Simple screenshots.
Short animated demo or screen recording.
GitHub README screenshots.
Release notes.

These are not required for the current functional version, but they would improve presentation.

8. Future release preparation

Before publishing outside GitHub, future tasks may include:

Create release build.
Configure signing.
Review app version name and version code.
Review app name and launcher icon.
Review privacy requirements.
Prepare store description.
Prepare screenshots.
Test installation from release APK or AAB.
9. Current decision

For now, the project should be treated as:

Portfolio-ready candidate

The next recommended step is to add screenshots or a short demo to the README after confirming the final visual state on a physical device.