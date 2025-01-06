package com.BookMyShow.BookMyShow.ServiceLayer;

import com.BookMyShow.BookMyShow.Entity.*;
import com.BookMyShow.BookMyShow.RepositoryLayer.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class AdminServiceLayer {

    @Autowired
    private AdminRepositoryLayer adminRepositoryLayer;

    @Autowired
    private MovieRepositoryLayer movieRepositoryLayer;

    @Autowired
    private UserRepositoryLayer userRepositoryLayer;

    @Autowired
    private FeedbackRepositoryLayer feedbackRepositoryLayer;

    @Autowired
    private FunctionalLogic functionalLogic;

    @Autowired
    private BookingRepositoryLayer bookingRepositoryLayer;

    public ResponseEntity<String> adminLogin(Admin admin){
        Admin exadmin = adminRepositoryLayer.getByUserName(admin.getUserName());
        if(exadmin != null &&  exadmin.getUserName().equals(admin.getUserName()) && exadmin.getPassword().equals(admin.getPassword())){
            return ResponseEntity.status(HttpStatus.ACCEPTED).body("SUCCESS");
        }
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("NOT SUCCESS");
    }

    public ResponseEntity<String> updatePassword(String userName,String password){
        Admin admin = adminRepositoryLayer.getByUserName(userName);
        if(admin == null)
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("NO USER FOUND");
        admin.setPassword(password);
        adminRepositoryLayer.save(admin);
        return ResponseEntity.status(HttpStatus.ACCEPTED).body("UPDATED");
    }

    public ResponseEntity<String> addMovie(Movie movie) {
        Movie duplicateMovie = movieRepositoryLayer.getByMovieId(movie.getMovieId());
        if(duplicateMovie == null) {
            movieRepositoryLayer.save(movie);
            return ResponseEntity.status(HttpStatus.ACCEPTED).body("SUCCESS");
        }
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("DUPLICATE ENTRY");
    }

    public List<Movie> displayMovies(String check){
        functionalLogic.checkOutDated();
        return movieRepositoryLayer.getByOutDated(check);
    }

    public List<Movie> displayAllMovie(){
        return movieRepositoryLayer.findAll();
    }

    public ResponseEntity<String> deleteMovie(int movieId){
        Movie movie = movieRepositoryLayer.getByMovieId(movieId);
        if(movie == null)
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("NO MOVIE FOUNDED");
        movieRepositoryLayer.deleteByMovieId(movieId);
        return ResponseEntity.status(HttpStatus.ACCEPTED).body("DELETED SUCCESSFULLY");
    }

    public Movie updateMovie(Movie movie,int movieId){
        movieRepositoryLayer.deleteByMovieId(movieId);
        return movieRepositoryLayer.save(movie);
    }

    public ResponseEntity<String> changeStates(String block,String userName){
        User user = userRepositoryLayer.getByUserName(userName);
        if(user == null)
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("NO DATA FOUND");
        if(user.getStatus().equals("true") && block.equals("true")){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("ALREADY IN ALIVE");
        }
        else if(user.getStatus().equals("false") && block.equals("false")){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("ALREADY IN BLOCK LIST");
        }
        user.setStatus(block);
        userRepositoryLayer.save(user);
        return ResponseEntity.status(HttpStatus.ACCEPTED).body("UPDATED");
    }

    public List<User> displayUser(){
        return userRepositoryLayer.findAll();
    }

    public ResponseEntity<String> feedback(String id){
        Feedback feedback = feedbackRepositoryLayer.getByFeedbackId(id);
        if(feedback == null)
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("NO DATA FOUND");
        feedback.setShow("false");
        feedbackRepositoryLayer.save(feedback);
        return ResponseEntity.status(HttpStatus.ACCEPTED).body("UPDATED");
    }

    public List<Booking> displayBooking(){
        return bookingRepositoryLayer.findAll();
    }

    public List<Booking> displayBookingUser(String userName){
        return bookingRepositoryLayer.getByUserName(userName);
    }

    public List<Booking> displayBookingUserCondition(String userName,String check){
        return bookingRepositoryLayer.getByUserNameAndOutDated(userName,check);
    }

    public List<Booking> getDisplayHistoryOld(String outDated){
        return bookingRepositoryLayer.getByOutDated(outDated);
    }
}