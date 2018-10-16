package com.softserveinc.testapi.domain.controller;

import com.softserveinc.testapi.domain.model.entity.Person;
import com.softserveinc.testapi.domain.model.entity.User;
import com.softserveinc.testapi.domain.model.storage.PersonStorage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class PersonController {
    @Autowired
    private PersonStorage personStorage;

    @GetMapping("/persons")
    public ResponseEntity<List<Person>> getAllUsers() {
        return ResponseEntity.ok(personStorage.getAll());
    }

    @GetMapping("/persons/{id}")
    public ResponseEntity<Person> getUserById(@PathVariable long id) {
        return ResponseEntity.ok(personStorage.getById(id));
    }

    @DeleteMapping("/persons/{id}")
    public ResponseEntity deleteUser(@PathVariable long id) {
        personStorage.removeById(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }
}
