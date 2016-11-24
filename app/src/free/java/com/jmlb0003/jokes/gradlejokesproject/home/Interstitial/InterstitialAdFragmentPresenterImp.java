package com.jmlb0003.jokes.gradlejokesproject.home.Interstitial;

import com.jmlb0003.jokes.gradlejokesproject.utils.FireBaseAnalyticsTracker;

class InterstitialAdFragmentPresenterImp implements InterstitialAdFragmentPresenter {

    private final InterstitialAdFragmentPresenter.View view;
    private FireBaseAnalyticsTracker fireBaseAnalyticsTracker;

    InterstitialAdFragmentPresenterImp(
            final View view,
            final FireBaseAnalyticsTracker fireBaseAnalyticsTracker) {

        this.view = view;
        this.fireBaseAnalyticsTracker = fireBaseAnalyticsTracker;
    }

    @Override
    public void onAdOpened() {
        fireBaseAnalyticsTracker.trackSelectContentEvent(
                INTERSTITIAL_AD_OPENED_ID,
                INTERSTITIAL_AD_NAME,
                FireBaseAnalyticsTracker.INTERSTITIAL_AD);
    }

    @Override
    public void onAdClosed() {
        fireBaseAnalyticsTracker.trackSelectContentEvent(
                INTERSTITIAL_AD_CLOSED_ID,
                INTERSTITIAL_AD_NAME,
                FireBaseAnalyticsTracker.INTERSTITIAL_AD);
    }

}
