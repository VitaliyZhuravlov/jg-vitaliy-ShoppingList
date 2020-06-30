package com.javaguru.shoppinglist.service.validation;
import com.javaguru.shoppinglist.dto.ProductDto;
import com.javaguru.shoppinglist.repository.ShoppingListRepository;

public class ProductUniqueNameValidationRule implements ProductValidationRule {

    private final ShoppingListRepository repository;

    public ProductUniqueNameValidationRule(ShoppingListRepository repository) {
        this.repository = repository;
    }
    @Override
    public void validate(ProductDto productdto) {
        checkNotNull(productdto);
        if (repository.FindProductByName(productdto.getName()).isPresent()) {
            throw new IllegalArgumentException(ValidationExceptionMessages.UNIQUE_NAME_VALIDATION_MSG);
        }
    }
}
