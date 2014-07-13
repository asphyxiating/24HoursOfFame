package com.hoursoffame.android.data;

public class TextItem {

    private String text = "";
    private String title = "";
    private long timeCreate;

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}
