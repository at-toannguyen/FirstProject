package com.example.nhungnguyen.firstproject;

import android.graphics.drawable.Drawable;
import android.widget.ImageView;

/**
 * Created by asiantech on 3/10/17.
 */
// TODO: 3/10/17  
public class DataItemTestLayout {
    String tvUser, tvAge, tvContent;
    Drawable imgPerson;

    public DataItemTestLayout() {
    }

    public DataItemTestLayout(String tvUser, String tvAge, String tvContent, Drawable imgPerson) {
        this.tvUser = tvUser;
        this.tvAge = tvAge;
        this.tvContent = tvContent;
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

    public Drawable getImgPerson() {
        return imgPerson;
    }

    public void setImgPerson(Drawable imgPerson) {
        this.imgPerson = imgPerson;
    }
}
