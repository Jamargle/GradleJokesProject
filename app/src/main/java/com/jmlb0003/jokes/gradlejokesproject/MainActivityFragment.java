package com.jmlb0003.jokes.gradlejokesproject;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;

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
        initAddView(root);
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

    private void initAddView(final View root) {
        final AdView adView = (AdView) root.findViewById(R.id.adView);
        if (adView != null) {
            // Create an ad request. Check logcat output for the hashed device ID to
            // get test ads on a physical device. e.g.
            // "Use AdRequest.Builder.addTestDevice("ABCDEF012345") to get test ads on this device."
            final AdRequest adRequest = new AdRequest.Builder()
                    .addTestDevice(AdRequest.DEVICE_ID_EMULATOR)
                    .build();
            adView.loadAd(adRequest);
        }
    }

    interface Callback {

        void goToJokeActivity(String joke);

    }

}
