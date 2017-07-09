package com.example.vatam.joker.free;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.util.Pair;
import android.util.Log;
import android.view.View;

import com.example.vatam.joker.JokerAsyncTask;
import com.example.vatam.joker.MainActivity;
import com.example.vatam.joker.R;
import com.google.android.gms.ads.AdListener;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.InterstitialAd;

import static com.example.vatam.joker.Constants.LOG_TAG;

@SuppressWarnings("squid:MaximumInheritanceDepth")
public class FreeMainActivity extends MainActivity {

    private InterstitialAd mInterstitialAd;
    private int clickedButtonId;
    private AdListener mAdListener = new AdListener() {
        @Override
        public void onAdClosed() {
            mInterstitialAd.loadAd(new AdRequest.Builder().build());
            switch (clickedButtonId) {
                case R.id.tellJokeButtonFromInternet:
                    tellJJavaJokeFromInternetButtonAction();
                    break;
                case R.id.tellJokeButton:
                default:
                    tellJavaJokeButtonAction();
                    break;
            }
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mInterstitialAd = new InterstitialAd(this);
        mInterstitialAd.setAdListener(mAdListener);
        mInterstitialAd.setAdUnitId("ca-app-pub-3940256099942544/1033173712");
        mInterstitialAd.loadAd(new AdRequest.Builder().build());
    }

    public void tellJavaJoke(View view) {
        if (mInterstitialAd.isLoaded()) {
            clickedButtonId = view.getId();
            mInterstitialAd.show();
        }
        else {
            Log.d(LOG_TAG, "The interstitial wasn't loaded yet.");
        }
    }

    @SuppressWarnings("unchecked")
    public void tellJavaJokeFromInternet(View view) {
        if (mInterstitialAd.isLoaded()) {
            clickedButtonId = view.getId();
            mInterstitialAd.show();
        }
        else {
            Log.d(LOG_TAG, "The interstitial wasn't loaded yet.");
        }
    }

    private void tellJavaJokeButtonAction() {
        String randomJavaJoke = mJavaJoker.getRandomJavaJoke();
        startJokerActivity(this, randomJavaJoke);
    }

    private void tellJJavaJokeFromInternetButtonAction() {
        mInternetJokeButton.setActivated(false);

        new JokerAsyncTask(new Pair<>((Context) this, mProgressBar)).execute();
    }

}
