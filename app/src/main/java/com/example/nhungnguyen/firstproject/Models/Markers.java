package com.example.nhungnguyen.firstproject.Models;

/**
 * Copy right asiantech
 * Created by asiantech on 3/31/17.
 */

public class Markers {
    private float itude;
    private float longitude;
    private String title;
    private String snippet;

    public Markers(float itude, float longitude, String title, String snippet) {
        this.itude = itude;
        this.longitude = longitude;
        this.title = title;
        this.snippet = snippet;
    }

    public float getItude() {
        return itude;
    }

    public void setItude(float itude) {
        this.itude = itude;
    }

    public float getLongitude() {
        return longitude;
    }

    public void setLongitude(float longitude) {
        this.longitude = longitude;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getSnippet() {
        return snippet;
    }

    public void setSnippet(String snippet) {
        this.snippet = snippet;
    }
}
