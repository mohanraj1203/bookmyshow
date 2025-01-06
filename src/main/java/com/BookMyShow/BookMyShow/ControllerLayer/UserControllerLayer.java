package com.BookMyShow.BookMyShow.ControllerLayer;

import com.BookMyShow.BookMyShow.Entity.Booking;
import com.BookMyShow.BookMyShow.Entity.Feedback;
import com.BookMyShow.BookMyShow.Entity.Movie;
import com.BookMyShow.BookMyShow.Entity.User;
import com.BookMyShow.BookMyShow.ServiceLayer.UserServiceLayer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")
@CrossOrigin(origins = "*")
public class UserControllerLayer {

    @Autowired
    private UserServiceLayer userServiceLayer;

    @PostMapping("/login")
    public ResponseEntity<String> userLogin(@RequestBody User user){
        return userServiceLayer.userLogin(user);
    }

    @PostMapping("/singup")
    public ResponseEntity<String> userSingUp(@RequestBody User user){
        return userServiceLayer.userSingUp(user);
    }

    @PutMapping("/update/password/{userName}")
    public ResponseEntity<String> updatePassword(@PathVariable("userName") String userName, @RequestBody String password){
        return userServiceLayer.updatePassword(userName,password);
    }

    @GetMapping("/display/movies")
    public List<Movie> displayMovies(){
        return userServiceLayer.displayMovies();
    }

    @PostMapping("/movie/booking")
    public ResponseEntity<String> addMovieBooking(@RequestBody Booking booking){
        return userServiceLayer.addMovieBooking(booking);
    }

    @GetMapping("/display/history/{userName}")
    public List<Booking> getDisplayHistory(@PathVariable("userName") String userName){
        return userServiceLayer.getDisplayHistory(userName);
    }

    @GetMapping("/display/history/fullHistory/{userName}")
    public List<Booking> getDisplayFullHistory(@PathVariable("userName") String userName){
        return userServiceLayer.getDisplayFullHistory(userName);
    }

    @PostMapping("/feedback")
    public ResponseEntity<String> addFeedback(@RequestBody Feedback feedback){
        return userServiceLayer.addFeedback(feedback);
    }
}