package com.example.demo.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.example.demo.Entity.CartProduct;

public interface CartProductRepository extends CrudRepository<CartProduct,Long> {
    
    @Query("SELECT x FROM CartProduct x WHERE (x.cart.cartId) = :cartId and (x.product.productId) = :productId")
    public List<CartProduct> findByCartIdAndProductId(@Param("cartId") long cartId, @Param("productId") long productId);
}
