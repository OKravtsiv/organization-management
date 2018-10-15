package com.softserveinc.testapi.domain.controller;

import com.softserveinc.testapi.domain.model.entity.Product;
import com.softserveinc.testapi.domain.model.entity.User;
import com.softserveinc.testapi.domain.model.storage.ProductStorage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ProductController {

    @Autowired
    private ProductStorage productStorage;

    @GetMapping("/products")
    public ResponseEntity<List<Product>> getAllProducts() {
        return ResponseEntity.ok(productStorage.getAll());
    }

    @GetMapping("/products/{id}")
    public ResponseEntity<Product> getUserById(@PathVariable long id) {
        return ResponseEntity.ok(productStorage.getById(id));
    }

    @DeleteMapping("/products/{id}")
    public ResponseEntity deleteUser(@PathVariable long id) {
        productStorage.removeById(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }
}
