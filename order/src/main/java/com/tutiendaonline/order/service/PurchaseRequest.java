package com.tutiendaonline.order.service;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

public record PurchaseRequest(
        @NotNull
        Integer productId,
        @Positive
        double quantity
) {
}
