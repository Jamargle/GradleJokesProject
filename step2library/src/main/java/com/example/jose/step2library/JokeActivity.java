package com.example.jose.step2library;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

/**
 * ACtivity to show a Joke
 * Created by Jose on 19/11/2016.
 */
public final class JokeActivity extends AppCompatActivity {

    public static final String JOKE_TO_TELL = "joke_to_tell";

    @Override
    protected void onCreate(final @Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_joke);
        showJokeFragment();
    }

    private void showJokeFragment() {
        final String joke = getIntent().getStringExtra(JOKE_TO_TELL);
        final TellAJokeFragment fragment = TellAJokeFragment.newInstance(joke);
        getFragmentManager().beginTransaction()
                .add(R.id.joke_activity_container, fragment)
                .commit();
    }

}
