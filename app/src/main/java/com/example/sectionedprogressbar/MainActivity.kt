package com.example.sectionedprogressbar

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val sectionedProgressBar: SectionedProgressBar = findViewById(R.id.sectionedProgressBar)
        sectionedProgressBar.setLineBreaks(listOf(0.2f, 0.35f, 0.5f, 0.7f, 0.99f))
        sectionedProgressBar.setLineProgress(0.3f)

    }
}