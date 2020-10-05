package com.example.mini_project;

import androidx.test.ext.junit.runners.AndroidJUnit4;
import androidx.test.filters.LargeTest;
import androidx.test.rule.ActivityTestRule;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;
import static androidx.test.espresso.matcher.ViewMatchers.withText;

//TestCase Scenario - UI Test  IT19148014
@LargeTest
@RunWith(AndroidJUnit4.class)

public class AddTest {

    @Rule

    public ActivityTestRule<AddReqBlood> room = new ActivityTestRule<>(AddReqBlood.class);

    @Test
    public void addGuide(){
        onView(withText("Data Inserted Successfully"))
                .inRoot(new Toast())
                .check(matches(isDisplayed()));
    }

}
