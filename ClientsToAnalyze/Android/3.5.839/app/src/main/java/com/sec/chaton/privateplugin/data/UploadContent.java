package com.sec.chaton.privateplugin.data;

import java.lang.reflect.Field;
import java.util.ArrayList;

/* loaded from: classes.dex */
public class UploadContent {
    private ArrayList<String> image;
    private String latitude;
    private String longitude;
    private String tags;
    private String text;
    private String title;
    private String viewoption;

    public String getTitle() {
        return this.title;
    }

    public void setTitle(String str) {
        this.title = str;
    }

    public String getText() {
        return this.text;
    }

    public void setText(String str) {
        this.text = str;
    }

    public ArrayList<String> getImage() {
        return this.image;
    }

    public void setImage(ArrayList<String> arrayList) {
        this.image = arrayList;
    }

    public String getLatitude() {
        return this.latitude;
    }

    public void setLatitude(String str) {
        this.latitude = str;
    }

    public String getLongitude() {
        return this.longitude;
    }

    public void setLongitude(String str) {
        this.longitude = str;
    }

    public String getTags() {
        return this.tags;
    }

    public void setTags(String str) {
        this.tags = str;
    }

    public String getViewoption() {
        return this.viewoption;
    }

    public void setViewoption(String str) {
        this.viewoption = str;
    }

    public String toString() throws SecurityException {
        StringBuilder sb = new StringBuilder();
        Field[] fields = getClass().getFields();
        for (int i = 0; i < fields.length; i++) {
            sb.append(fields[i].getName());
            sb.append(":");
            try {
                sb.append(fields[i].get(this));
            } catch (Exception e) {
                sb.append("occur Exception");
            }
            sb.append("\n");
        }
        return sb.toString();
    }
}
