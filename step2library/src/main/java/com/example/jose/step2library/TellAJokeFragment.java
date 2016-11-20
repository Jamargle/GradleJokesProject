package com.example.jose.step2library;

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

public final class TellAJokeFragment extends Fragment
        implements TellAJokeFragmentPresenter.View {

    private static final String JOKE_TO_TELL = "joke_to_tell";
    private final TellAJokeFragmentPresenter presenter = new TellAJokeFragmentPresenterImp(this);

    public static TellAJokeFragment newInstance(final String joke) {
        final TellAJokeFragment fragment = new TellAJokeFragment();
        final Bundle arguments = new Bundle();
        arguments.putString(JOKE_TO_TELL, joke);
        fragment.setArguments(arguments);

        return fragment;
    }

    @Nullable
    @Override
    public View onCreateView(
            final LayoutInflater inflater,
            final ViewGroup container,
            final Bundle savedInstanceState) {

        return inflater.inflate(R.layout.fragment_tell_a_joke, container, false);
    }

    @Override
    public void onStart() {
        super.onStart();
        presenter.prepareView();
    }

    @Override
    public void showTheJoke() {
        final TextView jokeView = (TextView) getActivity().findViewById(R.id.joke_to_tell);
        if (jokeView != null) {
            final String joke = getArguments().getString(JOKE_TO_TELL);
            jokeView.setText(joke);
        }
    }

}
