package com.example.demoapi.service;

import com.example.demoapi.dao.OrderDao;
import com.example.demoapi.dto.mapper.OrderMapper;
import com.example.demoapi.entity.Order;
import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class OrderService {

    private final OrderDao orderDao;

    private final OrderMapper orderMapper;

    public static final String ORDER_ATTRIBUTE = "order";

    public Order getCurrentOrder(HttpSession session) {
        Order order = (Order) session.getAttribute(ORDER_ATTRIBUTE);
        if (order == null) {
            order = new Order();
            session.setAttribute(ORDER_ATTRIBUTE, order);
        }
        return order;
    }

    public List<Order> findAll() {
        return orderDao.findAll();
    }

    public boolean save(Order order) {
        orderDao.save(order);
        return true;
    }

    public void resetOrder(HttpSession session) {
        session.removeAttribute(ORDER_ATTRIBUTE);
    }
}