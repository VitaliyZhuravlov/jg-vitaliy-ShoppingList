package com.javaguru.shoppinglist.service.validation;

import com.javaguru.shoppinglist.domain.Product;

import java.util.HashSet;
import java.util.Set;

public class ProductValidationService {

    private final Set<ProductValidationRule> validationRules = new HashSet<>();

    public ProductValidationService() {
        validationRules.add(new ProductNameValidationRule());
        validationRules.add(new ProductDescriptionValidationRule());
        validationRules.add(new ProductDiscountValidationRule());
        validationRules.add(new ProductPriceValidationRule());
        validationRules.add(new ProductCategoryValidationRule());
    }


    public void validate(Product product) {
//        validationRules.forEach(rule -> rule.validate(task));
        for (ProductValidationRule rule : validationRules) {
            rule.validate(product);
        }

    }
}
