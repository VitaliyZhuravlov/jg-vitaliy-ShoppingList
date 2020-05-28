package com.javaguru.shoppinglist.service.validation;

import com.javaguru.shoppinglist.domain.Product;

import java.util.InputMismatchException;

public class ProductDescriptionValidationRule implements ProductValidationRule {


    @Override
    public void validate(Product product) {
        if (product.getDescription() == null || product.getDescription().isEmpty() ) {
            throw new ProductValidationException("Description can not be empty");
            }
    }
}
