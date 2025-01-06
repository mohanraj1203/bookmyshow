package com.BookMyShow.BookMyShow.RepositoryLayer;

import com.BookMyShow.BookMyShow.Entity.User;
import org.springframework.data.mongodb.repository.MongoRepository;


public interface UserRepositoryLayer extends MongoRepository<User, String> {
    User getByUserName(String userName);
}
