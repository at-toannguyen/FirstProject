package com.example.nhungnguyen.firstproject.Models;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by asiantech on 3/16/17.
 */

public abstract class ItemList implements Parcelable {
    public abstract int getType();

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {

    }
}
