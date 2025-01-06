package com.BookMyShow.BookMyShow.Entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "booking")
public class Booking {

    @Id
    private String id;
    private String userName;
    private int movieId;
    private double price;
    private String showDate;
    private int quantity;
    private String outDated;

    public Booking() {
    }

    public Booking(String id, String userName, int movieId, double price,String showDate, int quantity,String outDated) {
        this.id = id;
        this.userName = userName;
        this.movieId = movieId;
        this.price = price;
        this.showDate=showDate;
        this.quantity = quantity;
        this.outDated = "false";
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public int getMovieId() {
        return movieId;
    }

    public void setMovieId(int movieId) {
        this.movieId = movieId;
    }

    public double getPrice(double v) {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getShowDate() {
        return showDate;
    }

    public void setShowDate(String showDate) {
        this.showDate = showDate;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public String getOutDated() {
        return outDated;
    }

    public void setOutDated(String outDated) {
        this.outDated = outDated;
    }
}
