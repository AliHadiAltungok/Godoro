package com.example.demo.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.example.demo.Business.ProductDto;
import com.example.demo.Entity.Product;
import com.example.demo.Repository.ProductRepository;

@Service
public class ProductServiceImpl implements ProductService {

    ProductRepository productRepository;

    
    public ProductServiceImpl(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }


    @Override
    public List<ProductDto> list(long categoryId) {
        List<ProductDto> productDtoList = new ArrayList<>();
        for(Product product : productRepository.findAllByCategoryId(categoryId)){
            productDtoList.add(toDto(product));
        }
        return productDtoList;
    }

    @Override
    public ProductDto get(long productId) {
        Optional<Product> optional = productRepository.findById(productId);
        if(optional.isPresent()){
            return toDto(optional.get());
        }
        return null;
    }

    private ProductDto toDto(Product product) {
        ProductDto productDto= new ProductDto(product.getProductId(), product.getProductName(), product.getSalesPrice(), product.getCategory());
        return productDto;
    }
}
