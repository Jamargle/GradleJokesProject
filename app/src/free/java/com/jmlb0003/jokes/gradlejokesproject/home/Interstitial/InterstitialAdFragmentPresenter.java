package com.jmlb0003.jokes.gradlejokesproject.home.Interstitial;

public interface InterstitialAdFragmentPresenter {

    String INTERSTITIAL_AD_OPENED_ID = "interstitial_ad_opened";
    String INTERSTITIAL_AD_CLOSED_ID = "interstitial_ad_closed";
    String INTERSTITIAL_AD_NAME = "main_fragment_interstitial";

    void onOpenAd();

    void onCloseAd();

    interface View {

        void showInterstitialAd();

        void closeInterstitialAd();

    }

}
