package com.example.demo.Service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import org.springframework.stereotype.Service;

import com.example.demo.Business.CartProductDto;
import com.example.demo.Entity.CartProduct;
import com.example.demo.Repository.CartProductRepository;

@Service
public class CartProductServiceImpl implements CartProductService {

    CartProductRepository cartProductRepository;
    
    public CartProductServiceImpl(CartProductRepository cartProductRepository) {
        this.cartProductRepository = cartProductRepository;
    }

    @Override
    public List<CartProductDto> list(long cartId) {
        List<CartProductDto> cartProductDtoList = new ArrayList<>();
        for(CartProduct cartProduct : cartProductRepository.findAll()){
            if(cartProduct.getCart().getCartId()==cartId){
                cartProductDtoList.add(toDto(cartProduct));
            }
        }
        Collections.sort(cartProductDtoList, new SortById());  
        return cartProductDtoList;
    }

    private CartProductDto toDto(CartProduct cartProduct) {
        CartProductDto cartProductDto = new CartProductDto(cartProduct.getCartProductId(), cartProduct.getCart(), cartProduct.getProduct(), (int)cartProduct.getSalesQuantity());
        return cartProductDto;
    }
    
}


class SortById implements Comparator<CartProductDto> {  
    public int compare(CartProductDto a, CartProductDto b)  
    {  
        return (int)a.getCartProductId() - (int)b.getCartProductId();  
    }  
}  