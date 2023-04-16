package com.example.demo.Repository;

import org.springframework.data.repository.CrudRepository;

import com.example.demo.Entity.Category;

public interface CategoryRepository extends CrudRepository<Category,Long> {
    
}
