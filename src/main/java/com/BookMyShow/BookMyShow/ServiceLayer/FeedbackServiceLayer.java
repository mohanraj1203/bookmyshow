package com.BookMyShow.BookMyShow.ServiceLayer;

import com.BookMyShow.BookMyShow.Entity.Feedback;
import com.BookMyShow.BookMyShow.RepositoryLayer.FeedbackRepositoryLayer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class FeedbackServiceLayer {

    @Autowired
    private FeedbackRepositoryLayer feedbackRepositoryLayer;

    public List<Feedback> getFeedbackAll(){
        return feedbackRepositoryLayer.findAll();
    }

    public List<Feedback> getFeedback(){
        return feedbackRepositoryLayer.getByShow("true");
    }

    public void deleteFeedback(String id) {
        feedbackRepositoryLayer.deleteById(id);
    }
}