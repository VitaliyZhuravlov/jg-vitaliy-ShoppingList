package com.javaguru.shoppinglist.console.productMenuActions;

import com.javaguru.shoppinglist.console.MenuAction;
import com.javaguru.shoppinglist.service.ProductService;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Component
@Order(10)
public class FindAllProductsAction implements MenuAction {
    private final ProductService productService;

    public FindAllProductsAction(ProductService productService) {
        this.productService = productService;
    }

    @Override
    public void execute() {
        productService.findAll()
                .forEach(System.out::println);
    }

    @Override
    public String toString() {
        return "Find all products";
    }
}
