package com.tutiendaonline.products.repositories;

import com.tutiendaonline.products.entity.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductsRepository extends JpaRepository<Category, Long> {
}
