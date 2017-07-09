package com.udacity.gradle.builditbigger;

import android.content.Context;
import android.os.AsyncTask;
import android.support.v4.util.Pair;
import android.util.Log;
import android.view.View;
import android.widget.ProgressBar;

import com.example.vatam.myapplication.backend.jokerApi.JokerApi;
import com.google.api.client.extensions.android.http.AndroidHttp;
import com.google.api.client.extensions.android.json.AndroidJsonFactory;
import com.google.api.client.googleapis.services.AbstractGoogleClientRequest;
import com.google.api.client.googleapis.services.GoogleClientRequestInitializer;

import java.io.IOException;

import static com.udacity.gradle.builditbigger.Constants.LOG_TAG;
import static com.udacity.gradle.builditbigger.MainActivity.startJokerActivity;

class JokerAsyncTask extends AsyncTask<Pair<Context, ProgressBar>, Void, String> {

    private JokerApi mJokerApi;
    private Context mContext;
    private ProgressBar mProgressBar;

    @SafeVarargs
    JokerAsyncTask(Pair<Context, ProgressBar>... params) {
        mContext = params[0].first;
        mProgressBar = params[0].second;
        JokerApi.Builder builder = new JokerApi.Builder(AndroidHttp.newCompatibleTransport(),new AndroidJsonFactory(),null).
                setRootUrl(mContext.getString(R.string.local_endpoint)).setGoogleClientRequestInitializer
                (new
                                                                                                                                                                                                                GoogleClientRequestInitializer() {
            @Override
            public void initialize(AbstractGoogleClientRequest<?> abstractGoogleClientRequest) throws
                    IOException {
                abstractGoogleClientRequest.setDisableGZipContent(true);
            }
        });
        mJokerApi = builder.build();
    }

    @Override
    protected void onPreExecute() {
        if (mProgressBar != null) {
            mProgressBar.setVisibility(View.VISIBLE);
        }
    }

    @SafeVarargs
    @Override
    protected final String doInBackground(Pair<Context, ProgressBar>... params) {
        String result = "An error has occurred!";

        try {
            JokerApi.GetJavaJoke javaJoke = mJokerApi.getJavaJoke();
            result = javaJoke.execute().getData();
        }
        catch (IOException e) {
            Log.e(LOG_TAG, "doInBackground: error while getting java joke", e);
        }
        return result;
    }

    @Override
    protected void onPostExecute(String randomJavaJoke) {
        if (mProgressBar != null) {
            mProgressBar.setVisibility(View.GONE);
        }
        startJokerActivity(mContext, randomJavaJoke);
    }
}
