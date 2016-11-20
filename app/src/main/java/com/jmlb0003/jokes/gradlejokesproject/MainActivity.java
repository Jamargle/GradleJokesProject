package com.jmlb0003.jokes.gradlejokesproject;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.example.jose.step2library.JokeActivity;

public final class MainActivity extends AppCompatActivity
        implements MainActivityFragment.Callback {

    @Override
    protected void onCreate(final Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @Override
    public void goToJokeActivity(final String joke) {
        final Intent toTellJokeActivity = new Intent(this, JokeActivity.class);
        toTellJokeActivity.putExtra(JokeActivity.JOKE_TO_TELL, joke);
        startActivity(toTellJokeActivity);
    }

}
