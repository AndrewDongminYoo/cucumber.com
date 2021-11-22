package com.sparta.cucumber.controller;

import com.sparta.cucumber.models.Review;
import com.sparta.cucumber.repository.ReviewRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class ReviewRestController {

    public final ReviewRepository reviewRepository;

    @GetMapping("/{id}/reviews")
    List<Review> getReviews(@PathVariable("id") Long reviewTargetId) {
        return reviewRepository.findAllByReviewTargetUser_Id(reviewTargetId);
    }
}
