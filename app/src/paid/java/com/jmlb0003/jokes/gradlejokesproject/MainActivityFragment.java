package com.jmlb0003.jokes.gradlejokesproject;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;
import android.widget.Toast;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public final class MainActivityFragment extends Fragment
        implements JokeAsyncTask.JokeAsyncTaskListener {

    @BindView(R.id.loading_view) ProgressBar loadingView;

    private Callback callback;

    @Override
    public View onCreateView(
            final LayoutInflater inflater,
            final ViewGroup container,
            final Bundle savedInstanceState) {

        final View root = inflater.inflate(R.layout.fragment_main, container, false);
        ButterKnife.bind(this, root);
        callback = (Callback) getActivity();
        setRetainInstance(true);
        return root;
    }

    @OnClick(R.id.tell_joke_button)
    public void tellJoke() {
        loadingView.setVisibility(View.VISIBLE);
        new JokeAsyncTask(this).execute();
    }

    @Override
    public void showAJoke(final String joke) {
        loadingView.setVisibility(View.GONE);
        callback.goToJokeActivity(joke);
    }

    @Override
    public void thereIsNoJokes() {
        getActivity().runOnUiThread(new Runnable() {
            @Override
            public void run() {
                loadingView.setVisibility(View.GONE);
                Toast.makeText(getActivity(), R.string.no_jokes, Toast.LENGTH_SHORT).show();
            }
        });
    }

    interface Callback {

        void goToJokeActivity(String joke);

    }

}
