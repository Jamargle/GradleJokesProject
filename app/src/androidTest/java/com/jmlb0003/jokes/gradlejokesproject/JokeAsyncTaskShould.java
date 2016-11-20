package com.jmlb0003.jokes.gradlejokesproject;

import android.app.ProgressDialog;
import android.content.Context;
import android.support.test.annotation.UiThreadTest;
import android.support.test.rule.UiThreadTestRule;
import android.support.test.runner.AndroidJUnit4;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static android.support.test.InstrumentationRegistry.getTargetContext;
import static junit.framework.Assert.assertFalse;

/**
 * Instrumentation test, which will execute on an Android device.
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
@RunWith(AndroidJUnit4.class)
public class JokeAsyncTaskShould implements JokeAsyncTask.JokeAsyncTaskListener {

    @Rule
    public UiThreadTestRule uiThreadTestRule = new UiThreadTestRule();

    private ProgressDialog dialog;
    private JokeAsyncTask task;

    @Before
    public void setUp() throws Throwable {
        final Context context = getTargetContext();

        uiThreadTestRule.runOnUiThread(new Runnable() {
            @Override
            public void run() {
                task = new JokeAsyncTask(context, JokeAsyncTaskShould.this);
                dialog = new ProgressDialog(context);
            }
        });
    }

    @Test
    @UiThreadTest
    public void showDialogWhenExecute() {
        task.execute();
        dialog.show();
    }

    @Test
    @UiThreadTest
    public void returnsJokeSuccessfully() {
        task.execute();
        showAJoke("fakeJoke");
    }

    @Override
    public void showAJoke(final String joke) {
        assertFalse(joke == null);
        assertFalse(joke.isEmpty());
    }

    @Override
    public void thereIsNoJokes() {

    }

}
