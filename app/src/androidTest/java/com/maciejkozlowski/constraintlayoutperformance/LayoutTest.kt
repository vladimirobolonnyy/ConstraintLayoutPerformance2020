package com.maciejkozlowski.constraintlayoutperformance

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.LayoutRes
import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.platform.app.InstrumentationRegistry
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import kotlin.system.measureNanoTime

@RunWith(AndroidJUnit4::class)
class LayoutTest {

    lateinit var layoutInflater: LayoutInflater

    @Before
    fun setup() {
        layoutInflater =
            LayoutInflater.from(InstrumentationRegistry.getInstrumentation().targetContext)
    }

    @Test
    fun test_item1() {
        log("item 1")
        log("$CONSTRAINT ${measureTime(R.layout.item1_constraint)}")
        log("$LINEAR ${measureTime(R.layout.item1_linear)}")
    }

    @Test
    fun test_item2() {
        log("item 2")
        log("$CONSTRAINT ${measureTime(R.layout.item2_constraint)}")
        log("$LINEAR ${measureTime(R.layout.item2_linear)}")
        log("$FRAME ${measureTime(R.layout.item2_frame)}")
    }

    @Test
    fun test_item3() {
        log("item 3")
        log("$CONSTRAINT ${measureTime(R.layout.item3_constraint)}")
        log("$LINEAR ${measureTime(R.layout.item3_linear)}")
        log("$RELATIVE ${measureTime(R.layout.item3_relative)}")
    }

    @Test
    fun test_item4() {
        log("item 4")
        log("$CONSTRAINT ${measureTime(R.layout.item4_constraint)}")
        log("$LINEAR ${measureTime(R.layout.item4_linear)}")
    }

    private fun measureTime(@LayoutRes layoutRes: Int, repeat: Int = 10000): Long {
        return measureTimeInNano(layoutRes, layoutInflater, repeat) / repeat
    }
}

