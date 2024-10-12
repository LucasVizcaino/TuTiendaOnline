package com.tutiendaonline.order.controller;

import com.tutiendaonline.order.entity.PaymentMethod;
import com.tutiendaonline.order.service.PurchaseRequest;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

import java.math.BigDecimal;
import java.util.List;

public record OrderRequest(
        Integer id,
        String reference,
        @Positive
        BigDecimal amount,
        @NotNull
        @NotBlank
        @NotEmpty
        String userId,
        @NotEmpty
        PaymentMethod paymentMethod,
        List<PurchaseRequest> products
) {
}
