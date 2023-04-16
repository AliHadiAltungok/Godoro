package com.example.demo.Presentation;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.Business.CartDto;
import com.example.demo.Service.CartService;

@RestController
@RequestMapping("/cart")
public class CartController {

    private CartService cartService;
    
    public CartController(CartService cartService) {
        this.cartService = cartService;
    }

    @GetMapping("/get/{id}")
    public CartDto get(@PathVariable("id")long id){
        return cartService.get(id);
    }


    @PostMapping("/add/{cartid}/{productid}")
    public void add(@PathVariable("cartid")long cartId, @PathVariable("productid")long productId){
        cartService.add(cartId, productId);
    }

    @CrossOrigin(origins = "http://localhost:8080")
    @DeleteMapping("/remove/{cartid}/{productid}")
    public void delete(@PathVariable("cartid")long cartId, @PathVariable("productid")long productId){
        cartService.remove(cartId, productId);
    }

    @PutMapping("/checkout")
    public void checkout(@RequestBody CartDto cartDto){
        cartService.checkout(cartDto);
    }
}
