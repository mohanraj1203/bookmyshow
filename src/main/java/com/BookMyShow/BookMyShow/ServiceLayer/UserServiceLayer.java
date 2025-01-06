package com.BookMyShow.BookMyShow.ServiceLayer;

import com.BookMyShow.BookMyShow.Entity.*;
import com.BookMyShow.BookMyShow.RepositoryLayer.BookingRepositoryLayer;
import com.BookMyShow.BookMyShow.RepositoryLayer.FeedbackRepositoryLayer;
import com.BookMyShow.BookMyShow.RepositoryLayer.MovieRepositoryLayer;
import com.BookMyShow.BookMyShow.RepositoryLayer.UserRepositoryLayer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class UserServiceLayer {

    @Autowired
    private BookingRepositoryLayer bookingRepositoryLayer;

    @Autowired
    private UserRepositoryLayer userRepositoryLayer;

    @Autowired
    private MovieRepositoryLayer movieRepositoryLayer;

    @Autowired
    private FeedbackRepositoryLayer feedbackRepositoryLayer;

    @Autowired
    private FunctionalLogic functionalLogic;

    public ResponseEntity<String> userLogin(User user){
        User exuser = userRepositoryLayer.getByUserName(user.getUserName());
        if(exuser.getStatus().equals("false"))
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("YOU ARE BLOCKED");
        if (exuser != null && user.getUserName().equals(exuser.getUserName()) && user.getPassword().equals(exuser.getPassword())) {
            return ResponseEntity.status(HttpStatus.ACCEPTED).body("SUCCESS");
        }
        return ResponseEntity.status(HttpStatus.BAD_GATEWAY).body("UNSUCCESS");
    }

    public ResponseEntity<String> userSingUp(User user){
        User duplicateUser = userRepositoryLayer.getByUserName(user.getUserName());
        if(duplicateUser == null){
            userRepositoryLayer.save(user);
            return ResponseEntity.status(HttpStatus.ACCEPTED).body("UPDATED SUCCESS");
        }
        return ResponseEntity.status(HttpStatus.BAD_GATEWAY).body("DUPLICATE ENTRY");
    }

    public ResponseEntity<String> updatePassword(String userName,String password){
        User user = userRepositoryLayer.getByUserName(userName);
        if(user == null)
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("NO USER FOUND");
        user.setPassword(password);
        userRepositoryLayer.save(user);
        return ResponseEntity.status(HttpStatus.ACCEPTED).body("UPDATED");
    }
    public List<Movie> displayMovies(){
        functionalLogic.checkOutDated();
        return movieRepositoryLayer.getByShowDate("false");
    }

    public ResponseEntity<String> addMovieBooking(Booking booking){
        Movie movie = movieRepositoryLayer.getByMovieId(booking.getMovieId());
        if(movie.getMaxSeat() == 0)
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("NO SEATS IS AVAILABLE");
        if(movie == null || (movie.getMaxSeat() - booking.getQuantity()) < 0)
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
        movie.setMaxSeat(movie.getMaxSeat() - booking.getQuantity());
        movieRepositoryLayer.save(movie);
        booking.getPrice(movie.getPrice() * booking.getQuantity());
        bookingRepositoryLayer.save(booking);
        return ResponseEntity.status(HttpStatus.ACCEPTED).body("SUCCESSFULLY BOOKED");
    }

    public List<Booking> getDisplayHistory(String userName){
        functionalLogic.checkHistory();
        return bookingRepositoryLayer.getByUserNameAndOutDated(userName,"false");
    }

    public List<Booking> getDisplayFullHistory(String userName){
        return bookingRepositoryLayer.getByUserName(userName);
    }

    public ResponseEntity<String> addFeedback(Feedback feedback){
        feedbackRepositoryLayer.save(feedback);
        return ResponseEntity.status(HttpStatus.ACCEPTED).body("UPDATED");
    }
}