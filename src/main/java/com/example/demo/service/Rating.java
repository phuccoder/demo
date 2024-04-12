package com.example.demo.service;

public class Rating {
    private String average;
    private String reviews;

    // getters and setters

    public String getAverage() {
        return average;
    }

    public void setAverage(String average) {
        this.average = average;
    }

    public String getReviews() {
        return reviews;
    }

    public void setReviews(String reviews) {
        this.reviews = reviews;
    }

    @Override
    public String toString() {
        return "Rating [average=" + average + ", reviews=" + reviews + "]";
    }
    
}
