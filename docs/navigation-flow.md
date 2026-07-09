# Navigation Flow

## 1. MVP navigation approach

The MVP will use a simple two-screen navigation flow focused only on the core feature: chord change practice.

The goal is to avoid unnecessary screens in the first version and make the app functional as soon as possible.

## 2. Screens

The MVP will include the following screens:

1. Practice Setup Screen
2. Practice Session Screen

## 3. Navigation diagram

```text
Practice Setup Screen
        |
        | Start
        v
Practice Session Screen
        |
        | Stop
        v
Practice Setup Screen
```

## 4. Practice Setup Screen

This is the first screen shown when the app starts.

The user can configure the practice session before starting.

Main elements:

* App title.
* Chord group selector.
* BPM selector.
* Start button.

User actions:

* Select chord group.
* Change BPM value.
* Start practice session.

When the user presses Start, the app navigates to the Practice Session Screen.

## 5. Practice Session Screen

This screen is shown while the user is practicing.

Main elements:

* Current chord displayed in large text.
* Current BPM value.
* Metronome pulse indicator.
* Pause / Resume button.
* Stop button.

User actions:

* Pause the session.
* Resume the session.
* Stop the session.

When the user presses Stop, the app returns to the Practice Setup Screen.

## 6. Navigation rules

* The app starts on the Practice Setup Screen.
* The Start button opens the Practice Session Screen.
* The Stop button returns to the Practice Setup Screen.
* The Pause button does not change screen.
* The Resume button does not change screen.
* The selected chord group and BPM are passed from the setup screen to the session screen.

## 7. Future navigation

Future versions may include a Home Screen with sections such as:

* Practice
* Theory
* Tablatures
* Tools
* Settings

These sections are intentionally excluded from the MVP to keep the first version focused and achievable.
