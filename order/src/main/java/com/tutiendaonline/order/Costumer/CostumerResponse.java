package com.tutiendaonline.order.Costumer;

public record CostumerResponse(
        String id,
        String firstname,
        String lastname,
        String email
) {
}
