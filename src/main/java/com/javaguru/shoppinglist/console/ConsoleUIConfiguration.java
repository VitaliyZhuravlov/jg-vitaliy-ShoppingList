package com.javaguru.shoppinglist.console;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import java.util.ArrayList;
import java.util.List;

public class ConsoleUIConfiguration {

    private final MenuAction createProductAction;
    private final MenuAction findProductByIdAction;
    private final MenuAction findProductByNameAction;
    private final MenuAction deleteProductAction;
    private final MenuAction exitAction;
    private final MenuAction updateProductAction;
    private final MenuAction createUserAction;
    private final MenuAction findUserByIdAction;

    @Autowired
    ConsoleUIConfiguration(MenuAction createProductAction,
                           MenuAction findProductByIdAction,
                           MenuAction findProductByNameAction,
                           MenuAction deleteProductAction,
                           MenuAction exitAction,
                           MenuAction updateProductAction,
                           MenuAction createUserAction,
                           MenuAction findUserByIdAction) {
        this.createProductAction = createProductAction;
        this.findProductByIdAction = findProductByIdAction;
        this.deleteProductAction = deleteProductAction;
        this.findProductByNameAction = findProductByNameAction;
        this.exitAction = exitAction;
        this.updateProductAction = updateProductAction;
        this.createUserAction = createUserAction;
        this.findUserByIdAction = findUserByIdAction;
    }

    @Bean
    public ConsoleUI ui() {
        List<MenuAction> menuActions = new ArrayList<>();
        menuActions.add(createProductAction);
        menuActions.add(findProductByIdAction);
        menuActions.add(findProductByNameAction);
        menuActions.add(deleteProductAction);
        menuActions.add(exitAction);
        menuActions.add(updateProductAction);
        menuActions.add(createUserAction);
        menuActions.add(findUserByIdAction);
        return new ConsoleUI(menuActions);
    }
}
