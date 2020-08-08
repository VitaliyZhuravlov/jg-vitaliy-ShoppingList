package com.javaguru.shoppinglist.console.userMenuActions;
import com.javaguru.shoppinglist.console.MenuAction;
import com.javaguru.shoppinglist.domain.UserEntity;
import com.javaguru.shoppinglist.service.UserService;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;
import java.util.Scanner;

@Component
@Order(5)
public class CreateUserAction implements MenuAction {

    private final UserService userService;

    public CreateUserAction(UserService userService) {
        this.userService = userService;
    }

    @Override
    public void execute() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Please enter user name: ");
        String name = scanner.nextLine();
        UserEntity userEntity = new UserEntity();
        userEntity.setName(name);
        UserEntity createdUserEntity = userService.save(userEntity);
        System.out.println("Created user: " + createdUserEntity);
    }

    @Override
    public String toString() {
        return "Create user";
    }
}
