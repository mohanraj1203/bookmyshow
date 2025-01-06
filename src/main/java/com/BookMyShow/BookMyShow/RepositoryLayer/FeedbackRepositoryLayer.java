package com.BookMyShow.BookMyShow.RepositoryLayer;

import com.BookMyShow.BookMyShow.Entity.Feedback;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface FeedbackRepositoryLayer extends MongoRepository<Feedback, String> {
    Feedback getByFeedbackId(String feedbackId);
    List<Feedback> getByShow(String show);
}
