package com.tutiendaonline.products.controllers;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
@RequestMapping(path = "products")
@Slf4j
public class ProductsController {

    @GetMapping("/")
    public String home() {
            return "home"; // Nombre de la vista que será renderizada
    }

}
