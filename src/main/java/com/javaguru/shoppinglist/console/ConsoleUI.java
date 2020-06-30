package com.javaguru.shoppinglist.console;

import com.javaguru.shoppinglist.domain.ProductEntity;
import com.javaguru.shoppinglist.dto.ProductDto;
import com.javaguru.shoppinglist.service.ProductService;
import com.javaguru.shoppinglist.service.validation.ProductNotFoundException;
import com.javaguru.shoppinglist.service.validation.ProductValidationException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.util.Scanner;
@Component
public class ConsoleUI {
    private final ProductService service;

    @Autowired
    public ConsoleUI(ProductService service) {
        this.service = service;
    }

    public void start(){
        while (true) {
            Scanner scanner = new Scanner(System.in);
            try {
                System.out.println("1. Create product");
                System.out.println("2. Find product by id");
                System.out.println("3. Delete by id");
                System.out.println("4. Exit");
                Integer userInput = Integer.valueOf(scanner.nextLine());
                switch (userInput) {
                    case 1:
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
                        System.out.println("Task successfully created: " + productDto);
                        break;
                    case 2:
                        System.out.println("");
                        System.out.println("Find by ID ");
                        System.out.println("Enter product id: ");
                        Long id = Long.valueOf(scanner.nextLine());
                        ProductEntity productEntity1 = service.findProductById(id);
                        System.out.println("Product founded" + productEntity1);
                        break;
                    case 3:
                        System.out.println("");
                        System.out.println("Delete by ID ");
                        System.out.print("Enter ID number:");
                        id = scanner.nextLong();
                        service.deleteProduct(id);
                        System.out.println("Product " + id + " deleted");
                        break;
                    case 4:
                        return;
                }
            } catch (ProductValidationException e) {
                System.out.println("Product validation failed. Error message " + e.getMessage());
            } catch (ProductNotFoundException e) {
                System.out.println(e.getMessage());
            } catch (Exception e) {
                System.out.println("Error! Please try again.");
            }
        }
    }
}
