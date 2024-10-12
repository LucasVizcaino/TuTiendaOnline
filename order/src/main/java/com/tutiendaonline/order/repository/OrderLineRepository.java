package com.tutiendaonline.order.repository;

import com.tutiendaonline.order.entity.OrderLine;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface OrderLineRepository extends JpaRepository<OrderLine, Integer> {
    List<OrderLine> findAllByOrder_Id(Integer orderId);
}
