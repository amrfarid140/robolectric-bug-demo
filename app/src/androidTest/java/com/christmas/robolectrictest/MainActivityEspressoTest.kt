package com.christmas.robolectrictest

import android.app.Activity
import android.view.View
import androidx.constraintlayout.widget.Group
import androidx.core.view.isVisible
import androidx.test.espresso.Espresso
import androidx.test.espresso.matcher.ViewMatchers
import androidx.test.platform.app.InstrumentationRegistry
import androidx.test.rule.ActivityTestRule
import org.junit.Rule
import org.junit.Test
import kotlin.test.assertTrue

class MainActivityEspressoTest{

    @get:Rule
    val testRule = ActivityTestRule<MainActivity>(MainActivity::class.java)

    @Test
    fun whenShowHello_ThenTwoHelloIsVisible() {
        InstrumentationRegistry.getInstrumentation().runOnMainSync {
            testRule.activity.showTwoHellos()
        }

        Espresso.onView(ViewMatchers.withId(R.id.hello_group)).check { view, _ ->
            val group = view as Group
            group.referencedIds.forEach {
                assertTrue {
                    (view.context as Activity).findViewById<View>(it).isVisible
                }
            }
        }
    }
}