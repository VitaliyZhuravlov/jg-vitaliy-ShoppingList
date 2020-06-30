package com.javaguru.shoppinglist.service.validation;

import com.javaguru.shoppinglist.dto.ProductDto;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Spy;
import org.mockito.junit.MockitoJUnitRunner;

import java.math.BigDecimal;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.Assert.*;
import static org.mockito.Mockito.verify;

@RunWith(MockitoJUnitRunner.class)
public class ProductPriceValidationRuleTest {
    @InjectMocks
    private ProductPriceValidationRule victim;

    @Test
    public void shouldThrowExceptionWhenPriceIsNegative() {
        ProductDto input = new ProductDto();
        input.setPrice(new BigDecimal(-1));
        assertThatThrownBy(() -> victim.validate(input))
                .isInstanceOf(NumberFormatException.class)
                .hasMessage(ValidationExceptionMessages.PRICE_VALIDATION_MSG);
    }
}