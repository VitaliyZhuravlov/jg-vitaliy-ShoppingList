package com.javaguru.shoppinglist.controller;

import com.javaguru.shoppinglist.domain.UserEntity;
import com.javaguru.shoppinglist.service.UserService;
import com.javaguru.shoppinglist.exceptions.UserNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {

    private final UserService service;

    public UserController(UserService service) {
        this.service = service;
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping("/create")
    public UserEntity add(@RequestBody UserEntity entity) {
        return service.create(entity);
    }

    @GetMapping("/all")
    public List<UserEntity> findAllUsers() {
        return service.findAll();
    }

    @GetMapping("/id/{id}")
    public UserEntity findUserById(@PathVariable Long id) {
        return service.findUserById(id);
    }

    @GetMapping("/name/{username}")
    public UserEntity findUserByName(@PathVariable String username) {
        return service.findUserByName(username);
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @PutMapping("/update")
    public void update(@RequestBody UserEntity entity) {
        service.update(entity);
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping("/delete/{id}")
    public void delete(@PathVariable Long id) {
        service.delete(id);
    }

    @ResponseStatus(HttpStatus.NOT_FOUND)
    @ExceptionHandler
    public void handleNotFound(UserNotFoundException exception) {
        System.out.println(exception.getMessage());
    }
}
