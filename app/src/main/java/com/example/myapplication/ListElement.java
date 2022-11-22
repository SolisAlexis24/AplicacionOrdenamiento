package com.example.myapplication;


import android.graphics.drawable.Drawable;
import android.widget.ImageView;

public class ListElement {
    public String color;
    public String name;
    public String desc;
    public int img;

    public ListElement() {

    }

    public ListElement(String color, String name, String desc, int img) {
        this.color = color;
        this.name = name;
        this.desc = desc;
        this.img = img;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public int getImg(){return img;}
}
