package de.refugeeswelcome.caringmehome;

import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import java.io.IOException;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;

public class MyHomeActivity extends AppCompatActivity {


    private static final String TAG = MyHomeActivity.class.getName();
    TextView mHomeCityTextView;
    String mTameResponse;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_home);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        mHomeCityTextView = (TextView) findViewById(R.id.homeCity);
        Intent intent = getIntent();
        String myHomeCity = intent.getStringExtra("city");
        mHomeCityTextView.setText(myHomeCity);

        if (isNetworkAvailable()) {
            callTameApi(myHomeCity);
        } else {

        }

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }

    /**
     * Calls the tame API to receive all important tweets within the given location.
     *
     * @param location The Location which gets searched via <a href="https://tame.it">tame.it</a>.
     * @return The JSON response as String.
     */
    private void callTameApi(String location) {
        String tameApiCallUrl = urlBuilder(location);

        OkHttpClient client = new OkHttpClient();
        Request request = new Request.Builder()
                .url(tameApiCallUrl)
                .build();

        Call call = client.newCall(request);
        call.enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {
                alertUserAbout();
                mTameResponse = "";
            }

            @Override
            public void onResponse(Call call, okhttp3.Response response) throws IOException {
                try {
                    String jsonData = response.body().string();
                    Log.d(TAG, jsonData);
                    mTameResponse = jsonData;
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        });
    }

    /**
     * Shows an AlertDialog which informs the user about
     */
    private void alertUserAbout() {
        AlertDialogFragment dialog = new AlertDialogFragment();
        dialog.show(getFragmentManager(), "error_dialog");
    }

    /**
     * Updates the tweets on your main page with the received JSON data.
     *
     * @param jsonData the response from the API call as JSON String.
     */
    private void updateTwitterFeed(String jsonData) {

    }

    /**
     * Builds an URL as String for calling.
     *
     * @return the assembled API Call Url as a String.
     */
    private String urlBuilder(String city) {
        String baseUrl = "https://tame.it/hashtrends/results.json?api_key=A3PLzmqMwumyjzD1dEhU";
        String location = "&source=global&term=" + city;
        String options = "&with_subscription=true&only=links&lang=all";
        return baseUrl + location + options;
    }

    /**
     * Checks if the network is available and returns the result as a boolean.
     *
     * @return The result value for network checking as boolean.
     */
    private boolean isNetworkAvailable() {
        ConnectivityManager connectivityManager = (ConnectivityManager) getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo networkInfo = connectivityManager.getActiveNetworkInfo();
        boolean isAvailable = false;
        if (networkInfo != null && networkInfo.isConnected()) {
            isAvailable = true;
        }
        return isAvailable;
    }
}
