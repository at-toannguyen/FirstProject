package com.example.nhungnguyen.firstproject.Models;


public class TitleItem extends ItemList {
    private String title;

    public TitleItem(String title) {
        this.title = title;
    }

    public String getTitle() {
        return title;
    }


    @Override
    public int getType() {
        return 1;
    }
}
