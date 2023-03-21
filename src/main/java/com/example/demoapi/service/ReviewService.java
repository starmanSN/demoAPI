package com.example.demoapi.service;

import com.example.demoapi.dao.ReviewDao;
import com.example.demoapi.dto.ReviewDto;
import com.example.demoapi.dto.mapper.ReviewMapper;
import com.example.demoapi.entity.Review;
import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Slf4j
@Service
@RequiredArgsConstructor
public class ReviewService {

    private final ReviewDao reviewDao;
    private final ReviewMapper reviewMapper;

    public Review save(Review review) {
        return reviewDao.save(review);
    }

    public List<ReviewDto> findReviewsByProductId(Long id) {
        ArrayList<Review> reviews =  reviewDao.findAllByProductId(id);
        return reviews.stream().map(reviewMapper::toReviewDto).collect(Collectors.toList());
    }

    @Transactional(readOnly = true)
    public ReviewDto findById(Long id) {
        return reviewMapper.toReviewDto(reviewDao.findById(id).orElse(null));
    }

    public List<ReviewDto> findAll() {
        return reviewDao.findAll().stream()
                .map(reviewMapper::toReviewDto)
                .collect(Collectors.toList());
    }

    public void deleteById(Long id) {
        try {
            reviewDao.deleteById(id);
        } catch (EmptyResultDataAccessException e) {
            log.error(e.getMessage());
        }
    }

    public Review getCurrentReview(HttpSession session) {
        Review review = (Review) session.getAttribute("review");
        if (review == null) {
            review = new Review();
            session.setAttribute("review", review);
        }
        return review;
    }
}