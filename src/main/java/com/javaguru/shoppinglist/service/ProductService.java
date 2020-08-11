package com.javaguru.shoppinglist.service;
import com.javaguru.shoppinglist.domain.ProductEntity;
import com.javaguru.shoppinglist.dto.ProductDto;
import com.javaguru.shoppinglist.mappers.BeanMapper;
import com.javaguru.shoppinglist.repository.ProductRepository;
import com.javaguru.shoppinglist.service.validation.ProductNotFoundException;
import com.javaguru.shoppinglist.service.validation.ProductValidationService;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class ProductService {

    private final ProductRepository productRepository;
    private final ProductValidationService validationService;
    private final BeanMapper beanMapper;

    public ProductService(ProductRepository productRepository,
                          ProductValidationService validationService,
                          BeanMapper beanMapper) {
        this.productRepository = productRepository;
        this.validationService = validationService;
        this.beanMapper = beanMapper;
    }

    public ProductDto save(ProductDto productDto) {
        validationService.validate(productDto);
        ProductEntity entity = beanMapper.toEntity(productDto);
        ProductEntity savedEntity = productRepository.save(entity);
        return beanMapper.toDto(savedEntity);
    }

     public ProductEntity findProductById(Long id)  {
        return productRepository.findProductById(id)
                .orElseThrow(() -> new ProductNotFoundException("Product not found, id: " + id));
    }

    public ProductEntity findProductByName(String name)  {
        return productRepository.findProductByName(name)
                .orElseThrow(() -> new ProductNotFoundException("Product not found, id: " + name));
    }

    public void deleteProduct(Long id){
        productRepository.deleteProduct(id);
    }

    public void update(ProductEntity productEntity) {
        productRepository.update(productEntity);
    }

    public List<ProductEntity> findAll() {
        return productRepository.findAll();
    }
}