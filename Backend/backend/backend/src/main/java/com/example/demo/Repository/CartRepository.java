package com.example.demo.Repository;

import org.springframework.data.repository.CrudRepository;

import com.example.demo.Entity.Cart;

public interface CartRepository extends CrudRepository<Cart,Long> {
    
}
