package com.hoursoffame.android.data;

public class TextItem {

    private String text = "";
    private String title = "";
    private String creationTime = "";

    public String getText() {
        return text;
    }

    public String getTitle() {
        return title;
    }

    public String getCreationTime() {
        return creationTime;
    }

    public void setText(String text) {
        this.text = text;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setCreationTime(String creationTime) {
        this.creationTime = creationTime;
    }

}
