package com.javaguru.shoppinglist.console;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import java.util.ArrayList;
import java.util.List;

public class ConsoleUIConfiguration {

    private final MenuAction createProductAction;
    private final MenuAction findProductByIdAction;
    private final MenuAction deleteProductByIdAction;
    private final MenuAction exitAction;

    @Autowired
    ConsoleUIConfiguration(MenuAction createProductAction,
                           MenuAction findProductByIdAction,
                           MenuAction deleteProductByIdAction,
                           MenuAction exitAction) {
        this.createProductAction = createProductAction;
        this.findProductByIdAction = findProductByIdAction;
        this.deleteProductByIdAction = deleteProductByIdAction;
        this.exitAction = exitAction;

    }

    @Bean
    public ConsoleUI ui() {
        List<MenuAction> menuActions = new ArrayList<>();
        menuActions.add(createProductAction);
        menuActions.add(findProductByIdAction);
        menuActions.add(deleteProductByIdAction);
        menuActions.add(exitAction);
        return new ConsoleUI(menuActions);
    }
}
