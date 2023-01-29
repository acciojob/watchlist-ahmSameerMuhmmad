package com.driver;

public class Movie {

    private String name;
    private int durationMinutes;
    private double imdbRating;

    public Movie() {
    }

    public Movie(String name, int durationMinutes, double imdbRating) {
        this.name = name;
        this.durationMinutes = durationMinutes;
        this.imdbRating = imdbRating;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getDurationMinutes() {
        return durationMinutes;
    }

    public void setDurationMinutes(int durationMinutes) {
        this.durationMinutes = durationMinutes;
    }

    public double getImdbRating() {
        return imdbRating;
    }

    public void setImdbRating(double imdbRating) {
        this.imdbRating = imdbRating;
    }
}
