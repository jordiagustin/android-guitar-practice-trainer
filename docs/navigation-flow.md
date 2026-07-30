# Navigation Flow

## 1. MVP navigation approach

The MVP uses a simple two-screen navigation flow focused only on the core feature: chord change practice.

The goal is to avoid unnecessary screens in the first version and keep the app focused, functional and easy to use.

## 2. Screens

The MVP includes the following screens:

1. Practice Setup Screen
2. Practice Session Screen

## 3. Navigation diagram

```text
Practice Setup Screen
        |
        | Start Practice
        v
Practice Session Screen
        |
        | End Session
        v
Practice Setup Screen
```

Pause and Resume happen inside the Practice Session Screen and do not change the current screen.

## 4. Practice Setup Screen

This is the first screen shown when the app starts.

The user can configure the practice session before starting.

Main elements:

* App title.
* Short app description.
* Chord group selector.
* BPM selector.
* Minimum and maximum BPM labels.
* Selected session summary.
* Start Practice button.

User actions:

* Select chord group.
* Change BPM value.
* Review the selected session summary.
* Start practice session.

When the user presses Start Practice, the app navigates to the Practice Session Screen.

The selected chord group and BPM are passed from the setup screen to the session screen.

## 5. Practice Session Screen

This screen is shown while the user is practicing.

Main elements:

* Current chord displayed in large text.
* Visual pulse indicator.
* Paused session feedback.
* Active session summary.
* Selected chord group.
* Current BPM value.
* Elapsed practice time.
* Chord change counter.
* Pause / Resume button.
* End Session button.

User actions:

* Pause the session.
* Resume the session.
* End the session.

When the user presses End Session, the app returns to the Practice Setup Screen.

## 6. Navigation rules

* The app starts on the Practice Setup Screen.
* The Start Practice button opens the Practice Session Screen.
* The End Session button returns to the Practice Setup Screen.
* The Pause button does not change screen.
* The Resume button does not change screen.
* The selected chord group and BPM are passed from the setup screen to the session screen.
* A new practice session starts with its own elapsed time and chord change counter.

## 7. Pause / Resume behavior

Pause and Resume only affect the active session state.

When the session is paused:

* Chord changes stop.
* The visual pulse stops updating.
* Elapsed time stops increasing.
* The chord change counter stops increasing.
* The user stays on the Practice Session Screen.

When the session is resumed:

* Chord changes continue.
* The visual pulse continues updating.
* Elapsed time continues increasing.
* The chord change counter continues increasing.
* The user stays on the Practice Session Screen.

## 8. Future navigation

Future versions may include a Home Screen with sections such as:

* Practice
* Theory
* Tablatures
* Tools
* Settings

These sections are intentionally excluded from the MVP to keep the first version focused and achievable.