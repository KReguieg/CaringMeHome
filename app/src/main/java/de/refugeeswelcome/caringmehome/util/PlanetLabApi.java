package de.refugeeswelcome.caringmehome.util;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;

/**
 * Created by root1 on 05/06/16.
 */
public class PlanetLabApi {

    private String domain = "https://api.planet.com/v0/scenes/ortho/";
    private String authStr = "Basic a2hhbGVkLnJlZ3VpZWdAZ21haWwuY29tOmNhcmluZ21laG9tZQ==";
    private String authKey = "Authorization";

    public void scenes(Callback callback) {

        OkHttpClient client = new OkHttpClient();
        Request request = new Request.Builder()
                .url(domain)
                .addHeader(authKey,authStr)
                .build();

        Call call = client.newCall(request);
        call.enqueue(callback);
    }

}
