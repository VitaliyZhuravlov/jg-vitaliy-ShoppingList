package com.javaguru.shoppinglist.service.validation;
import com.javaguru.shoppinglist.dto.ProductDto;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Spy;
import org.mockito.junit.MockitoJUnitRunner;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.mockito.Mockito.verify;

@RunWith(MockitoJUnitRunner.class)
public class ProductNameValidationRuleTest {
    @Spy
    @InjectMocks
    private ProductNameValidationRule victim;

    @Test
    public void shouldThrowExceptionWhenNameTooShort() {
        ProductDto input = new ProductDto();
        input.setName("Ki");
        assertThatThrownBy(() -> victim.validate(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ValidationExceptionMessages.SHORT_NAME_VALIDATION_MSG);
        verify(victim).checkNotNull(input);
    }

    @Test
    public void shouldThrowExceptionWhenNameTooLong() {
        ProductDto input = new ProductDto();
        input.setName("Potato Tomato Banana Lemon Apple");
        assertThatThrownBy(() -> victim.validate(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ValidationExceptionMessages.LONG_NAME_VALIDATION_MSG);
        verify(victim).checkNotNull(input);
    }
}