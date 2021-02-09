package com.example.shoppinglistapp;

import android.view.View;

import androidx.recyclerview.widget.RecyclerView;
import androidx.test.espresso.Espresso;

import androidx.test.espresso.contrib.RecyclerViewActions;
import androidx.test.ext.junit.runners.AndroidJUnit4;
import androidx.test.rule.ActivityTestRule;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.matcher.ViewMatchers.withId;

import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import java.util.Objects;

import static org.junit.Assert.*;

@RunWith(AndroidJUnit4.class)
public class MainActivityTest {

    @Rule
    public ActivityTestRule<MainActivity> mainActivityActivityTestRule = new ActivityTestRule<MainActivity>(MainActivity.class);

    private MainActivity mainActivity = null;


    @Before
    public void setUp() throws Exception {

        mainActivity = mainActivityActivityTestRule.getActivity();
    }

    @Test

    public void testRview()
    {

        View view = mainActivity.findViewById(R.id.recycler_view);
        assertNotNull(view);

    }

    @Test

    public void testAdd()
    {

        View view = mainActivity.findViewById(R.id.btn_add);
        assertNotNull(view);

    }

    @Test

    public void testEdit()
    {

        View view = mainActivity.findViewById(R.id.btn_edit);
        assertNotNull(view);

    }

    @Test

    public void testDelete()
    {

        View view = mainActivity.findViewById(R.id.btn_delete);
        assertNotNull(view);

    }

    @Test

    public void testClick()
    {
        Espresso.onView(withId(R.id.recycler_view)).perform(RecyclerViewActions.actionOnItemAtPosition(0, click()));
    }

    @Test

    public void testCount()
    {
        RecyclerView recyclerView = mainActivityActivityTestRule.getActivity().findViewById(R.id.recycler_view);
        int itemcount = Objects.requireNonNull(recyclerView.getAdapter()).getItemCount();
        Espresso.onView(withId(R.id.recycler_view)).perform(RecyclerViewActions.scrollToPosition(itemcount-1));
    }

    @After
    public void tearDown() throws Exception {

        mainActivity = null;
    }
}

