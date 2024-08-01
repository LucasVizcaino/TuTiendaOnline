package com.tutiendaonline.products.service;

import com.tutiendaonline.products.entity.Products;

public interface ProductsService {
    Products readByName(String name);
    Products create(Products products);
    Products update(Products products, String name);
    void delete(String name);
}
