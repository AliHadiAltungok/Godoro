package com.example.demo.Service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.example.demo.Business.CategoryDto;
import com.example.demo.Entity.Category;
import com.example.demo.Repository.CategoryRepository;

@Service
public class CategoryServiceImpl implements CategoryService {

    CategoryRepository categoryRepository;

    public CategoryServiceImpl(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    @Override
    public List<CategoryDto> list() {
        List<CategoryDto> categoryDtoList = new ArrayList<>();
        for(Category category : categoryRepository.findAll()){
            categoryDtoList.add(toDto(category));
        }
        return categoryDtoList;
    }

    private CategoryDto toDto(Category category) {
        CategoryDto categoryDto = new CategoryDto();
        categoryDto.setCategoryId(category.getCategoryId());
        categoryDto.setCategoryName(category.getCategoryName());
        return categoryDto;
    }
    
}
