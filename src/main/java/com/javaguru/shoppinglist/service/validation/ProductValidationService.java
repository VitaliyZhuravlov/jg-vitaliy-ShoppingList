package com.javaguru.shoppinglist.service.validation;
import com.javaguru.shoppinglist.dto.ProductDto;
import java.util.Set;

public class ProductValidationService {

    private final Set<ProductValidationRule> validationRules;

    public ProductValidationService(Set<ProductValidationRule> validationRules) {
        this.validationRules = validationRules;
    }
    public void validate(ProductDto productDto) {
        for (ProductValidationRule rule : validationRules) {
            rule.validate(productDto);
        }
    }
}
