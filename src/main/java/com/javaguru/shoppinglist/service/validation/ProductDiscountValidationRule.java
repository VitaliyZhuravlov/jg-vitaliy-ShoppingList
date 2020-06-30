package com.javaguru.shoppinglist.service.validation;
import com.javaguru.shoppinglist.domain.ProductEntity;
import com.javaguru.shoppinglist.dto.ProductDto;

public class ProductDiscountValidationRule implements ProductValidationRule {
    @Override
    public void validate(ProductDto productDto) {
        if (productDto.getDiscount() > 100) {
            throw new NumberFormatException(ValidationExceptionMessages.DISCOUNT_VALIDATION_MSG);
    }
}
}
