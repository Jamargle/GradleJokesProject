package com.jmlb0003.jokes.gradlejokesproject.home.Interstitial;

interface InterstitialAdFragmentPresenter {

    String INTERSTITIAL_AD_OPENED = "interstitial_ad_opened";
    String INTERSTITIAL_AD_CLOSED = "interstitial_ad_closed";

    void onAdOpened();

    void onAdClosed();

    interface View {

        void showInterstitialAd();

    }

}
