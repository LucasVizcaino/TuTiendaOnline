package com.tutiendaonline.products.service;

import com.tutiendaonline.products.entity.Category;
import com.tutiendaonline.products.entity.Products;
import com.tutiendaonline.products.repositories.CategoryRepository;
import com.tutiendaonline.products.repositories.ProductsRepository;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.NoSuchElementException;

@Service
@Transactional
@Slf4j
@AllArgsConstructor
public class ProductsServiceImp implements ProductsService {

    private final ProductsRepository productsRepository;
    private final CategoryRepository categoryRepository;


    @Override
    public Products create(Products products){
        Category category = categoryRepository.findById(products.getCategory().getId())
                .orElseThrow(() -> new IllegalArgumentException("CategoryNotFound"));
        products.setCategory(category);
        return productsRepository.save(products);
    }

    @Override
    public Products readByName(String name) {
        return this.productsRepository.findByname(name)
                .orElseThrow(()-> new NoSuchElementException("Product not found"));
    }

    @Override
    public Products update(Products products, String name){
        var productUpdate = this.productsRepository.findByname(name)
                .orElseThrow(() -> new NoSuchElementException("Company not found"));
        productUpdate.setName(products.getName());
        productUpdate.setDescription(products.getDescription());
        productUpdate.setPrice(products.getPrice());
        productUpdate.setStock(products.getStock());
        productUpdate.setCategory(products.getCategory());
        return this.productsRepository.save(productUpdate);
    }

    @Override
    public void delete(String name) {
        var productDelete = this.productsRepository.findByname(name)
                .orElseThrow(() -> new NoSuchElementException("No product found"));
        this.productsRepository.delete(productDelete);
    }
}
