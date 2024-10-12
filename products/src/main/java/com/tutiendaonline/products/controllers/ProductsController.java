package com.tutiendaonline.products.controllers;

import com.tutiendaonline.products.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping(path = "/api/v1/products")
public class ProductsController {

    private final ProductService productsService;



    @PostMapping
    public ResponseEntity<Integer> create(@RequestBody @Valid ProductRequest request){
        return ResponseEntity.ok(productsService.createProductWithCategory(request));
    }



    @PostMapping("/purchase")
    public ResponseEntity<List<ProductPurchaseResponse>> productPurchase(
            @RequestBody List<ProductPurchaseRequest> request
    ){
        return ResponseEntity.ok(productsService.purchaseProducts(request));
    }

    @GetMapping("/{product-id}")
    public ResponseEntity<ProductResponse> findById(
            @PathVariable("product-id") Integer productId
    ){
        return ResponseEntity.ok(productsService.findById(productId));
    }

    @GetMapping
    public ResponseEntity<List<ProductResponse>> findAll(){
        return ResponseEntity.ok(productsService.findAll());
    }
}
