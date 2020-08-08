package com.javaguru.shoppinglist.service.validation;
import com.javaguru.shoppinglist.dto.ProductDto;
import org.springframework.stereotype.Component;

@Component
public class ProductDescriptionValidationRule implements ProductValidationRule {

    @Override
    public void validate(ProductDto productDto) {
        if (productDto.getDescription().length() < 10) {
            throw new ProductValidationException(ValidationExceptionMessages.DESCRIPTION_VALIDATION_MSG);
            }
    }
}
