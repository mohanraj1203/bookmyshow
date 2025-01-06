package com.BookMyShow.BookMyShow.ControllerLayer;

import com.BookMyShow.BookMyShow.Entity.Admin;
import com.BookMyShow.BookMyShow.Entity.Booking;
import com.BookMyShow.BookMyShow.Entity.Movie;
import com.BookMyShow.BookMyShow.Entity.User;
import com.BookMyShow.BookMyShow.ServiceLayer.AdminServiceLayer;
import com.BookMyShow.BookMyShow.ServiceLayer.FeedbackServiceLayer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/admin")
@CrossOrigin(origins = "*")
public class AdminControllerLayer {

    @Autowired
    private AdminServiceLayer adminServiceLayer;

    @Autowired
    private FeedbackServiceLayer feedbackServiceLayer;

    @PostMapping("/login")
    public ResponseEntity<String> adminLogin(@RequestBody Admin admin){
        return adminServiceLayer.adminLogin(admin);
    }

    @PutMapping("/update/password/{userName}")
    public ResponseEntity<String> updatePassword(@PathVariable("userName") String userName,@RequestBody String password){
        return adminServiceLayer.updatePassword(userName,password);
    }

    @PostMapping("/add/movie")
    public ResponseEntity<String> addMovie(@RequestBody Movie movie){
        return adminServiceLayer.addMovie(movie);
    }

    @GetMapping("/display/movies/{check}")
    public List<Movie> displayMovies(@PathVariable("check") String check){
        return adminServiceLayer.displayMovies(check);
    }

    @GetMapping("/display/allMovies")
    public List<Movie> displayAllMovies(){
        return adminServiceLayer.displayAllMovie();
    }

    @PutMapping("/update/movie/{movieId}")
    public Movie updateMovie(@RequestBody Movie movie,@PathVariable("movieId") int movieId){
        return adminServiceLayer.updateMovie(movie,movieId);
    }

    @DeleteMapping("delete/movie/{movieId}")
    public ResponseEntity<String> deleteMovie(@PathVariable("movieId") int movieId){
         return adminServiceLayer.deleteMovie(movieId);
    }

    @GetMapping("/user/information")
    public List<User> displayUser(){
        return adminServiceLayer.displayUser();
    }

    @PostMapping("/block/user")
    public ResponseEntity<String> changeStates(@RequestParam String block, @RequestParam String userName){
        return adminServiceLayer.changeStates(block,userName);
    }

    @PostMapping("/block/feedback")
    public ResponseEntity<String> feedback(@RequestBody String id){
        return adminServiceLayer.feedback(id);
    }

    @GetMapping("/display/booking")
    public List<Booking> displayBooking(){
        return adminServiceLayer.displayBooking();
    }

    @GetMapping("/display/booking/{userName}")
    public List<Booking> displayBookingUser(@PathVariable("userName") String userName){
        return adminServiceLayer.displayBookingUser(userName);
    }

    @GetMapping("/display/booking/{userName}/{check}")
    public List<Booking> displayBookingUser(@PathVariable("userName") String userName,@PathVariable("check") String check){
        return adminServiceLayer.displayBookingUserCondition(userName,check);
    }

    @GetMapping("/display/history/fullHistory/{check}")
    public List<Booking> getDisplayHistoryOld(@PathVariable("check") String outDated){
        return adminServiceLayer.getDisplayHistoryOld(outDated);
    }

    @DeleteMapping("/deleteFeedback/{id}")
    public void deleteFeedback(@PathVariable("id") String id){
        feedbackServiceLayer.deleteFeedback(id);
    }
}
