package de.refugeeswelcome.caringmehome.util;

import android.util.Log;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;

/**
 * Created by root1 on 05/06/16.
 */
public class CrisisNetApi {

    private String apiKey = "57535ad3d15eddf7785ab268";

    private String domain = "http://api.crisis.net/item?";
    private String locationParam="location=";

    public void feeds(double lat, double lng, Callback callback) {

        String url = domain + locationParam + lat + "," + lng + "&apikey=" + apiKey;

        Log.d(CrisisNetApi.class.getName(), url);

        OkHttpClient client = new OkHttpClient();
        Request request = new Request.Builder()
                .url(url)
                .build();

        Call call = client.newCall(request);
        call.enqueue(callback);
    }
}
