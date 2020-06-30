package com.javaguru.shoppinglist.service.validation;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Spy;
import org.mockito.junit.MockitoJUnitRunner;

import static org.junit.Assert.*;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

@RunWith(MockitoJUnitRunner.class)
public class ProductValidationRuleTest {
    @Spy
    private ProductValidationRule victim;

    @Test
    public void shouldThrowExceptionWhenProductIsNull() {
        assertThatThrownBy(() -> victim.checkNotNull(null))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("Product must be not null");
    }



}