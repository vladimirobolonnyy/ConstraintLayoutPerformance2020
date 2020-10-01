package com.maciejkozlowski.constraintlayoutperformance

import android.view.LayoutInflater
import androidx.annotation.LayoutRes
import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.platform.app.InstrumentationRegistry
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class LayoutTest2020 {

    private lateinit var layoutInflater: LayoutInflater

    @Before
    fun setup() {
        layoutInflater =
            LayoutInflater.from(InstrumentationRegistry.getInstrumentation().targetContext)
    }

    @Test
    fun test_item4_linear() {
        log("item 4 $LINEAR ${measureTime(R.layout.item4_linear)}")
    }

    @Test
    fun test_item4_constraint() {
        log("item 4 $CONSTRAINT ${measureTime(R.layout.item4_constraint)}")
    }

    @Test
    fun test_item5_linear() {
        log("item 5 $LINEAR ${measureTime(R.layout.item5_linear)}")
    }

    @Test
    fun test_item5_constraint() {
        log("item 5 $CONSTRAINT ${measureTime(R.layout.item5_constraint)}")
    }

    @Test
    fun test_item6_linear() {
        log("item 6 $LINEAR ${measureTime(R.layout.item6_linear)}")
    }

    @Test
    fun test_item6_constraint() {
        log("item 6 $CONSTRAINT ${measureTime(R.layout.item6_constraint)}")
    }

    @Test
    fun test_item7_linear() {
        log("item 7 $LINEAR ${measureTime(R.layout.item7_linear)}")
    }

    @Test
    fun test_item7_constraint() {
        log("item 7 $CONSTRAINT ${measureTime(R.layout.item7_constraint)}")
    }

    private fun measureTime(@LayoutRes layoutRes: Int, repeat: Int = 10000): Long {
        return measureTimeInNano(layoutRes, layoutInflater, repeat) / repeat
    }
}

