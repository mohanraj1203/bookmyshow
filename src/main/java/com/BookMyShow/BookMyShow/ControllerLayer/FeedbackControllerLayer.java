package com.BookMyShow.BookMyShow.ControllerLayer;

import com.BookMyShow.BookMyShow.Entity.Feedback;
import com.BookMyShow.BookMyShow.ServiceLayer.FeedbackServiceLayer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/feedback")
@CrossOrigin(origins = "*")
public class FeedbackControllerLayer {

    @Autowired
    private FeedbackServiceLayer feedbackServiceLayer;

    @GetMapping("/showAll")
    public List<Feedback> getFeedbackAll(){
        return feedbackServiceLayer.getFeedbackAll();
    }

    @GetMapping("/show")
    public List<Feedback> getFeedback(){
        return feedbackServiceLayer.getFeedback();
    }
}
