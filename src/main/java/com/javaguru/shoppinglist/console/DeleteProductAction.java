package com.javaguru.shoppinglist.console;
import com.javaguru.shoppinglist.service.ProductService;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;
import java.util.Scanner;
@Component
@Order(3)
public class DeleteProductAction implements MenuAction{

    private final ProductService service;

    public DeleteProductAction(ProductService service) {
        this.service = service;
    }

    public void execute() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter product ID:");
        Long id = Long.valueOf(scanner.nextLine());
        id = scanner.nextLong();
        service.deleteProduct(id);
        System.out.println("Product " + id + " deleted");
    }

    @Override
    public String toString() {
        return "Delete product by id";
    }
}
