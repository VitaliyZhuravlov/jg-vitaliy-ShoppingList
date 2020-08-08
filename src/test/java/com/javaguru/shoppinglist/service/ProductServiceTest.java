package com.javaguru.shoppinglist.service;
import com.javaguru.shoppinglist.domain.ProductEntity;
import com.javaguru.shoppinglist.dto.ProductDto;
import com.javaguru.shoppinglist.mappers.BeanMapper;
import com.javaguru.shoppinglist.repository.HibernateProductRepository;
import com.javaguru.shoppinglist.service.validation.ProductValidationService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import java.math.BigDecimal;
import static org.junit.Assert.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

    @RunWith(MockitoJUnitRunner.class)
        public class ProductServiceTest {

        @Mock
        private HibernateProductRepository repository;
        @Mock
        private ProductValidationService validationService;
        @Mock
        private BeanMapper beanMapper;
        @InjectMocks
        private ProductService victim;

        @Test
        public void shouldSaveProduct() {
            when(repository.save(any())).thenReturn(entity());
            when(beanMapper.toDto(entity())).thenReturn(productDto(20L));
            ProductDto dto = victim.save(productDto(null));
            verify(validationService).validate(any());
            assertEquals(productDto(20L), dto);
        }

        private ProductDto productDto(Long id) {
            ProductDto dto = new ProductDto();
            dto.setId(id);
            dto.setName("Banani");
            dto.setPrice(new BigDecimal(1.69));
            dto.setDiscount(new BigDecimal(10));
            dto.setDescription("Banani kg");
            dto.setCategory("FRUIT");
            return dto;
        }

        private ProductEntity entity() {
            ProductEntity productEntity = new ProductEntity(1L,"Banani",new BigDecimal(1.69),new BigDecimal(10),"Banani kg","FRUIT");
            return productEntity;
        }
    }
