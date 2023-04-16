package com.example.demo.Presentation;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.Business.CartProductDto;
import com.example.demo.Service.CartProductService;

@RestController
@RequestMapping("/cartproduct")
public class CartProductController {
 
    private CartProductService cartProductService;

    public CartProductController(CartProductService cartProductService) {
        this.cartProductService = cartProductService;
    }

    @GetMapping("/list/{cardId}")
    public List<CartProductDto> list(@PathVariable("cardId")long cardId){
        return cartProductService.list(cardId);
    }
    
}
