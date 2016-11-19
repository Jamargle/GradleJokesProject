package com.example.jose.step2library;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
public final class TellAJokeFragmentPresenterImpShould {

    private final TellAJokeFragmentPresenter.View mockView = mock(TellAJokeFragmentPresenter.View.class);
    private TellAJokeFragmentPresenterImp presenter;

    @Before
    public void setUp() {
        presenter = new TellAJokeFragmentPresenterImp(mockView);
    }

    @Test
    public void prepareView_showJoke() throws Exception {
        presenter.prepareView();
        verify(mockView).showTheJoke();
    }

}