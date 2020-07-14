package com.javaguru.shoppinglist.service.validation;

import com.javaguru.shoppinglist.dto.ProductDto;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Spy;
import org.mockito.junit.MockitoJUnitRunner;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.Assert.*;
import static org.mockito.Mockito.verify;

@RunWith(MockitoJUnitRunner.class)
public class ProductDiscountValidationRuleTest {
    @InjectMocks
    private ProductDiscountValidationRule victim;

    @Test
    public void shouldThrowExceptionWhenExceedsDiscountLimit() {
        ProductDto input = new ProductDto();
        input.setDiscount(101);
        assertThatThrownBy(() -> victim.validate(input))
                .isInstanceOf(NumberFormatException.class)
                .hasMessage(ValidationExceptionMessages.DISCOUNT_VALIDATION_MSG);
    }

    @Test
    public void shouldThrowExceptionWhenDiscountIsNegative() {
        ProductDto input = new ProductDto();
        input.setDiscount(-1);
        assertThatThrownBy(() -> victim.validate(input))
                .isInstanceOf(NumberFormatException.class)
                .hasMessage(ValidationExceptionMessages.NEGATIVE_DISCOUNT_VALIDATION_MSG);
    }
}