# SectionedProgressBar for Android

SectionedProgressBar is a custom Android view that displays a horizontal progress bar with sections, or breaks. The progress bar consists of a base line and a progress line, and both lines are divided into segments by breaks. The progress line also features a circle at the end, indicating the current progress.

## Features

**Sectioned Lines:** The base line and the progress line can be divided into sections by specifying a list of break points. Break points are given as fractions of the total width of the view, ranging from 0 to 1.

**Progress Indicator:** The current progress can be set as a fraction of the total width of the view, ranging from 0 to 1.

**End Circle:** The progress line features a circle at the end, indicating the current progress. The circle stays within the bounds of the view, even when the progress is set to 0 or 1.

## Usage

Add the **SectionedProgressBar** to your layout file:

```xml
<com.yourpackage.SectionedProgressBar
    android:id="@+id/sectionedProgressBar"
    android:layout_width="match_parent"
    android:layout_height="wrap_content"/>
```


Then, in your Kotlin code, you can set the break points and the progress:

```kotlin
    val sectionedProgressBar: SectionedProgressBar = findViewById(R.id.sectionedProgressBar)
    sectionedProgressBar.setBreaks(listOf(0.2f, 0.35f, 0.5f, 0.7f)) // sets breaks
    sectionedProgressBar.setProgress(0.5f) // sets progress to 50%
```

## Customization

You can customize the appearance of the **SectionedProgressBar** by modifying the `baseLinePaint` and `progressLinePaint` objects in the Kotlin code:

```kotlin
    private val baseLinePaint = Paint().apply {
    color = Color.BLACK
    strokeWidth = 10f
    }
    
    private val progressLinePaint = Paint().apply {
    color = Color.BLUE
    strokeWidth = 10f
    }
```

For example, you can change the color of the lines, or the thickness of the lines.

## Limitations

The **SectionedProgressBar** only supports horizontal progress bars.
Break points and progress are given as fractions of the total width of the view. Therefore, the appearance of the progress bar may vary depending on the size of the view.

## Conclusion

The SectionedProgressBar provides an easy-to-use and customizable way to display a progress bar with sections in your Android app. It allows you to clearly indicate the current progress, while also dividing the progress into segments for easier understanding.