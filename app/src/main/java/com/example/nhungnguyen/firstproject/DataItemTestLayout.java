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
    int imgPerson;
    int favorite;
    boolean isFavorite;

    public DataItemTestLayout(String tvUser, String tvAge, String tvContent, int imgPerson) {
        this.tvUser = tvUser;
        this.tvAge = tvAge;
        this.tvContent = tvContent;
        this.imgPerson = imgPerson;
    }

    protected DataItemTestLayout(Parcel in) {
        tvUser = in.readString();
        tvAge = in.readString();
        tvContent = in.readString();
        imgPerson = in.readInt();
        favorite = in.readInt();
        isFavorite = in.readByte() != 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(tvUser);
        dest.writeString(tvAge);
        dest.writeString(tvContent);
        dest.writeInt(imgPerson);
        dest.writeInt(favorite);
        dest.writeByte((byte) (isFavorite ? 1 : 0));
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

    public int getImgPerson() {
        return imgPerson;
    }

    public void setImgPerson(int imgPerson) {
        this.imgPerson = imgPerson;
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

    public int getFavorite() {
        return favorite;
    }

    public void setFavorite(int favorite) {
        this.favorite = favorite;
    }

    public boolean isFavorite() {
        return isFavorite;
    }

    public void setFavorite(boolean favorite) {
        isFavorite = favorite;
    }

}
