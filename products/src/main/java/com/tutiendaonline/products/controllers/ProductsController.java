package com.tutiendaonline.products.controllers;

import com.tutiendaonline.products.entity.Products;
import com.tutiendaonline.products.service.ProductsService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;

@RestController
@AllArgsConstructor
@RequestMapping(path = "tutiendaonline/api/products")
@Slf4j
public class ProductsController {

    private final ProductsService productsService;

    @GetMapping(path = "/{name}")
    public ResponseEntity<Products> get(@PathVariable String name) {
        log.info("GET: product {}", name);
        Products product = this.productsService.readByName(name);
        if (product != null) {
            return ResponseEntity.ok(product);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping
    public ResponseEntity<Products> post(@RequestBody Products products){
        log.info("POST: product{}", products.getName());
        return ResponseEntity.created(URI.create(this.productsService.create(products).getName())).build();
    }

    @PutMapping(path = "{name}")
    public ResponseEntity<Products> put(@RequestBody Products products, @PathVariable String name){
        log.info("PUT: product{}", name);
        return ResponseEntity.ok(this.productsService.update(products, name));
    }

    @DeleteMapping(path = "{name}")
    public ResponseEntity<?> delete(@PathVariable String name){
        log.info("DELETE: product{}", name);
        return ResponseEntity.noContent().build();
    }

}
