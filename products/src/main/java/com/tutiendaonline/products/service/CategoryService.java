package com.tutiendaonline.products.service;

import com.tutiendaonline.products.entity.Category;
import com.tutiendaonline.products.repositories.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Optional;

public class CategoryService {

    @Autowired
    private CategoryRepository categoryRepository;

    public List<Category> getAllCategories(){
        return categoryRepository.findAll();
    }

    public Optional<Category> getById(Long id){
        return categoryRepository.findById(id);
    }

}
