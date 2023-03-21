package com.example.demoapi.dto.mapper;

import com.example.demoapi.dto.ReviewDto;
import com.example.demoapi.entity.Review;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class ReviewMapper {

    private final ProductMapper productMapper;

    public ReviewDto toReviewDto(Review review) {
        return ReviewDto.builder()
                .comment(review.getComment())
                .product(productMapper.toProductDto(review.getProduct()))
                .build();
    }
}
