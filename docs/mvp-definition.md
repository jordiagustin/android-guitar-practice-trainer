# MVP Definition

## 1. MVP goal

The goal of the MVP is to build a simple Android app that allows users to practice guitar chord changes using random chord prompts and a configurable tempo.

The MVP should be small, functional and realistic to complete as a first portfolio version.

## 2. Main feature

The MVP will include one main feature:

**Practice Chords**

This feature allows the user to select a chord group, set a BPM value and start a practice session where random chords are displayed on screen.

## 3. MVP screens

The MVP will include the following screens:

### 3.1 Practice setup screen

This screen allows the user to configure the practice session.

It will include:

* Chord group selector.
* BPM selector.
* Start button.

### 3.2 Practice session screen

This screen is used during the practice session.

It will include:

* Current chord displayed in large text.
* Current BPM value.
* Metronome pulse indicator.
* Pause button.
* Stop button.

## 4. Chord groups

The first version will include predefined chord groups.

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

## 5. BPM configuration

The user will be able to configure the tempo in BPM.

For the MVP, the allowed BPM range will be:

* Minimum: 40 BPM
* Maximum: 160 BPM
* Default: 60 BPM

## 6. Chord change behavior

For the first MVP version:

**Each metronome pulse changes the displayed chord.**

Example:

* Pulse 1: A
* Pulse 2: D
* Pulse 3: Em
* Pulse 4: G

This keeps the logic simple and easy to implement.

In future versions, the app may allow changing chords every 2 or 4 beats.

## 7. Session controls

The practice session will support:

* Start session.
* Pause session.
* Resume session.
* Stop session.

## 8. What the MVP will not include

The MVP will not include:

* Manual chord selection.
* Tuner.
* Theory section.
* Tablatures.
* Practice history.
* User accounts.
* Database.
* Cloud sync.
* Advanced metronome settings.
* Chord diagrams.

## 9. Success criteria

The MVP will be considered complete when:

* The user can select a chord group.
* The user can set a BPM value.
* The user can start a practice session.
* The app displays random chords based on the selected group.
* The displayed chord changes according to the BPM.
* The user can pause and stop the session.
* The project is documented in GitHub.
