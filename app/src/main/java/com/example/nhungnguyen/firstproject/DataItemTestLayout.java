package com.example.nhungnguyen.firstproject;

import android.graphics.drawable.Drawable;
import android.os.Parcel;
import android.os.Parcelable;
import android.widget.ImageView;

/**
 * Created by asiantech on 3/10/17.
 */
// TODO: 3/10/17  
public class DataItemTestLayout implements Parcelable {
    String tvUser, tvAge, tvContent;
    Drawable imgPerson;
    int favorite;

    public DataItemTestLayout() {
    }

    public Creator<DataItemTestLayout> getCREATOR() {
        return CREATOR;
    }

    public DataItemTestLayout(String tvUser, String tvAge, String tvContent) {
        this.tvUser = tvUser;
        this.tvAge = tvAge;
        this.tvContent = tvContent;
//        this.favorite = favorite;
    }

    protected DataItemTestLayout(Parcel in) {
        tvUser = in.readString();
        tvAge = in.readString();
        tvContent = in.readString();
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(tvUser);
        dest.writeString(tvAge);
        dest.writeString(tvContent);
        dest.writeInt(favorite);
    }

    @Override
    public int describeContents() {
        return 0;
    }

    public static final Creator<DataItemTestLayout> CREATOR = new Creator<DataItemTestLayout>() {
        @Override
        public DataItemTestLayout createFromParcel(Parcel in) {
            return new DataItemTestLayout(in);
        }

        @Override
        public DataItemTestLayout[] newArray(int size) {
            return new DataItemTestLayout[size];
        }
    };

    public int getFavorite() {
        return favorite;
    }

    public void setFavorite(int favorite) {
        this.favorite = favorite;
    }

    public String getTvUser() {
        return tvUser;
    }

    public void setTvUser(String tvUser) {
        this.tvUser = tvUser;
    }

    public String getTvAge() {
        return tvAge;
    }

    public void setTvAge(String tvAge) {
        this.tvAge = tvAge;
    }

    public String getTvContent() {
        return tvContent;
    }

    public void setTvContent(String tvContent) {
        this.tvContent = tvContent;
    }

    public Drawable getImgPerson() {
        return imgPerson;
    }

    public void setImgPerson(Drawable imgPerson) {
        this.imgPerson = imgPerson;
    }
}
