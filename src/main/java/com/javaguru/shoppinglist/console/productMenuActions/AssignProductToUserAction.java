package com.javaguru.shoppinglist.console.productMenuActions;

import com.javaguru.shoppinglist.console.MenuAction;
import com.javaguru.shoppinglist.service.UserProductService;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.util.Scanner;

@Component
@Order(9)
public class AssignProductToUserAction implements MenuAction {

    private final UserProductService service;

    public AssignProductToUserAction(UserProductService service) {
        this.service = service;
    }

    @Override
    public void execute() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Please enter product id: ");
        Long productId = scanner.nextLong();
        System.out.println("Please enter user id: ");
        Long userId = scanner.nextLong();
        service.assignProductToUser(productId, userId);
    }

    @Override
    public String toString() {
        return "Assign product to user";
    }
}
