package com.javaguru.shoppinglist.service;
import com.javaguru.shoppinglist.domain.ProductEntity;
import com.javaguru.shoppinglist.dto.ProductDto;
import com.javaguru.shoppinglist.mappers.BeanMapper;
import com.javaguru.shoppinglist.repository.ShoppingListRepository;
import com.javaguru.shoppinglist.service.validation.ProductNotFoundException;
import com.javaguru.shoppinglist.service.validation.ProductValidationService;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ProductService {

    private final  ShoppingListRepository shoppingListRepository;
    private final ProductValidationService validationService;
    private final BeanMapper beanMapper;

    public ProductService(ShoppingListRepository shoppingListRepository, ProductValidationService validationService, BeanMapper beanMapper) {
        this.shoppingListRepository = shoppingListRepository;
        this.validationService = validationService;
        this.beanMapper = beanMapper;
    }

    public ProductDto save(ProductDto productDto) {
        validationService.validate(productDto);
        ProductEntity entity = beanMapper.toEntity(productDto);
        ProductEntity savedEntity = shoppingListRepository.save(entity);
        return beanMapper.toDto(savedEntity);
    }

     public ProductEntity findProductById(Long id)  {
        ProductEntity productEntity =  shoppingListRepository.findProductById(id);
        if(productEntity == null) { throw new ProductNotFoundException("Product not found " + id); }
        return productEntity;
    }

    public Optional<ProductEntity> FindProductByName(String name)  {
        Optional<ProductEntity> productEntity =  shoppingListRepository.FindProductByName(name);
        if(productEntity == null) { throw new ProductNotFoundException("Product not found " + name); }
        return productEntity;
    }



    public void deleteProduct(Long id){
        shoppingListRepository.deleteProduct(id);
    }
}