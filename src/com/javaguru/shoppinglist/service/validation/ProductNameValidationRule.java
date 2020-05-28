package com.javaguru.shoppinglist.service.validation;

import com.javaguru.shoppinglist.domain.Product;

public class ProductNameValidationRule implements ProductValidationRule {
    @Override
    public void validate(Product product) {
        if(product.getName().length() <= 32 && product.getName().length() < 3){
            throw new ProductValidationException("Name must be between 3 and 32 characters");
            }

        if(product.getName() == null || product.getName().isEmpty()){
            throw new ProductValidationException("Task must be not null");
        }

        }
    }
