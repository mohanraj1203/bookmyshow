package com.BookMyShow.BookMyShow.RepositoryLayer;

import com.BookMyShow.BookMyShow.Entity.Movie;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import java.util.List;

public interface MovieRepositoryLayer extends MongoRepository<Movie, String> {
    void deleteByMovieId(int movieId);
    Movie getByMovieId(int movieId);
    @Query("{ 'showDate': { '$lt': ?0 } }")
    List<Movie> getByShowDate(String date);
    List<Movie> getByOutDated(String outDated);
}
