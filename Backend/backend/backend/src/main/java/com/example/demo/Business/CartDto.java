package com.example.demo.Business;

import com.example.demo.Entity.EnumStatus;

public class CartDto {

    private long cartId;

    private String customerName;

    private String cardNumber;
    
    private EnumStatus cartStatus;

    public CartDto() {
    }

    public CartDto(long cartId, String customerName, String cardNumber, EnumStatus cartStatus) {
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
