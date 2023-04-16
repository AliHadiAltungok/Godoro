package com.example.demo.Service;

import java.lang.StackWalker.Option;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.example.demo.Business.CartDto;
import com.example.demo.Business.CartProductDto;
import com.example.demo.Business.ProductDto;
import com.example.demo.Entity.Cart;
import com.example.demo.Entity.CartProduct;
import com.example.demo.Entity.EnumStatus;
import com.example.demo.Entity.Product;
import com.example.demo.Repository.CartProductRepository;
import com.example.demo.Repository.CartRepository;
import com.example.demo.Repository.ProductRepository;

@Service
public class CartServiceImpl implements CartService {

    CartRepository cartRepository;
    CartProductRepository cartProductRepository;
    ProductRepository productRepository;

    public CartServiceImpl(CartRepository cartRepository, CartProductRepository cartProductRepository,
            ProductRepository productRepository) {
        this.cartRepository = cartRepository;
        this.cartProductRepository = cartProductRepository;
        this.productRepository = productRepository;
    }

    @Override
    public CartDto get(long cartId) {
        Optional<Cart> optional = cartRepository.findById(cartId);
        if(optional.isPresent()){
            return toDto(optional.get());
        }
        else
        {
            Cart cart=new Cart (0, "Ali Altungök", "165465", EnumStatus.NEW);
            cartRepository.save(cart);
        }
        List<Cart> carts = (List<Cart>) cartRepository.findAll();
        return toDto(carts.get(0));
    }

    @Override
    public void add(long cartId, long productId) {
        Optional<Cart> optionalCart = cartRepository.findById(cartId);
        Optional<Product> optionalProduct = productRepository.findById(productId);
        if(optionalCart.isPresent() && optionalProduct.isPresent() && optionalCart.get().getCartStatus()==EnumStatus.NEW){
            List<CartProduct> cartProduct = cartProductRepository.findByCartIdAndProductId(cartId,productId);
            if(cartProduct.isEmpty()){
                CartProduct cartProductNew = new CartProduct(0, optionalCart.get(), optionalProduct.get(), 1);
                cartProductRepository.save(cartProductNew);
            }
            else
            {
                double salesQuantity = cartProduct.get(0).getSalesQuantity();
                salesQuantity++;
                cartProduct.get(0).setSalesQuantity((int)salesQuantity);
                cartProductRepository.save(cartProduct.get(0));
            }
        }
    }

    @Override
    public void remove(long cartId, long productId) {
        Optional<Cart> optionalCart = cartRepository.findById(cartId);
        Optional<Product> optionalProduct = productRepository.findById(productId);
        if(optionalCart.isPresent() && optionalProduct.isPresent() && optionalCart.get().getCartStatus()==EnumStatus.NEW){
            List<CartProduct> cartProduct = cartProductRepository.findByCartIdAndProductId(cartId,productId);
            if(!cartProduct.isEmpty()){
                double salesQuantity = cartProduct.get(0).getSalesQuantity();
                if(salesQuantity==1){
                    cartProductRepository.delete((cartProduct.get(0)));
                }
                else
                {
                    salesQuantity--;
                    cartProduct.get(0).setSalesQuantity((int)salesQuantity);
                    cartProductRepository.save(cartProduct.get(0));
                }
            }
        }
    }

    @Override
    public void checkout(CartDto cartDto) {//////////////hereeeeeeee
            Optional<Cart> optional = cartRepository.findById(cartDto.getCartId());
            if(optional.isPresent()){
                if(optional.get().getCartStatus()==EnumStatus.NEW){
                    optional.get().setCartStatus(EnumStatus.COMPLETED);
                    cartRepository.save(optional.get());
                }
            }
    }
    
    private CartDto toDto(Cart cart) {
        CartDto cartDto= new CartDto(cart.getCartId(), cart.getCustomerName(), cart.getCardNumber(), cart.getCartStatus());
        return cartDto;
    }
}
