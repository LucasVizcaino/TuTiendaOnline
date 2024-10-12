package com.tutiendaonline.products.repositories;

import com.tutiendaonline.products.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ProductsRepository extends JpaRepository<Product, Integer> {
    Optional<Product> findByname(String name);

    List<Product> findAllByIdIn(List<Integer> productIds);
}
