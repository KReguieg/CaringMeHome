package de.refugeeswelcome.caringmehome.util;

import android.os.Parcel;

import com.arlib.floatingsearchview.suggestions.model.SearchSuggestion;

/**
 * Created by Khaled Reguieg (s57532) <a href="mailto:Khaled.Reguieg@gmail.com">Khaled Reguieg, Khaled.Reguieg@gmail.com</a> on 04.06.2016.
 * <br><br>
 */
public class LocationSuggestion implements SearchSuggestion {

    public static final Creator<LocationSuggestion> CREATOR = new Creator<LocationSuggestion>() {
        @Override
        public LocationSuggestion createFromParcel(Parcel in) {
            return new LocationSuggestion(in);
        }

        @Override
        public LocationSuggestion[] newArray(int size) {
            return new LocationSuggestion[size];
        }
    };
    private String mLocation;
    private boolean mIsHistory = false;

    public LocationSuggestion(String suggestion) {
        this.mLocation = suggestion;
    }

    public LocationSuggestion(Parcel source) {
        this.mLocation = source.readString();
        this.mIsHistory = source.readInt() != 0;
    }

    public String getmLocation() {
        return mLocation;
    }

    public void setmLocation(String mLocation) {
        this.mLocation = mLocation;
    }

    public boolean ismIsHistory() {
        return mIsHistory;
    }

    public void setmIsHistory(boolean mIsHistory) {
        this.mIsHistory = mIsHistory;
    }

    @Override
    public String getBody() {
        return mLocation;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(mLocation);
        dest.writeInt(0);
    }
}
