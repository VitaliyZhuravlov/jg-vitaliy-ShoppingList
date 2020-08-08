package com.javaguru.shoppinglist.service.validation;
import com.javaguru.shoppinglist.dto.ProductDto;
import com.javaguru.shoppinglist.repository.ShoppingListRepository;
import org.springframework.stereotype.Component;

@Component
public class ProductNameValidationRule implements ProductValidationRule {

    private final ShoppingListRepository repository;

    public ProductNameValidationRule(ShoppingListRepository repository) {
        this.repository = repository;
    }

    @Override
    public void validate(ProductDto productDto) {
        checkNotNull(productDto);
        if (productDto.getName().length() < 3) {
            throw new IllegalArgumentException(ValidationExceptionMessages.SHORT_NAME_VALIDATION_MSG);
        }
        if (productDto.getName().length() >= 32) {
            throw new IllegalArgumentException(ValidationExceptionMessages.LONG_NAME_VALIDATION_MSG);
        }
        }
    }
