package com.tutiendaonline.products.repositories;

import com.tutiendaonline.products.entity.Category;
import com.tutiendaonline.products.entity.Products;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ProductsRepository extends JpaRepository<Products, Long> {
    Optional<Products> findByname(String name);
}
