package com.javaguru.shoppinglist.service;

import com.javaguru.shoppinglist.domain.ProductEntity;
import com.javaguru.shoppinglist.dto.ProductDto;
import com.javaguru.shoppinglist.mappers.ProductMapper;
import com.javaguru.shoppinglist.repository.ProductRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import static org.mockito.ArgumentMatchers.any;
import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

@RunWith(MockitoJUnitRunner.class)
public class ProductServiceTest {

    @Mock
    private ProductRepository repository;
    @Mock
    private ProductMapper beanMapper;
    @InjectMocks
    private ProductService victim;

    @Test
    public void shouldFindAllProducts(){
        ProductEntity product = new ProductEntity();
        product.setId(25L);
        product.setName("Cherry");
        product.setPrice(new BigDecimal(0.99));
        product.setDiscount(new BigDecimal(0));
        product.setDescription("Cherry cherry cherry");
        product.setCategory("FRUIT");

        ProductEntity product2 = new ProductEntity();
        product.setId(20L);
        product.setName("Banana");
        product.setPrice(new BigDecimal(0.79));
        product.setDiscount(new BigDecimal(0));
        product.setDescription("Banana kg");
        product.setCategory("FRUIT");

        List<ProductEntity> productEntity = new ArrayList<>();
        productEntity.add(product);
        productEntity.add(product2);

        when(repository.findAll()).thenReturn(productEntity);
        assertEquals(victim.findAll(),productEntity);
    }

    @Test
    public void shouldSaveProduct() {
        when(repository.save(any())).thenReturn(entity());
        when(beanMapper.toDto(entity())).thenReturn(productDto(20L));
        ProductDto dto = victim.save(productDto(null));
        assertEquals(productDto(20L), dto);
    }

    @Test
    public void shouldDeleteProduct(){
        final Long productId=1L;
        victim.delete(productId);
        victim.delete(productId);
        verify(repository,times(2)).deleteById(productId);
    }

    private ProductDto productDto(Long id) {
        ProductDto dto = new ProductDto();
        dto.setId(id);
        dto.setName("Banana");
        dto.setPrice(new BigDecimal(0.79));
        dto.setDiscount(new BigDecimal(10));
        dto.setDescription("Banana kg");
        dto.setCategory("FRUIT");
        return dto;
    }

    private ProductEntity entity() {
        ProductEntity product = new ProductEntity();
        product.setId(20L);
        product.setName("Banana");
        product.setPrice(new BigDecimal(0.79));
        product.setDiscount(new BigDecimal(10));
        product.setDescription("Banana kg");
        product.setCategory("FRUIT");
        return product;
    }
}