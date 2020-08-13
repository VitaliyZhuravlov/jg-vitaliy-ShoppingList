package com.javaguru.shoppinglist.controller;

import com.javaguru.shoppinglist.domain.UserEntity;
import com.javaguru.shoppinglist.service.UserService;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {

    private final UserService service;

    public UserController(UserService service) {
        this.service = service;
    }
    @PostMapping("/create")
    public UserEntity addProduct(@RequestBody UserEntity entity) {
        return service.create(entity);
    }

    @GetMapping("/all")
    public List<UserEntity> findAllProducts() {
        return service.findAll();
    }

    @GetMapping("/id/{id}")
    public UserEntity findUserById(@PathVariable Long id) {
        return service.findUserById(id);
    }

    @GetMapping("/product/{username}")
    public UserEntity findUserByName(@PathVariable String username) {
        return service.findUserByName(username);
    }

    @PutMapping("/update")
    public UserEntity update(@RequestBody UserEntity entity) {
        return service.update(entity);
    }

    @DeleteMapping("/delete/{id}")
    public String delete(@PathVariable Long id) {
        return service.delete(id);
    }
}
