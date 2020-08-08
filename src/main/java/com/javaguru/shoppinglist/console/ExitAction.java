package com.javaguru.shoppinglist.console;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Component
@Order(8)
public class ExitAction implements MenuAction {

    @Override
    public void execute() {
        System.out.println("Goodbye");
        System.exit(0);
    }

    @Override
    public String toString() {
        return "Exit";
    }
}
