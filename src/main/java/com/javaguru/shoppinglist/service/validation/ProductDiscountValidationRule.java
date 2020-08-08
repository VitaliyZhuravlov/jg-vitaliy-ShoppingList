package com.javaguru.shoppinglist.service.validation;
import com.javaguru.shoppinglist.dto.ProductDto;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;

@Component
public class ProductDiscountValidationRule implements ProductValidationRule {
    @Override
    public void validate(ProductDto productDto) {
        if (productDto.getDiscount().compareTo(BigDecimal.ZERO) > 100) {
            throw new NumberFormatException(ValidationExceptionMessages.DISCOUNT_VALIDATION_MSG);
    }
        if (productDto.getDiscount().compareTo(BigDecimal.ZERO) < 0){
            throw new NumberFormatException(ValidationExceptionMessages.NEGATIVE_DISCOUNT_VALIDATION_MSG);
        }

}
}
