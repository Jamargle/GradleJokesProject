package com.jmlb0003.jokes.gradlejokesproject.home;

final class MainActivityFragmentPresenterImp implements MainActivityFragmentPresenter {

    private final MainActivityFragmentPresenter.View view;

    MainActivityFragmentPresenterImp(MainActivityFragmentPresenter.View view) {
        this.view = view;
    }

    @Override
    public void onTellJoke() {
        view.openInterstitialAd();
    }

}
