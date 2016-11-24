package com.jmlb0003.jokes.gradlejokesproject.home;

interface MainActivityFragmentPresenter {

    void onTellJoke();

    interface View {

        void openInterstitialAd();

        void continueTheFlowAfterAd();

    }

}
