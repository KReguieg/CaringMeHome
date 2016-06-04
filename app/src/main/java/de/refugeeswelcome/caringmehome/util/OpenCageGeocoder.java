package de.refugeeswelcome.caringmehome.util;

import android.util.Log;

import java.io.IOException;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

/**
 * Created by root1 on 04/06/16.
 */
public class OpenCageGeocoder implements GeocoderAPI {

    private static final String TAG = OpenCageGeocoder.class.getName();

    private String apiKey = "297656ffb8997396e771834be9cf45ac";

    private String domain = "https://api.opencagedata.com/geocode/";
    private String version = "v1/";
    private String format = "json";
    private String url = domain + version + format;

    @Override
    public void location(String searchText, Callback callback) {

        url = url + "?q=" + searchText + "&" + "key=" + apiKey + "&" + "pretty=1";

        OkHttpClient client = new OkHttpClient();
        Request request = new Request.Builder()
                .url(url)
                .build();

        Call call = client.newCall(request);
        call.enqueue(callback);
    }

}
