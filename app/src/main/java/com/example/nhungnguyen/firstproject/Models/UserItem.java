package com.example.nhungnguyen.firstproject.Models;

import android.os.Parcel;
import android.os.Parcelable;


// TODO: 3/10/17  
public class UserItem extends ItemList implements Parcelable {
    private final String tvUser;
    private final String tvAge;
    private final String tvContent;
    private final int imgPerson;
    private int favorite;
    private boolean isFavorite;


    public UserItem(String tvUser, String tvAge, String tvContent, int imgPerson) {
        this.tvUser = tvUser;
        this.tvAge = tvAge;
        this.tvContent = tvContent;
        this.imgPerson = imgPerson;
    }

    private UserItem(Parcel in) {
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

    public static final Creator<UserItem> CREATOR = new Creator<UserItem>() {
        @Override
        public UserItem createFromParcel(Parcel in) {
            return new UserItem(in);
        }

        @Override
        public UserItem[] newArray(int size) {
            return new UserItem[size];
        }
    };

    public int getImgPerson() {
        return imgPerson;
    }

    public String getTvUser() {
        return tvUser;
    }


    public String getTvAge() {
        return tvAge;
    }


    public String getTvContent() {
        return tvContent;
    }


    public boolean isFavorite() {
        return isFavorite;
    }

    public void setFavorite(boolean favorite) {
        isFavorite = favorite;
    }

    @Override
    public int getType() {

        return 2;
    }
}
