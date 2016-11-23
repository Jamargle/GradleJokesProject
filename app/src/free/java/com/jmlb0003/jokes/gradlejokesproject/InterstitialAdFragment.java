package com.jmlb0003.jokes.gradlejokesproject;

import android.support.v4.app.Fragment;

import com.google.android.gms.ads.AdListener;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.InterstitialAd;

public abstract class InterstitialAdFragment extends Fragment {

    private InterstitialAd interstitialAd;

    public InterstitialAdFragment() {

    }

    @Override
    public void onStart() {
        super.onStart();
        initInterstitialAd();
    }

    protected void showInterstitialAd() {
        if (interstitialAd.isLoaded()) {
            interstitialAd.show();
        }
    }

    protected abstract void continueWithFlowAfterAd();

    private void initInterstitialAd() {
        interstitialAd = new InterstitialAd(getActivity());
        interstitialAd.setAdUnitId(getString(R.string.banner_ad_unit_id));
        interstitialAd.setAdListener(new AdListener() {

            @Override
            public void onAdClosed() {
                requestNewInterstitial();
                continueWithFlowAfterAd();
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
