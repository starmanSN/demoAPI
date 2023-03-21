package com.example.demoapi.dao;

import com.example.demoapi.entity.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderDao extends JpaRepository<Order, Long> {

}
