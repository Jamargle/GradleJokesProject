package com.jmlb0003.jokes.gradlejokesproject.home;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.jmlb0003.jokes.gradlejokesproject.R;
import com.jmlb0003.jokes.gradlejokesproject.home.Interstitial.InterstitialAdFragment;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public final class MainActivityFragment extends InterstitialAdFragment
        implements MainActivityFragmentPresenter.View,
        JokeAsyncTask.JokeAsyncTaskListener {

    @BindView(R.id.loading_view) ProgressBar loadingView;
    @BindView(R.id.adView) AdView adView;

    private MainActivityFragmentPresenter presenter;
    private Callback callback;

    @Override
    public void onCreate(final @Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        presenter = new MainActivityFragmentPresenterImp(this);
    }

    @Override
    public View onCreateView(
            final LayoutInflater inflater,
            final ViewGroup container,
            final Bundle savedInstanceState) {

        final View root = inflater.inflate(R.layout.fragment_main, container, false);
        ButterKnife.bind(this, root);
        initAddView();
        callback = (Callback) getActivity();
        setRetainInstance(true);
        return root;
    }

    @Override
    public void openInterstitialAd() {
        openAd();
    }

    @Override
    protected void nextScreen() {
        continueTheFlowAfterAd();
    }

    @Override
    public void continueTheFlowAfterAd() {
        loadingView.setVisibility(View.VISIBLE);
        new JokeAsyncTask(this).execute();
    }

    @OnClick(R.id.tell_joke_button)
    public void tellJoke() {
        presenter.onTellJoke();
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

    private void initAddView() {
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
