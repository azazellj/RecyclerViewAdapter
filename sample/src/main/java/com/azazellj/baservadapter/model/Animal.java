package com.azazellj.baservadapter.model;

/**
 * Created by azazellj on 10/2/17.
 */

public class Animal {
    private String name;
    private String imageURL;

    public Animal() {
    }

    public Animal(String name, String imageURL) {
        this.name = name;
        this.imageURL = imageURL;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getImageURL() {
        return imageURL;
    }

    public void setImageURL(String imageURL) {
        this.imageURL = imageURL;
    }
}
