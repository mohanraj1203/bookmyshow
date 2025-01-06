package com.BookMyShow.BookMyShow.ServiceLayer;

import com.BookMyShow.BookMyShow.Entity.Booking;
import com.BookMyShow.BookMyShow.Entity.Movie;
import com.BookMyShow.BookMyShow.RepositoryLayer.BookingRepositoryLayer;
import com.BookMyShow.BookMyShow.RepositoryLayer.MovieRepositoryLayer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class FunctionalLogic {

    @Autowired
    private MovieRepositoryLayer movieRepositoryLayer;

    @Autowired
    private BookingRepositoryLayer bookingRepositoryLayer;

    public void checkOutDated(){
        String date = LocalDate.now().toString();
        List<Movie> oldMovie = movieRepositoryLayer.getByShowDate(date);
        oldMovie.forEach((movie -> {
            movie.setOutDated("true");
            movieRepositoryLayer.save(movie);
        }));
    }

    public void checkHistory(){
        String date = LocalDate.now().toString();
        List<Booking> bookings= bookingRepositoryLayer.getByShowDate(date);
        bookings.forEach((booking -> {
            booking.setOutDated("true");
            bookingRepositoryLayer.save(booking);
        }));
    }
}
