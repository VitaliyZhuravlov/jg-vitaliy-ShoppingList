package com.javaguru.shoppinglist.controller;

import com.javaguru.shoppinglist.dto.OrderRequest;
import com.javaguru.shoppinglist.dto.UserDto;
import com.javaguru.shoppinglist.service.UserService;
import org.springframework.web.bind.annotation.*;
import java.util.ArrayList;

@RestController
@RequestMapping("/order")
public class OrderController {

    private final UserService userService;

    public OrderController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/placeOrder")
    public UserDto placeOrder(@RequestBody OrderRequest request){
        return userService.create(request.getDto());
    }

    @GetMapping("/findAllOrders")
    public ArrayList<UserDto> findAllOrders(){
        return userService.findAll();
    }
}
