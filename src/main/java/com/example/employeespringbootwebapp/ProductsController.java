package com.example.employeespringbootwebapp;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.*;

@Controller
@CrossOrigin
public class ProductsController {

    private Map<Integer, Product> products = new HashMap<>();

    public ProductsController() {
        products.put(1, new Product(1, "Swansea City shirt", 45));
        products.put(2, new Product(2, "Cardiff City shirt", 50));
        products.put(3, new Product(3, "Bugatti Divo",       1_000_000));
        products.put(4, new Product(4, "OLED 55in HDTV",     1250));
        products.put(5, new Product(5, "Carving skis",       450));
        products.put(6, new Product(6, "Ski boots",          175));
    }

    @GetMapping(value="/products", produces={"application/json","application/xml"})
    public ResponseEntity<Collection<Product>> getProducts() {
        return ResponseEntity.ok().body(products.values());
    }
}
