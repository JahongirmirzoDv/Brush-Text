# Brush Text

A small Kotlin Android experiment in coloring text with Jetpack Compose brushes. It provides an interactive way to compare gradients and color palettes.

## What it demonstrates

- Horizontal, vertical, linear, and radial gradient brushes applied to text.
- Palette changes and a custom `ScaledThirdBrush` shader wrapper.
- Compose Material styling and preview tooling.

## Explore the code

- `app/src/main/java/com/mobiledv/brushtext/MainActivity.kt` — demo screen and brush implementations.
- `app/src/main/java/com/mobiledv/brushtext/ui/theme/` — theme and palette definitions.

## Open and build

Open the repository in Android Studio and use a Gradle JDK compatible with its checked-in Android Gradle Plugin. Install Android SDK Platform 32 and let the Gradle wrapper resolve the project dependencies.

```bash
./gradlew :app:assembleDebug
```

Run the `app` configuration on a device or emulator. On Windows, use `gradlew.bat`.

## Project status

This repository is a learning project. Its original dependency versions are retained; dependency resolution and behavior on current Android versions may require maintenance.

