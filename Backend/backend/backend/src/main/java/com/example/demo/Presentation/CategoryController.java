package com.example.demo.Presentation;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.Business.*;
import com.example.demo.Service.CategoryService;

@RestController
@RequestMapping("/category")
public class CategoryController {

    private CategoryService categoryService;


    public CategoryController(CategoryService categoryService) {
        this.categoryService = categoryService;
    }

    @GetMapping("/categories")
    public List<CategoryDto> list(){
        return categoryService.list();
    }
    
}
