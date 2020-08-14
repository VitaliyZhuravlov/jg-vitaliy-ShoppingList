package com.javaguru.shoppinglist.controller;

import com.javaguru.shoppinglist.domain.UserEntity;
import com.javaguru.shoppinglist.dto.OrderRequest;
import com.javaguru.shoppinglist.service.UserService;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/order")
public class OrderController {

    private final UserService userService;

    public OrderController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/placeOrder")
    public UserEntity placeOrder(@RequestBody OrderRequest request){
        return userService.create(request.getUserEntity());
    }

    @GetMapping("/findAllOrders")
    public List<UserEntity> findAllOrders(){
        return userService.findAll();
    }
}
