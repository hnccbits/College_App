package com.anjali.myjavaapplication.Dashboard;

public class StaticRCViewModel {

    private int image;
    private String text;

    public StaticRCViewModel(int image,String text){
        this.image = image;
        this.text = text;

    }
    public int getImage(){
        return image;
    }

    public String getText(){
        return text;
    }

}
