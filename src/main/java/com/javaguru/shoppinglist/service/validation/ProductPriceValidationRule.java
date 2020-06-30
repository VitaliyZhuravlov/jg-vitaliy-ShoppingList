package com.javaguru.shoppinglist.service.validation;
import com.javaguru.shoppinglist.domain.ProductEntity;
import com.javaguru.shoppinglist.dto.ProductDto;
import java.math.BigDecimal;

public class ProductPriceValidationRule implements ProductValidationRule {
    @Override
    public void validate(ProductDto productDto) {
            if (productDto.getPrice().compareTo(BigDecimal.ZERO) < 0) {
                throw new NumberFormatException(ValidationExceptionMessages.PRICE_VALIDATION_MSG);
            }
    }
}
