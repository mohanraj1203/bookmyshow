package com.BookMyShow.BookMyShow.RepositoryLayer;

import com.BookMyShow.BookMyShow.Entity.Booking;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import java.util.List;

public interface BookingRepositoryLayer extends MongoRepository<Booking, String> {
    List<Booking> getByUserNameAndOutDated(String userName,String outDated);
    @Query("{ 'showDate': { '$lt': ?0 } }")
    List<Booking> getByShowDate(String showDate);
    List<Booking> getByUserName(String userName);
    List<Booking> getByOutDated(String outDated);
}
