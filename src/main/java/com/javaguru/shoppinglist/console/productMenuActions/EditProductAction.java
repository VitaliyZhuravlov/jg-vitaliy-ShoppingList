package com.javaguru.shoppinglist.console.productMenuActions;

import com.javaguru.shoppinglist.console.MenuAction;
import com.javaguru.shoppinglist.domain.ProductEntity;
import com.javaguru.shoppinglist.dto.ProductDto;
import com.javaguru.shoppinglist.service.ProductService;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.util.Scanner;
@Component
@Order(1)
public class EditProductAction implements MenuAction {

    private final ProductService service;

    public EditProductAction(ProductService service) {
        this.service = service;
    }

    @Override
    public void execute() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Please enter id: ");
        Long id = Long.valueOf(scanner.nextLine());
        System.out.println("Enter product name: ");
        String name = scanner.nextLine();
        System.out.println("Enter product price: ");
        BigDecimal price = new BigDecimal(scanner.nextLine());
        System.out.println("Enter product discount: ");
        BigDecimal discount = new BigDecimal(scanner.nextLine());
        System.out.println("Enter product description: ");
        String description = scanner.nextLine();
        System.out.println("Enter product category: ");
        String category = scanner.nextLine();
        ProductEntity productEntity = new ProductEntity();
        productEntity.setName(name);
        productEntity.setPrice(price);
        productEntity.setDiscount(discount);
        productEntity.setDescription(description);
        productEntity.setCategory(category);
        service.update(productEntity);
    }

    @Override
    public String toString() {
        return "Edit product";
    }
}
