package com.example.demo.Service;

import com.example.demo.Business.*;

public interface CartService {
    
    CartDto get(long cartId);

    void add(long cartId, long productId);

    void remove(long cartId, long productId);

    void checkout(CartDto cartDto);
}
