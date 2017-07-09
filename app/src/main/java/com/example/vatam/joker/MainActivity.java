package com.example.vatam.joker;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.util.Pair;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;

import com.example.JavaJoker;
import com.example.android.jokerlib.JokerActivity;

import static com.example.android.jokerlib.Constants.JOKER_INTENT_EXTRA_NAME;

@SuppressWarnings("squid:MaximumInheritanceDepth")
public class MainActivity extends AppCompatActivity {

    protected JavaJoker mJavaJoker;
    protected Button mInternetJokeButton;
    protected ProgressBar mProgressBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mInternetJokeButton = (Button) findViewById(R.id.tellJokeButtonFromInternet);
        mProgressBar = (ProgressBar) findViewById(R.id.progressBar);
        mJavaJoker = new JavaJoker();
    }

    @Override
    protected void onResume() {
        super.onResume();
        mInternetJokeButton.setActivated(true);
        mProgressBar.setVisibility(View.GONE);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    public void tellJavaJoke(View view) {
        String randomJavaJoke = mJavaJoker.getRandomJavaJoke();
        startJokerActivity(this, randomJavaJoke);
    }

    public static void startJokerActivity(Context context, String randomJavaJoke) {
        Intent intent = new Intent(context, JokerActivity.class);
        intent.putExtra(JOKER_INTENT_EXTRA_NAME, randomJavaJoke);
        context.startActivity(intent);
    }

    @SuppressWarnings("unchecked")
    public void tellJavaJokeFromInternet(View view) {
        view.setActivated(false);

        new JokerAsyncTask(new Pair<>((Context) this, mProgressBar)).execute();
    }

}
