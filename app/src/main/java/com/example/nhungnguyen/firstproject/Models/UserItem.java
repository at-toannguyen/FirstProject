package com.example.nhungnguyen.firstproject.Models;

import android.os.Parcel;
import android.os.Parcelable;


// TODO: 3/10/17  
public class UserItem extends ItemList implements Parcelable {
    private String id;
    private String tvUser;
    private String tvAge;
    private String tvContent;
    private String imgPerson;
    private int favorite;
    private boolean isFavorite;

    public UserItem() {
    }

    public UserItem(String tvUser, String tvAge, String tvContent, String imgPerson) {
        this.tvUser = tvUser;
        this.tvAge = tvAge;
        this.tvContent = tvContent;
        this.imgPerson = imgPerson;
    }
    public UserItem(String id, String tvUser, String tvAge, String tvContent, String imgPerson) {
        this.id = id;
        this.tvUser = tvUser;
        this.tvAge = tvAge;
        this.tvContent = tvContent;
        this.imgPerson=imgPerson;
    }

    protected UserItem(Parcel in) {
        super(in);
        id = in.readString();
        tvUser = in.readString();
        tvAge = in.readString();
        tvContent = in.readString();
        imgPerson = in.readString();
        favorite = in.readInt();
        isFavorite = in.readByte() != 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        super.writeToParcel(dest, flags);
        dest.writeString(id);
        dest.writeString(tvUser);
        dest.writeString(tvAge);
        dest.writeString(tvContent);
        dest.writeString(imgPerson);
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

    public String getImgPerson() {
        return imgPerson;
    }

    public void setImgPerson(String imgPerson) {
        this.imgPerson = imgPerson;
    }

    public String getTvUser() {
        return tvUser;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setTvUser(String tvUser) {
        this.tvUser = tvUser;
    }

    public void setTvAge(String tvAge) {
        this.tvAge = tvAge;
    }

    public void setTvContent(String tvContent) {
        this.tvContent = tvContent;
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
