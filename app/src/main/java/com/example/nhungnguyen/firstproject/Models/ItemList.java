package com.example.nhungnguyen.firstproject.Models;

import android.os.Parcel;
import android.os.Parcelable;


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
