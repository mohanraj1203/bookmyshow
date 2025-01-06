package com.BookMyShow.BookMyShow.Entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "feedback")
public class Feedback {

    @Id
    private String feedbackId;
    private int movieId;
    private String userName;
    private String movieName;
    private String feedback;
    private String show;

    public Feedback() {
    }

    public Feedback(String feedbackId, int movieId, String userName, String movieName, String feedback, String show) {
        this.feedbackId = feedbackId;
        this.movieId = movieId;
        this.userName = userName;
        this.movieName = movieName;
        this.feedback = feedback;
        this.show = "true";
    }

    public String getFeedbackId() {
        return feedbackId;
    }

    public void setFeedbackId(String feedbackId) {
        this.feedbackId = feedbackId;
    }

    public int getMovieId() {
        return movieId;
    }

    public void setMovieId(int movieId) {
        this.movieId = movieId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getMovieName() {
        return movieName;
    }

    public void setMovieName(String movieName) {
        this.movieName = movieName;
    }

    public String getFeedback() {
        return feedback;
    }

    public void setFeedback(String feedback) {
        this.feedback = feedback;
    }

    public String getShow() {
        return show;
    }

    public void setShow(String show) {
        this.show = show;
    }
}
