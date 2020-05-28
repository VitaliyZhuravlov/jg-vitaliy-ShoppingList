package com.javaguru.shoppinglist.console;

import com.javaguru.shoppinglist.domain.Product;
import com.javaguru.shoppinglist.service.ProductService;
import com.javaguru.shoppinglist.service.validation.ProductNotFoundException;
import com.javaguru.shoppinglist.service.validation.ProductValidationException;
import java.math.BigDecimal;
import java.util.Scanner;

public class ConsoleUI {

    ProductService service = new ProductService();

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

                        Product product = new Product(name,price,description,discount,category);
                        Product createdProduct = service.save(product);
                        System.out.println("Task successfully created: " + createdProduct);
                        break;
                    case 2:
                        System.out.println("");
                        System.out.println("Find by ID ");
                        System.out.println("Enter product id: ");
                        Long id = Long.valueOf(scanner.nextLine());
                        Product product1 = service.findProductById(id);
                        System.out.println("Product founded" + product1);
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
