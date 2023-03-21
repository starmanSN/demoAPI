package com.example.demoapi.dao;

import com.example.demoapi.entity.ProductImage;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ProductImageDao extends JpaRepository<ProductImage, Long> {

    @Query(value = "SELECT product_image.path FROM product_image WHERE product_image.product_id = :id LIMIT 1", nativeQuery = true)
    String findImageNameByProductId(@Param("id") Long id);

    @Query(value = "SELECT * from product_image", nativeQuery = true)
    List<String> findAllImages();

    @Query(value = "SELECT product_image.path FROM product_image WHERE product_image.product_id = :id", nativeQuery = true)
    List<String> findAllImagesByProductId(@Param("id") Long id);

}
