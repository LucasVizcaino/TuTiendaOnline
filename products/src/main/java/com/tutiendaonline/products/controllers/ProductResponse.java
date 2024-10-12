package com.tutiendaonline.products.controllers;

import com.tutiendaonline.products.entity.Category;


import java.math.BigDecimal;

public record ProductResponse(
        Integer id,
        String name,
        String description,
        BigDecimal price,
        Integer stock,
        Integer categoryId,
        String categoryName
) {
}
