package com.maciejkozlowski.constraintlayoutperformance

import androidx.test.ext.junit.runners.AndroidJUnit4
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class LayoutTest {

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
}
