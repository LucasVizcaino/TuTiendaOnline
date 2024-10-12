package com.tutiendaonline.products.service;

import com.tutiendaonline.products.controllers.ProductPurchaseRequest;
import com.tutiendaonline.products.controllers.ProductPurchaseResponse;
import com.tutiendaonline.products.controllers.ProductRequest;
import com.tutiendaonline.products.controllers.ProductResponse;
import com.tutiendaonline.products.entity.Category;
import com.tutiendaonline.products.handler.ProductPurchaseException;
import com.tutiendaonline.products.repositories.CategoryRepository;
import com.tutiendaonline.products.repositories.ProductsRepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.swing.text.html.parser.Entity;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ProductService {

    private final ProductsRepository repository;
    private final ProductMapper mapper;
    private final CategoryRepository categoryRepository;




    public List<ProductPurchaseResponse> purchaseProducts(List<ProductPurchaseRequest> request) {
        var productIds = request
                .stream()
                .map(ProductPurchaseRequest::productId)
                .toList();
        var storedProducts = repository.findAllByIdIn(productIds);
        if (productIds.size() != storedProducts.size()){
            throw new ProductPurchaseException("One or more products not exist");
        }
        var storedRequest = request
                .stream()
                .sorted(Comparator.comparing(ProductPurchaseRequest::productId))
                .toList();
        var purchaseProducts = new ArrayList<ProductPurchaseResponse>();
        for(int i = 0; i < storedProducts.size(); i++ ){
            var product = storedProducts.get(i);
            var productRequest = storedRequest.get(i);
            if (product.getStock() < productRequest.quantity()){
                throw new ProductPurchaseException("Insufficient stock quantity for product with ID::  " +  productRequest.productId());
            }
            var newStock = product.getStock() - productRequest.quantity();
            product.setStock(newStock);
            repository.save(product);

            purchaseProducts.add(mapper.toProductPurchaseResponse(product, productRequest.quantity()));
        }
        return purchaseProducts;
    }

    public ProductResponse findById(Integer productId) {
        return repository.findById(productId)
                .map(mapper::toProductResponse)
                .orElseThrow(()-> new EntityNotFoundException("Product not found with the id: "+ productId));
    }

    public List<ProductResponse> findAll() {
        return repository.findAll()
                .stream()
                .map(mapper::toProductResponse)
                .collect(Collectors.toList());
    }

    public Integer createProductWithCategory(ProductRequest request) {
        // Busca la categoría por nombre; si no existe, la crea usando el patrón Builder
        var category = categoryRepository.findByName(request.categoryName())
                .orElseGet(() -> categoryRepository.save(
                        Category.builder()
                                .name(request.categoryName())
                                .build()
                ));

        // Mapea el request a la entidad Producto
        var product = mapper.toProduct(request);
        product.setCategory(category); // Asigna la categoría al producto

        return repository.save(product).getId(); // Guarda el producto en la base de datos
    }
}
