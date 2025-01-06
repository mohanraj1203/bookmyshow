package com.BookMyShow.BookMyShow.Entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "movie")
public class Movie {

    @Id
    private String id;
    @Indexed(unique = true)
    private int movieId;
    private String movieName;
    private int rating;
    private String description;
    private String movieReleaseData;
    private String showDate;
    private int movieDuration;
    private String movieURL;
    private double price;
    private int maxSeat;
    private String outDated;

    public Movie() {
    }

    public Movie(String id, int movieId, String movieName, int rating, String description, String movieReleaseData,String showDate, int movieDuration, String movieURL, double price, int maxSeat,String outDated) {
        this.id = id;
        this.movieId = movieId;
        this.movieName = movieName;
        this.rating = rating;
        this.description = description;
        this.movieReleaseData = movieReleaseData;
        this.showDate = showDate;
        this.movieDuration = movieDuration;
        this.movieURL = movieURL;
        this.price = price;
        this.maxSeat = maxSeat;
        this.outDated = "false";
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public int getMovieId() {
        return movieId;
    }

    public void setMovieId(int movieId) {
        this.movieId = movieId;
    }

    public String getMovieName() {
        return movieName;
    }

    public void setMovieName(String movieName) {
        this.movieName = movieName;
    }

    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getMovieReleaseData() {
        return movieReleaseData;
    }

    public void setMovieReleaseData(String movieReleaseData) {
        this.movieReleaseData = movieReleaseData;
    }

    public String getShowDate() {
        return showDate;
    }

    public void setShowDate(String showDate) {
        this.showDate = showDate;
    }

    public int getMovieDuration() {
        return movieDuration;
    }

    public void setMovieDuration(int movieDuration) {
        this.movieDuration = movieDuration;
    }

    public String getMovieURL() {
        return movieURL;
    }

    public void setMovieURL(String movieURL) {
        this.movieURL = movieURL;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getMaxSeat() {
        return maxSeat;
    }

    public void setMaxSeat(int maxSeat) {
        this.maxSeat = maxSeat;
    }

    public String isOutDated() {
        return outDated;
    }

    public void setOutDated(String outDated) {
        this.outDated = outDated;
    }
}