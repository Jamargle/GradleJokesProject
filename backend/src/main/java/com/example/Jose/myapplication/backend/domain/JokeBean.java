package com.example.Jose.myapplication.backend.domain;

/**
 * The object model for the data we are sending through endpoints
 */
public final class JokeBean {

    private String joke;

    public String getData() {
        return joke;
    }

    public void setData(final String data) {
        joke = data;
    }

}