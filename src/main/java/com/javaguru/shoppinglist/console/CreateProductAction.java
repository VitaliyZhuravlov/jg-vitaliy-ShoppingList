package com.javaguru.shoppinglist.console;

import com.javaguru.shoppinglist.dto.ProductDto;
import com.javaguru.shoppinglist.service.ProductService;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;
import java.math.BigDecimal;
import java.util.Scanner;

@Component
@Order(0)
public class CreateProductAction implements MenuAction {
    private final ProductService service;

    public CreateProductAction(ProductService service) {
        this.service = service;
    }

    @Override
    public void execute(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter product name: ");
        String name = scanner.nextLine();
        System.out.println("Enter product price: ");
        BigDecimal price = new BigDecimal(scanner.nextLine());
        System.out.println("Enter product discount: ");
        double discount = Double.parseDouble(scanner.nextLine());
        System.out.println("Enter product description: ");
        String description = scanner.nextLine();
        System.out.println("Enter product category: ");
        String category = scanner.nextLine();
        ProductDto dto = new ProductDto();
        dto.setName(name);
        dto.setDiscount(discount);
        dto.setCategory(category);
        dto.setDescription(description);
        dto.setPrice(price);
        ProductDto productDto = service.save(dto);
        System.out.println("Product successfully created: " + productDto);
    }

    @Override
    public String toString() {
        return "Create product";
    }

}
