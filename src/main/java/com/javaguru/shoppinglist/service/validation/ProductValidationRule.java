package com.javaguru.shoppinglist.service.validation;
import com.javaguru.shoppinglist.domain.ProductEntity;
import com.javaguru.shoppinglist.dto.ProductDto;

public interface ProductValidationRule {

    void validate(ProductDto productdto);

    default void checkNotNull(ProductDto productdto){
        if(productdto == null){
            throw new IllegalArgumentException("Product must be not null");
        }
    }
}
