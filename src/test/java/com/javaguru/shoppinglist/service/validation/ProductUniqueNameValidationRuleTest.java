package com.javaguru.shoppinglist.service.validation;
import com.javaguru.shoppinglist.domain.ProductEntity;
import com.javaguru.shoppinglist.dto.ProductDto;
import com.javaguru.shoppinglist.repository.ProductInMemoryRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Spy;
import org.mockito.junit.MockitoJUnitRunner;
import java.math.BigDecimal;
import java.util.Optional;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class ProductUniqueNameValidationRuleTest {

    @Mock
    private ProductInMemoryRepository inMemoryRepository;

    @Spy
    @InjectMocks
    private ProductUniqueNameValidationRule victim;

    @Test
    public void shouldThrowExceptionProductNameMustBeUnique() {
        ProductEntity entity = new ProductEntity(1L, "Banana",new BigDecimal(1.69),"Tasty banana",10, "FRUIT");
        when(inMemoryRepository.FindProductByName("Banana")).thenReturn(Optional.of(entity));
        ProductDto input = new ProductDto();
        input.setName("Banana");
        assertThatThrownBy(() -> victim.validate(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ValidationExceptionMessages.UNIQUE_NAME_VALIDATION_MSG);
        verify(victim).checkNotNull(input);
    }
    
}