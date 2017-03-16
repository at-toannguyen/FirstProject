package com.example.nhungnguyen.firstproject.Models;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by asiantech on 3/10/17.
 */
// TODO: 3/10/17  
public class UserItem extends ItemList implements Parcelable {
    String tvUser, tvAge, tvContent;
    int imgPerson;
    int favorite;
    boolean isFavorite;

    public UserItem() {
    }

    public UserItem(String tvUser, String tvAge, String tvContent, int imgPerson) {
        this.tvUser = tvUser;
        this.tvAge = tvAge;
        this.tvContent = tvContent;
        this.imgPerson = imgPerson;
    }

    protected UserItem(Parcel in) {
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

    @Override
    public int getType() {

        return 2;
    }
}
