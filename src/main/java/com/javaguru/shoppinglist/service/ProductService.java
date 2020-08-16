package com.javaguru.shoppinglist.service;

import com.javaguru.shoppinglist.domain.ProductEntity;
import com.javaguru.shoppinglist.dto.ProductDto;
import com.javaguru.shoppinglist.mappers.BeanMapper;
import com.javaguru.shoppinglist.repository.ProductRepository;
import com.javaguru.shoppinglist.exceptions.ProductNotFoundException;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class ProductService {

    private final ProductRepository repository;
    private final BeanMapper beanMapper;

    public ProductService(ProductRepository repository,
                          BeanMapper beanMapper) {
        this.repository = repository;
        this.beanMapper = beanMapper;
    }

    public ProductDto save(ProductDto productDto) {
        ProductEntity entity = beanMapper.toEntity(productDto);
        ProductEntity savedEntity = repository.save(entity);
        return beanMapper.toDto(savedEntity);
    }

    public ProductEntity findProductById(Long id)  {
        return repository.findById(id)
                .orElseThrow(() -> new ProductNotFoundException("Product not found, id: " + id));
    }

    public void delete(Long id){
        repository.deleteById(id);
    }

    public void update(ProductDto productDto) {
        ProductEntity entity = beanMapper.toEntity(productDto);
        ProductEntity savedEntity = repository.save(entity);
        beanMapper.toDto(savedEntity);
    }

    public ProductEntity findProductByName(String name) {
        return repository.findByName(name)
                .orElseThrow(() -> new ProductNotFoundException("Product not found, name: " + name));
    }

    public List<ProductEntity> findAll() {
        return repository.findAll();
    }
}
