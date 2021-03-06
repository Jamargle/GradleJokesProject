package com.jmlb0003.jokes.gradlejokesproject.home.Interstitial;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;

import com.google.android.gms.ads.AdListener;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.InterstitialAd;
import com.jmlb0003.jokes.gradlejokesproject.R;
import com.jmlb0003.jokes.gradlejokesproject.utils.FireBaseAnalyticsTracker;

public abstract class InterstitialAdFragment extends Fragment
        implements InterstitialAdFragmentPresenter.View {

    private InterstitialAd interstitialAd;
    private InterstitialAdFragmentPresenter presenter;

    @Override
    public void onCreate(final @Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        presenter = new InterstitialAdFragmentPresenterImp(this, new FireBaseAnalyticsTracker(getActivity()));
    }

    @Override
    public void onStart() {
        super.onStart();
        initInterstitialAd();
    }

    @Override
    public void showInterstitialAd() {
        if (interstitialAd.isLoaded()) {
            interstitialAd.show();
        } else {
            presenter.onCloseAd();
        }
    }

    @Override
    public void closeInterstitialAd() {
        requestNewInterstitial();
        nextScreen();
    }

    protected void openAd() {
        presenter.onOpenAd();
    }

    protected abstract void nextScreen();

    private void initInterstitialAd() {
        interstitialAd = new InterstitialAd(getActivity());
        interstitialAd.setAdUnitId(getString(R.string.banner_ad_unit_id));
        interstitialAd.setAdListener(new AdListener() {

            @Override
            public void onAdClosed() {
                presenter.onCloseAd();
            }

        });
        requestNewInterstitial();
    }

    private void requestNewInterstitial() {
        final AdRequest adRequest = new AdRequest.Builder()
                .addTestDevice(AdRequest.DEVICE_ID_EMULATOR)
                .build();

        interstitialAd.loadAd(adRequest);
    }

}
