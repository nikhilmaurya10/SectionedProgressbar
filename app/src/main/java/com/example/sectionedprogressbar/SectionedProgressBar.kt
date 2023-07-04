package com.example.sectionedprogressbar

import android.content.Context
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.util.AttributeSet
import android.view.View
import java.lang.Float.min

class SectionedProgressBar @JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet? = null,
    defStyleAttr: Int = 0
) : View(context, attrs, defStyleAttr) {

    private val baseLinePaint = Paint().apply {
        color = Color.BLACK
        strokeWidth = 10f
    }

    private val progressLinePaint = Paint().apply {
        color = Color.BLUE
        strokeWidth = 10f
    }

    private val circlePaint = Paint().apply {
        color = Color.BLUE
    }

    var breaks: List<Float> = listOf()
    var progress: Float = 0f
    private var breakSize = 10f // size of the break in pixels
    private var circleRadius = 20f // radius of the progress circle

    override fun onDraw(canvas: Canvas) {
        super.onDraw(canvas)

        val totalWidth = width.toFloat() - circleRadius * 2 // adjust the total width for circle
        val progressX = circleRadius + totalWidth * progress // adjust the progressX for circle

        var previousX = circleRadius // start from circle radius
        breaks.forEach { breakRatio ->
            val breakX = circleRadius + totalWidth * breakRatio // adjust breakX for circle
            // Draw the baseline segment
            canvas.drawLine(previousX, height / 2f, breakX, height / 2f, baseLinePaint)
            // Draw the progress line segment if within progress
            if (previousX < progressX) {
                canvas.drawLine(previousX, height / 2f, min(progressX, breakX), height / 2f, progressLinePaint)
            }
            // Move previousX after the break
            previousX = breakX + breakSize
        }
        // Draw the last baseline segment
        canvas.drawLine(previousX, height / 2f, totalWidth + circleRadius, height / 2f, baseLinePaint)
        // Draw the last progress line segment if within progress
        if (previousX < progressX) {
            canvas.drawLine(previousX, height / 2f, progressX, height / 2f, progressLinePaint)
        }
        // Draw circle at the end of progress line
        canvas.drawCircle(progressX, height / 2f, circleRadius, circlePaint)
    }



    fun setLineBreaks(breaks: List<Float>) {
        this.breaks = breaks
        invalidate()
    }

    fun setLineProgress(progress: Float) {
        this.progress = progress
        invalidate()
    }
}
