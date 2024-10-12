package com.tutiendaonline.products.service;

import com.tutiendaonline.products.controllers.ProductPurchaseResponse;
import com.tutiendaonline.products.controllers.ProductRequest;
import com.tutiendaonline.products.controllers.ProductResponse;
import com.tutiendaonline.products.entity.Category;
import com.tutiendaonline.products.entity.Product;
import org.springframework.stereotype.Service;

@Service
public class ProductMapper {
    public Product toProduct(ProductRequest request) {
        return Product.builder()
                .id(request.id())
                .name(request.name())
                .description(request.description())
                .price(request.price())
                .stock(request.stock())
                .category(
                        Category
                                .builder()
                                .name(request.categoryName())
                                .build())
                .build();

    }

    public ProductResponse toProductResponse(Product product) {
        return new ProductResponse(
                product.getId(),
                product.getName(),
                product.getDescription(),
                product.getPrice(),
                product.getStock(),
                product.getCategory().getId(),
                product.getCategory().getName()
        );
    }

    public ProductPurchaseResponse toProductPurchaseResponse(Product product, Integer quantity) {
        return new ProductPurchaseResponse(
                product.getId(),
                product.getName(),
                product.getDescription(),
                product.getPrice(),
                quantity
        );
    }
}
