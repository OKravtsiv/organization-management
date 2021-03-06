package com.softserveinc.testapi.domain.controller;

import com.softserveinc.testapi.domain.model.entity.Product;
import com.softserveinc.testapi.domain.model.entity.dto.PersonDTO;
import com.softserveinc.testapi.domain.model.entity.dto.ProductDTO;
import com.softserveinc.testapi.domain.model.storage.PersonStorage;
import com.softserveinc.testapi.domain.model.storage.ProductStorage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static com.softserveinc.testapi.domain.model.entity.dto.PersonDTO.mapAll;

@RestController
@RequestMapping("/persons")
public class PersonController {
    @Autowired
    private PersonStorage personStorage;

    @Autowired
    private ProductStorage productStorage;

    @GetMapping
    public ResponseEntity<List<PersonDTO>> getAllUsers() {
        return ResponseEntity.ok(mapAll(personStorage.getAll()));
    }

    @GetMapping("/{id}")
    public ResponseEntity<PersonDTO> getUserById(@PathVariable long id) {
        return ResponseEntity.ok(new PersonDTO(personStorage.getById(id)));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity deleteUser(@PathVariable long id) {
        personStorage.removeById(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }

    @PostMapping("/{id}")
    public ResponseEntity<ProductDTO> addProduct(@PathVariable long id, ProductDTO productDTO) {
        Product product = productStorage.save(ProductDTO.restore(productDTO));
        product.setSeller(personStorage.getById(id));
        return ResponseEntity.ok(new ProductDTO(product));
    }
}
