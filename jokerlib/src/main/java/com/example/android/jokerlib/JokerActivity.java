package com.example.android.jokerlib;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.TextView;

import static com.example.android.jokerlib.Constants.JOKER_INTENT_EXTRA_NAME;
import static com.example.android.jokerlib.Constants.LOG_TAG;

@SuppressWarnings("squid:MaximumInheritanceDepth")
public class JokerActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_joker);

        TextView jokeDisplay = (TextView) findViewById(R.id.jokeDisplay);
        Intent intent = getIntent();
        if (intent.hasExtra(JOKER_INTENT_EXTRA_NAME)) {
            jokeDisplay.setText(intent.getStringExtra(JOKER_INTENT_EXTRA_NAME));
        }
        else {
            Log.e(LOG_TAG, "Intent for " + JokerActivity.class.getName() + " had no " +
                    JOKER_INTENT_EXTRA_NAME + " extra!");
        }
    }
}
