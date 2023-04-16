package com.example.demo.Entity;

import com.fasterxml.jackson.databind.cfg.EnumFeature;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Cart {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long cartId;

    private String customerName;

    private String cardNumber;
    
    @Enumerated(EnumType.STRING)
    private EnumStatus cartStatus;
    
    public Cart() {
    }

    public Cart(long cartId, String customerName, String cardNumber, EnumStatus cartStatus) {
        this.cartId = cartId;
        this.customerName = customerName;
        this.cardNumber = cardNumber;
        this.cartStatus = cartStatus;
    }

    public long getCartId() {
        return cartId;
    }

    public void setCartId(long cartId) {
        this.cartId = cartId;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public String getCardNumber() {
        return cardNumber;
    }

    public void setCardNumber(String cardNumber) {
        this.cardNumber = cardNumber;
    }

    public EnumStatus getCartStatus() {
        return cartStatus;
    }

    public void setCartStatus(EnumStatus cartStatus) {
        this.cartStatus = cartStatus;
    }
}
