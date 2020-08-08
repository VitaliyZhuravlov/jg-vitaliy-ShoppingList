package com.javaguru.shoppinglist.console.userMenuActions;

import com.javaguru.shoppinglist.console.MenuAction;
import com.javaguru.shoppinglist.domain.UserEntity;
import com.javaguru.shoppinglist.service.UserService;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;
import java.util.Optional;
import java.util.Scanner;

@Component
@Order(6)
public class FindUserByIdAction implements MenuAction {

    private final UserService userService;

    public FindUserByIdAction(UserService userService) {
        this.userService = userService;
    }


    @Override
    public void execute() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter user id: ");
        Long id = Long.valueOf(scanner.nextLine());
        UserEntity userEntity = userService.findUserById(id);
        System.out.println(userEntity);
    }

    @Override
    public String toString() {
        return "Find user";
    }
}
