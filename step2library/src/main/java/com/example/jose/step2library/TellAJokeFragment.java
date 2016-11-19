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

    @Nullable
    @Override
    public View onCreateView(
            final LayoutInflater inflater,
            final ViewGroup container,
            final Bundle savedInstanceState) {

        final View rootView = inflater.inflate(R.layout.fragment_tell_a_joke, container);
        presenter.prepareView();
        return rootView;
    }

    @Override
    public void showTheJoke() {
        final TextView jokeView = (TextView) getActivity().findViewById(R.id.joke_to_tell);
        final String joke = getArguments().getString(JOKE_TO_TELL);
        jokeView.setText(joke);
    }

    public TellAJokeFragment setJoke(final String joke) {
        final TellAJokeFragment fragment = new TellAJokeFragment();
        final Bundle arguments = new Bundle();
        arguments.putString(JOKE_TO_TELL, joke);
        fragment.setArguments(arguments);
        return fragment;
    }

}
