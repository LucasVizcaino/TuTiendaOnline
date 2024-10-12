package com.tutiendaonline.order.service;

import com.tutiendaonline.order.Costumer.CostumerClient;
import com.tutiendaonline.order.controller.OrderRequest;
import com.tutiendaonline.order.entity.OrderMapper;
import com.tutiendaonline.order.exception.BusinessException;
import com.tutiendaonline.order.repository.OrderRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class OrderService {

    private final OrderRepository orderRepository;
    private final CostumerClient costumerClient;
    private final ProductClient productClient;

    private final OrderMapper mapper;
    private final OrderLineService orderLineService;

    public Integer createdOrder(OrderRequest request) {
        var customer = this.costumerClient.findCostumerById(request.userId())
                .orElseThrow(() -> new BusinessException(""));
        this.productClient.purchaseProducts(request.products());

        var order = this.orderRepository.save(mapper.toOrder(request));

        for(PurchaseRequest purchaseRequest: request.products()){
            orderLineService.saveOrderLine(
                    new OrderLineRequest(
                            null,
                            order.getId(),
                            purchaseRequest.productId(),
                            purchaseRequest.quantity()
                    )
            );
        }
        return null;
    }
}
