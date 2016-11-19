package com.example.jose.step2library;

public final class TellAJokeFragmentPresenterImp implements TellAJokeFragmentPresenter {

    private final TellAJokeFragmentPresenter.View view;

    public TellAJokeFragmentPresenterImp(final TellAJokeFragmentPresenter.View view) {
        this.view = view;
    }

    @Override
    public void prepareView() {
        view.showTheJoke();
    }

}
