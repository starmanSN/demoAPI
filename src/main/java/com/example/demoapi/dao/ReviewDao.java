package com.example.demoapi.dao;

import com.example.demoapi.entity.Review;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.ArrayList;

public interface ReviewDao extends JpaRepository<Review, Long> {

    @Query(value = "select * from review where review.product_id = :id", nativeQuery = true)
    ArrayList<Review> findAllByProductId(@Param("id") Long id);
}
