package com.javaguru.shoppinglist.service.validation;
import com.javaguru.shoppinglist.dto.ProductDto;
import com.javaguru.shoppinglist.repository.ProductRepository;
import org.springframework.stereotype.Component;

@Component
public class ProductUniqueNameValidationRule implements ProductValidationRule {

    private final ProductRepository repository;

    public ProductUniqueNameValidationRule(ProductRepository repository) {
        this.repository = repository;
    }

    @Override
    public void validate(ProductDto productDto) {
        checkNotNull(productDto);
        if (repository.findProductByName(productDto.getName()).isPresent()) {
            throw new IllegalArgumentException(ValidationExceptionMessages.UNIQUE_NAME_VALIDATION_MSG);
        }
    }
}
