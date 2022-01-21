package com.example.prototipo_ss;

public class Slide_Item {
    public String getNewsText() {
        return NewsText;
    }

    public void setNewsText(String newsText) {
        NewsText = newsText;
    }

    public Slide_Item(String newsText) {
        NewsText = newsText;
    }

    private String NewsText;
}


