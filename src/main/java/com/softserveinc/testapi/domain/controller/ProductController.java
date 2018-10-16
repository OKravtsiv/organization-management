package com.softserveinc.testapi.domain.controller;

import com.softserveinc.testapi.domain.model.entity.Person;
import com.softserveinc.testapi.domain.model.entity.Product;
import com.softserveinc.testapi.domain.model.entity.User;
import com.softserveinc.testapi.domain.model.entity.dto.PersonDTO;
import com.softserveinc.testapi.domain.model.entity.dto.ProductDTO;
import com.softserveinc.testapi.domain.model.entity.dto.UserDTO;
import com.softserveinc.testapi.domain.model.storage.PersonStorage;
import com.softserveinc.testapi.domain.model.storage.ProductStorage;
import com.softserveinc.testapi.domain.model.storage.UserStorage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static com.softserveinc.testapi.domain.model.entity.dto.ProductDTO.*;

@RestController
public class ProductController {

    @Autowired
    private ProductStorage productStorage;

    @GetMapping("/products")
    public ResponseEntity<List<ProductDTO>> getAllProducts() {
        return ResponseEntity.ok(mapAll(productStorage.getAll()));
    }

    @GetMapping("/products/{id}")
    public ResponseEntity<ProductDTO> getUserById(@PathVariable long id) {
        return ResponseEntity.ok(new ProductDTO(productStorage.getById(id)));
    }

    @DeleteMapping("/products/{id}")
    public ResponseEntity deleteUser(@PathVariable long id) {
        productStorage.removeById(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }

    @PostMapping("/products")
    public ResponseEntity<ProductDTO> save(@RequestBody ProductDTO productDTO) {
        return ResponseEntity.ok(new ProductDTO(productStorage.save(ProductDTO.restore(productDTO))));
    }
}
