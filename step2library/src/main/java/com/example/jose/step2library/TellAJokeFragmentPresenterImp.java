package com.example.jose.step2library;

final class TellAJokeFragmentPresenterImp implements TellAJokeFragmentPresenter {

    private final TellAJokeFragmentPresenter.View view;

    TellAJokeFragmentPresenterImp(final TellAJokeFragmentPresenter.View view) {
        this.view = view;
    }

    @Override
    public void prepareView() {
        view.showTheJoke();
    }

}
