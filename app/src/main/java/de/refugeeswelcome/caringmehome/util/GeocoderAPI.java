package de.refugeeswelcome.caringmehome.util;

import okhttp3.Callback;

/**
 * Created by root1 on 04/06/16.
 */
public interface GeocoderAPI {

    void location(String searchText, Callback callback);
}
