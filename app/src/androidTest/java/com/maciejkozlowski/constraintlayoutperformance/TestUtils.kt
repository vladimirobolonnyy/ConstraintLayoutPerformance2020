package com.maciejkozlowski.constraintlayoutperformance

import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.LayoutRes
import androidx.test.platform.app.InstrumentationRegistry
import kotlin.system.measureNanoTime


fun log(msg: String) {
    Log.i(TAG, msg)
    println(msg)
}

fun measureTime(@LayoutRes layoutRes: Int): Long {
    return measureTimeInNano(layoutRes) / REPEATS
}

val layoutInflater: LayoutInflater by lazy {
    LayoutInflater.from(InstrumentationRegistry.getInstrumentation().targetContext)
}

private fun measureTimeInNano(@LayoutRes layoutRes: Int) = measureNanoTime {
    for (i in 0 until REPEATS) {
        layoutInflater.inflate(layoutRes, null).apply {
            layoutParams = ViewGroup.LayoutParams(0, 0)
            measure(
                View.MeasureSpec.makeMeasureSpec(1000, View.MeasureSpec.EXACTLY),
                View.MeasureSpec.makeMeasureSpec(0, View.MeasureSpec.UNSPECIFIED)
            )
            layout(0, 0, measuredWidth, measuredHeight)
        }
    }
}

const val TAG = "###test"

const val REPEATS = 1_000

const val LINEAR = "linear:\t\t"
const val FRAME = "frame:\t\t\t"
const val RELATIVE = "relative:\t\t"
const val CONSTRAINT = "constraint:\t"
