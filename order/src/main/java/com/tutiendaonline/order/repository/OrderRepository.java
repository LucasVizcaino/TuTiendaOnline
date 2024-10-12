package com.tutiendaonline.order.repository;

import com.tutiendaonline.order.entity.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<Order, Integer> {
}
