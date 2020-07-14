package com.javaguru.shoppinglist.console;

import com.javaguru.shoppinglist.domain.ProductEntity;
import com.javaguru.shoppinglist.service.ProductService;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;
import java.util.Scanner;
@Component
@Order(2)
public class FindProductByIdAction implements MenuAction {

    private final ProductService service;

    public FindProductByIdAction(ProductService service) {
        this.service = service;
    }
    @Override
    public void execute(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter product id: ");
        Long id = Long.valueOf(scanner.nextLine());
        ProductEntity productEntity = service.findProductById(id);
        System.out.println("Product founded" + productEntity);
    }

    @Override
    public String toString() {
        return "Find product by id";
    }
}
