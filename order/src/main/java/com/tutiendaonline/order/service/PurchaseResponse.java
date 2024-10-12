package com.tutiendaonline.order.service;

import java.math.BigDecimal;

public record PurchaseResponse(
        Integer productId,
        String name,
        String description,
        BigDecimal price,
        Integer stock,
        double quantity
) {
}
