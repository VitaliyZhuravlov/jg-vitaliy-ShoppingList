package com.javaguru.shoppinglist;
import com.javaguru.shoppinglist.console.ConsoleUI;
import com.javaguru.shoppinglist.mappers.BeanMapper;
import com.javaguru.shoppinglist.repository.ProductInMemoryRepository;
import com.javaguru.shoppinglist.service.ProductService;
import com.javaguru.shoppinglist.service.validation.*;
import java.util.HashSet;
import java.util.Set;

class ShoppingListApplication {
    public static void main(String[] args) {
        ProductInMemoryRepository repository = new ProductInMemoryRepository();
        Set<ProductValidationRule> rules = new HashSet<>();
        rules.add(new ProductNameValidationRule(repository));
        rules.add(new ProductDescriptionValidationRule());
        rules.add(new ProductPriceValidationRule());
        rules.add(new ProductDiscountValidationRule());
        rules.add(new ProductCategoryValidationRule());
        rules.add(new ProductUniqueNameValidationRule(repository));
        ProductValidationService validationService = new ProductValidationService(rules);
        BeanMapper beanMapper = new BeanMapper();
        ProductService service = new ProductService(repository, validationService, beanMapper);
        ConsoleUI ui = new ConsoleUI(service);
        ui.start();
    }
}
