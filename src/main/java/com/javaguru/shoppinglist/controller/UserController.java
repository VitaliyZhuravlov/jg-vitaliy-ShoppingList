package com.javaguru.shoppinglist.controller;

import com.javaguru.shoppinglist.dto.UserDto;
import com.javaguru.shoppinglist.service.UserService;
import com.javaguru.shoppinglist.exceptions.UserNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import java.util.ArrayList;

@RestController
@RequestMapping("/users")
public class UserController {

    private final UserService service;

    public UserController(UserService service) {
        this.service = service;
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping
    public UserDto add(@RequestBody UserDto dto) {
        return service.create(dto);
    }

    @GetMapping
    public ArrayList<UserDto> findAllUsers() {
        return service.findAll();
    }

    @GetMapping("/{id}")
    public UserDto findUserById(@PathVariable Long id) {
        return service.findUserById(id);
    }

    @GetMapping("/{username}")
    public UserDto findUserByName(@PathVariable String username) {
        return service.findUserByName(username);
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @PutMapping
    public void update(@RequestBody UserDto dto) {
        service.update(dto);
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        service.delete(id);
    }

    @ResponseStatus(HttpStatus.NOT_FOUND)
    @ExceptionHandler
    public void handleNotFound(UserNotFoundException exception) {
        System.out.println(exception.getMessage());
    }
}
