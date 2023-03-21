package com.example.demoapi.controller;

import com.example.demoapi.dto.OrderDto;
//import com.example.demoapi.entity.Cart;
import com.example.demoapi.entity.Order;
import com.example.demoapi.entity.enums.OrderStatus;
import com.example.demoapi.entity.security.AccountUser;
import com.example.demoapi.service.CartService;
import com.example.demoapi.service.OrderService;
import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.math.BigDecimal;

@Controller
@RequiredArgsConstructor
@RequestMapping("/order")
public class OrderController {

    private final CartService cartService;

    private final OrderService orderService;

    @GetMapping
    public String getOrderList(Model model) {
        model.addAttribute("order", orderService.findAll());
        return "order/order-list";
    }

//    @GetMapping("/fill")
//    public String fill(Model model, HttpSession httpSession) {
//        Cart cart = cartService.getCurrentCart(httpSession);
//        model.addAttribute("cart", cart);
//        model.addAttribute("orderDto", new OrderDto());
//        return "order/order-form";
//    }

//    @PostMapping("/create")
//    public String fillOrder(OrderDto orderDto, HttpSession httpSession) {
//        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
//        Cart cart = cartService.getCurrentCart(httpSession);
//        Order order = Order
//                .builder()
//                .recipientName(orderDto.getRecipientName())
//                .recipientMail(orderDto.getRecipientMail())
//                .status(OrderStatus.CREATED)
//                .orderItems(cart.getItems())
//                .accountUser((AccountUser) principal)
//                .build();
//        order.setPrice(cart.getTotalPrice());
//        orderService.save(order);
//        System.out.println(orderDto.getRecipientName());
//        return "order/create-order";
//    }
}
