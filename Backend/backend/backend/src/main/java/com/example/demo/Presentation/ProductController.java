package com.example.demo.Presentation;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.Business.*;
import com.example.demo.Service.ProductService;

@RestController
@RequestMapping("/product")
public class ProductController {
    
    private ProductService productService;

    
    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping("/products/{categoryid}")
    public List<ProductDto> list(@PathVariable("categoryid") long categoryId){
        return productService.list(categoryId);
    }

    @GetMapping("/product/{id}")
    public ProductDto get(@PathVariable("id")long id){
        return productService.get(id);
    }
    
}
