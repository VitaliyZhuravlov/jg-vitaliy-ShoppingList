package com.javaguru.shoppinglist.console.productMenuActions;

import com.javaguru.shoppinglist.console.MenuAction;
import com.javaguru.shoppinglist.domain.ProductEntity;
import com.javaguru.shoppinglist.service.ProductService;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.util.Optional;
import java.util.Scanner;
@Component
@Order(4)
public class FindProductByNameAction implements MenuAction {

    private final ProductService service;

    public FindProductByNameAction(ProductService service) {
        this.service = service;
    }

    @Override
    public void execute(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter product name: ");
        String name = String.valueOf(scanner.nextLine());
        Optional<ProductEntity> productEntity = service.findProductByName(name);
        System.out.println(productEntity);
    }

    @Override
    public String toString() {
        return "Find product by name";
    }
}
