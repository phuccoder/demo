package com.example.demo.service;

public class Wine {
    private String winery;
    private String wine;
    private Rating rating;
    private String location;
    private String image;
    private int id;
    public String getWinery() {
        return winery;
    }
    public String getWine() {
        return wine;
    }
    public Rating getRating() {
        return rating;
    }
    public String getLocation() {
        return location;
    }
    public String getImage() {
        return image;
    }
    public int getId() {
        return id;
    }
    public void setWinery(String winery) {
        this.winery = winery;
    }
    public void setWine(String wine) {
        this.wine = wine;
    }
    public void setRating(Rating rating) {
        this.rating = rating;
    }
    public void setLocation(String location) {
        this.location = location;
    }
    public void setImage(String image) {
        this.image = image;
    }
    public void setId(int id) {
        this.id = id;
    }


    @Override
    public String toString() {
        return "Wine [id=" + id + ", image=" + image + ", location=" + location + ", rating=" + rating + ", wine=" + wine
                + ", winery=" + winery + "]";
    }
    
}