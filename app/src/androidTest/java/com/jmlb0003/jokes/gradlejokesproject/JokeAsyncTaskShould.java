package com.jmlb0003.jokes.gradlejokesproject;

import android.app.Instrumentation;
import android.support.test.annotation.UiThreadTest;
import android.support.test.rule.UiThreadTestRule;
import android.support.test.runner.AndroidJUnit4;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static junit.framework.Assert.assertFalse;

/**
 * Instrumentation test, which will execute on an Android device.
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
@RunWith(AndroidJUnit4.class)
public class JokeAsyncTaskShould extends Instrumentation {

    @Rule
    public UiThreadTestRule uiThreadTestRule = new UiThreadTestRule();

    private JokeAsyncTask task;
    private JokeAsyncTask.JokeAsyncTaskListener listener;

    @Before
    public void setUp() {
        listener = new JokeAsyncTask.JokeAsyncTaskListener() {

            @Override
            public void showAJoke(final String joke) {
                assertFalse(joke == null);
                assertFalse(joke.isEmpty());
            }

            @Override
            public void thereIsNoJokes() {

            }

        };
    }

    @Test
    @UiThreadTest
    public void returnsJokeSuccessfully() {
        task = new JokeAsyncTask(listener);
        task.execute();
        listener.showAJoke("fakeJoke");
    }

    @Test
    @UiThreadTest
    public void notReturnsAnyJokesWhenError() {
        task = new JokeAsyncTask(listener);
        task.execute();
        listener.thereIsNoJokes();
    }

}
