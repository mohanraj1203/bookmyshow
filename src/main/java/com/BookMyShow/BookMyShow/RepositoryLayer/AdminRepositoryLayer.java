package com.BookMyShow.BookMyShow.RepositoryLayer;

import com.BookMyShow.BookMyShow.Entity.Admin;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface AdminRepositoryLayer extends MongoRepository<Admin, String> {
    Admin getByUserName(String userName);
}
