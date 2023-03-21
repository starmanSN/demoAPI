package com.example.demoapi.dao;

import com.example.demoapi.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface ProductDao extends JpaRepository<Product, Long> {

    Optional<Product> findByTitle(String title);

    List<Product> findAllByTitleContaining(String title);

}
