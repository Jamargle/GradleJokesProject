/*
   For step-by-step instructions on connecting your Android application to this backend module,
   see "App Engine Java Endpoints Module" template documentation at
   https://github.com/GoogleCloudPlatform/gradle-appengine-templates/tree/master/HelloEndpoints
*/

package com.example.Jose.myapplication.backend;

import com.example.Jose.myapplication.backend.domain.JokeBean;
import com.google.api.server.spi.config.Api;
import com.google.api.server.spi.config.ApiMethod;
import com.google.api.server.spi.config.ApiNamespace;
import com.jmlb0003.jokes.gradlejokesproject.Joker;

/**
 * An endpoint class we are exposing
 */
@Api(
        name = "jokeApi",
        version = "v1",
        namespace = @ApiNamespace(
                ownerDomain = "backend.myapplication.Jose.example.com",
                ownerName = "backend.myapplication.Jose.example.com"
        )
)
public final class JokeEndpoint {

    /**
     * A simple endpoint method that returns a joke
     */
    @ApiMethod(name = "getJoke")
    public JokeBean getAJoke() {
        final JokeBean response = new JokeBean();
        final Joker joker = new Joker();
        response.setData(joker.getJoke());
        return response;
    }

}
