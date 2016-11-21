package com.jmlb0003.jokes.gradlejokesproject;

import android.os.AsyncTask;

import com.example.jose.myapplication.backend.jokeApi.JokeApi;
import com.google.api.client.extensions.android.http.AndroidHttp;
import com.google.api.client.extensions.android.json.AndroidJsonFactory;
import com.google.api.client.googleapis.services.AbstractGoogleClientRequest;
import com.google.api.client.googleapis.services.GoogleClientRequestInitializer;

import java.io.IOException;

public final class JokeAsyncTask
        extends AsyncTask<Void, Void, String> {

    private final static String LOCAL_SERVER_ROOT = "http://10.0.2.2:8080/";
    private final static String API_ENDPOINT = "_ah/api/";
    private static JokeApi myApiService = null;
    private final JokeAsyncTaskListener asyncTaskListener;

    public JokeAsyncTask(final JokeAsyncTaskListener listener) {
        asyncTaskListener = listener;
    }

    @Override
    protected String doInBackground(Void... params) {
        if (myApiService == null) {  // Only do this once
            final JokeApi.Builder builder = new JokeApi
                    .Builder(AndroidHttp.newCompatibleTransport(), new AndroidJsonFactory(), null)
                    // options for running against local devappserver
                    // - 10.0.2.2 is localhost's IP address in Android emulator
                    // - turn off compression when running against local devappserver
                    .setRootUrl(LOCAL_SERVER_ROOT + API_ENDPOINT)
                    .setGoogleClientRequestInitializer(new GoogleClientRequestInitializer() {

                        @Override
                        public void initialize(AbstractGoogleClientRequest<?> abstractGoogleClientRequest) {
                            abstractGoogleClientRequest.setDisableGZipContent(true);
                        }

                    });
            // end options for devappserver

            myApiService = builder.build();
        }

        try {
            return myApiService.getJoke().execute().getData();
        } catch (IOException e) {
            asyncTaskListener.thereIsNoJokes();
            return null;
        }
    }

    @Override
    protected void onPostExecute(final String joke) {
        if (joke != null && !joke.isEmpty()) {
            asyncTaskListener.showAJoke(joke);
        }
    }

    interface JokeAsyncTaskListener {

        void showAJoke(String joke);

        void thereIsNoJokes();

    }

}