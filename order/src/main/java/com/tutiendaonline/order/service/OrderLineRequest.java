package com.tutiendaonline.order.service;

public record OrderLineRequest(
        Integer id,
        Integer orderId,
        Integer productId,
        double quantity) {
}
