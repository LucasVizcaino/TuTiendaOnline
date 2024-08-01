package com.tutiendaonline.products.service;

import com.tutiendaonline.products.entity.Products;
import com.tutiendaonline.products.repositories.CategoryRepository;
import com.tutiendaonline.products.repositories.ProductsRepository;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
@Slf4j
@AllArgsConstructor
public class ProductsServiceImp implements ProductsService {

    private final ProductsRepository productsRepository;
    private final CategoryRepository categoryRepository;


    @Override
    public Products create(Products products){
        return products;
    }

    @Override
    public Products readByName(String name) {
        return null;
    }

    @Override
    public Products update(Products products){
        return null;
    }

    @Override
    public void delete(Products name) {
    }
}
