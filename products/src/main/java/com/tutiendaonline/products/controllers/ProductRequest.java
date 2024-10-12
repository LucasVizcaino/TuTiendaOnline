package com.tutiendaonline.products.controllers;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;
import java.math.BigDecimal;

public record ProductRequest(
        Integer id,
        @NotNull
        String name,
        @NotNull
        String description,
        @Positive
        BigDecimal price,
        @Positive
        Integer stock,
        @NotNull
        String categoryName
) {
}
