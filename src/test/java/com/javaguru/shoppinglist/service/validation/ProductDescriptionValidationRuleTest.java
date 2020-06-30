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
public class ProductDescriptionValidationRuleTest {

    @Spy
    @InjectMocks
    private ProductDescriptionValidationRule victim;

    @Test
    public void shouldThrowExceptionWhenDescriptionToShort() {
        ProductDto input = new ProductDto();
        input.setDescription("Banani no");
        assertThatThrownBy(() -> victim.validate(input))
                .isInstanceOf(ProductValidationException.class)
                .hasMessage(ValidationExceptionMessages.DESCRIPTION_VALIDATION_MSG);
        verify(victim).checkNotNull(input);
    }
}