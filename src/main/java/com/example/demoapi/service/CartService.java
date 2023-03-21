package com.example.demoapi.service;

import com.example.demoapi.entity.Cart;
import com.example.demoapi.listener.Responder;
import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

@Service
@RequiredArgsConstructor
public class CartService {

    public static final String CART_ATTRIBUTE = "cart";

    private final ProductService productService;

    Cart cart = new Cart();

    Responder responder = new Responder();

    public Cart getCurrentCart(HttpSession session) {
        Cart cart = (Cart) session.getAttribute(CART_ATTRIBUTE);

        if (cart == null) {
            cart = new Cart();
            session.setAttribute(CART_ATTRIBUTE, cart);
        }
        return cart;
    }

    public void addToCart(HttpSession session, Long productId) {
        productService.findProductById(productId)
                .ifPresent((p) -> getCurrentCart(session).add(p));
        cart.addListener(responder);
        responder.addData();
    }

    public void removeFromCart(HttpSession session, Long productId) {
        productService.findProductById(productId)
                .ifPresent((p) -> getCurrentCart(session).remove(p));
        cart.addListener(responder);
        responder.removeData();
    }

    public BigDecimal getTotalPrice(HttpSession session) {
        return getCurrentCart(session).getTotalPrice();
    }

    public void resetCart(HttpSession session) {
        session.removeAttribute(CART_ATTRIBUTE);
    }
}
