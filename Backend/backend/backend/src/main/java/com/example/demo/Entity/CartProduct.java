package com.example.demo.Entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class CartProduct {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long cartProductId;

    @ManyToOne
    @JoinColumn(name = "cartId")
    private Cart cart;


    @ManyToOne
    @JoinColumn(name= "productId")
    private Product product;
    
    private int salesQuantity;

    public CartProduct() {
    }

    public CartProduct(long cartProductId, Cart cart, Product product, int salesQuantity) {
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
