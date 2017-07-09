/*
   For step-by-step instructions on connecting your Android application to this backend module,
   see "App Engine Java Endpoints Module" template documentation at
   https://github.com/GoogleCloudPlatform/gradle-appengine-templates/tree/master/HelloEndpoints
*/

package com.example.vatam.myapplication.backend;

import com.example.JavaJoker;
import com.google.api.server.spi.config.Api;
import com.google.api.server.spi.config.ApiMethod;
import com.google.api.server.spi.config.ApiNamespace;

import javax.inject.Named;

/**
 * An endpoint class we are exposing
 */
@Api(name = "jokerApi", version = "v1",
        namespace = @ApiNamespace(ownerDomain = "backend.myapplication.vatam.example.com", ownerName = "backend.myapplication.vatam.example.com"))
public class JokerEndpoint {

    private JavaJoker mJavaJoker = new JavaJoker();

    /**
     * A simple endpoint method that takes a name and says Hi back
     */
    @ApiMethod(name = "getJavaJoke")
    public MyBean getJavaJoke() {
        MyBean response = new MyBean();
        String randomJavaJoke = mJavaJoker.getRandomJavaJoke();
        response.setData(randomJavaJoke);

        return response;
    }

}
