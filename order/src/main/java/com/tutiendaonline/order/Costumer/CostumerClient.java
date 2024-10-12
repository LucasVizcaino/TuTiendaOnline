package com.tutiendaonline.order.Costumer;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.Optional;

@FeignClient(
    name = "user-service",
    url = "${application.config.costumer-url}"
)
public interface CostumerClient {

    @GetMapping("/{customer-id}")
    Optional<CostumerResponse> findCostumerById(@PathVariable("customer-id")String costumerId);

}
