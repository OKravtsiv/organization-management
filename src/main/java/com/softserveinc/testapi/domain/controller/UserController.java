package com.softserveinc.testapi.domain.controller;

import com.softserveinc.testapi.domain.model.entity.dto.UserDTO;
import com.softserveinc.testapi.domain.model.storage.UserStorage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static com.softserveinc.testapi.domain.model.entity.dto.UserDTO.mapAll;

@RestController
@RequestMapping("/users")
public class UserController {
    @Autowired
    private UserStorage userStorage;

    @GetMapping
    public ResponseEntity<List<UserDTO>> getAllUsers() {
        return ResponseEntity.ok(mapAll(userStorage.getAll()));
    }

    @GetMapping("/{id}")
    public ResponseEntity<UserDTO> getUserById(@PathVariable long id) {
        return ResponseEntity.ok(new UserDTO(userStorage.getById(id)));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity deleteUser(@PathVariable long id) {
        userStorage.removeById(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }
}
