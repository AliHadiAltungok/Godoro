package com.example.demo.Business;

import java.util.List;

import com.example.demo.Entity.Cart;
import com.example.demo.Entity.Product;

public class CartProductDto {
    
    private long cartProductId;

    private Cart cart;

    private Product product;
    
    private int salesQuantity;

    public CartProductDto() {
    }

    public CartProductDto(long cartProductId, Cart cart, Product product, int salesQuantity) {
        this.cartProductId = cartProductId;
        this.cart = cart;
        this.product = product;
        this.salesQuantity = salesQuantity;
    }

    public long getCartProductId() {
        return cartProductId;
    }

    public void setCartProductId(long cartProductId) {
        this.cartProductId = cartProductId;
    }

    public Cart getCart() {
        return cart;
    }

    public void setCart(Cart cart) {
        this.cart = cart;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public double getSalesQuantity() {
        return salesQuantity;
    }

    public void setSalesQuantity(int salesQuantity) {
        this.salesQuantity = salesQuantity;
    }

    
    
}
