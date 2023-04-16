package com.example.demo.Service;

import java.util.List;

import com.example.demo.Business.CartProductDto;

public interface CartProductService {
    
    List<CartProductDto> list(long cartId);

}