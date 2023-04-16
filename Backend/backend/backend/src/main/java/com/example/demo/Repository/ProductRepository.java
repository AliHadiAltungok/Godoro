package com.example.demo.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.example.demo.Entity.Product;

public interface ProductRepository extends CrudRepository<Product,Long> {
    
 @Query("SELECT x FROM Product x WHERE (x.category.categoryId) = :categoryId")
    public List<Product> findAllByCategoryId(@Param("categoryId") long categoryId);
    
}
