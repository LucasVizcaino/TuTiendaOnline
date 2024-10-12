package com.tutiendaonline.products.controllers;

import javax.validation.constraints.NotNull;

public record ProductPurchaseRequest(
        @NotNull
        Integer productId,
        @NotNull
        Integer quantity
) {
}
