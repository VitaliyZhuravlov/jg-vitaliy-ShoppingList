package com.javaguru.shoppinglist.service;

import com.javaguru.shoppinglist.domain.ProductEntity;
import com.javaguru.shoppinglist.domain.UserEntity;
import org.springframework.stereotype.Service;
import java.util.Optional;

@Service
public class UserProductService {

    private final UserService userService;
    private final ProductService productService;

    public UserProductService(UserService userService, ProductService productService) {
        this.userService = userService;
        this.productService = productService;
    }

    public void assignProductToUser(Long productId, Long userId) {
        ProductEntity product = productService.findProductById(productId);
        UserEntity user = userService.findUserById(userId);
        product.setUser(user);
        productService.update(product);
    }
}
