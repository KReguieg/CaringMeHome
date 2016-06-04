package de.refugeeswelcome.caringmehome;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.Toast;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.Gson;

import java.io.IOException;

import de.refugeeswelcome.caringmehome.model.OpenCageAnnotations;
import de.refugeeswelcome.caringmehome.model.OpenCageResponse;
import de.refugeeswelcome.caringmehome.util.GeocoderAPI;
import de.refugeeswelcome.caringmehome.util.OpenCageGeocoder;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = MainActivity.class.getName();
    String mTameResponse;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        if (isNetworkAvailable()) {
            callTameApi();
            GeocoderAPI geocoder = new OpenCageGeocoder();
            geocoder.location("Gransee, Deutschland", new Callback() {
                @Override
                public void onFailure(Call call, IOException e) {
                    Log.e(TAG, e.getMessage());
                }

                @Override
                public void onResponse(Call call, Response response) throws IOException {
                    try {
                        String jsonData = response.body().string();

                        ObjectMapper mapper = new ObjectMapper();
                        OpenCageResponse res = mapper.readValue(jsonData, OpenCageResponse.class);

                        for (OpenCageAnnotations annotations : res.getResults()) {
                            annotations.getFormatted();
                        }

                        Log.d(TAG, jsonData);
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            });
        } else {
            Toast.makeText(this, R.string.network_notavailable, Toast.LENGTH_SHORT).show();
        }
    }

    /**
     * Calls the tame API to receive all important tweets within the given location.
     * @return The JSON response as String.
     */
    private void callTameApi() {
        String tameApiCallUrl = urlBuilder("Damaskus");

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
            public void onResponse(Call call, Response response) throws IOException {
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
