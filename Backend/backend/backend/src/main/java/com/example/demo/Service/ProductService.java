package com.example.demo.Service;
import java.util.List;


import com.example.demo.Business.*;

public interface ProductService {
    
    List<ProductDto> list(long categoryId);

    ProductDto get(long productId);

}
