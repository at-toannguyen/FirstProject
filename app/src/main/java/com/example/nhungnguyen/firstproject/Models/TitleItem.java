package com.example.nhungnguyen.firstproject.Models;

/**
 * Created by asiantech on 3/16/17.
 */

public class TitleItem extends ItemList {
    String title;

    public TitleItem() {
    }

    public TitleItem(String title) {
        this.title = title;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    @Override
    public int getType() {
        return 1;
    }
}
