package com.ajaysw.service;

import com.ajaysw.payload.CartDTO;

import java.util.List;
public interface CartService {
    CartDTO addProductToCart(Long productId, Integer quantity);

    List<CartDTO> getAllCarts();
}