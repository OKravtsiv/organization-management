package com.softserveinc.testapi.domain.controller;

import com.softserveinc.testapi.domain.model.dto.UserDTO;
import com.softserveinc.testapi.domain.model.entity.User;
import com.softserveinc.testapi.domain.model.storage.UserStorage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController("/users")
public class UserController {
    @Autowired
    private UserStorage userStorage;

    @GetMapping
    public ResponseEntity<List<UserDTO>> getAllUsers() {
        return null;
    }
}
