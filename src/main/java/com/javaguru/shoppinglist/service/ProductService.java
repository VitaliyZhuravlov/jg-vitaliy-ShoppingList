package com.javaguru.shoppinglist.service;

import com.javaguru.shoppinglist.domain.ProductEntity;
import com.javaguru.shoppinglist.dto.ProductDto;
import com.javaguru.shoppinglist.mappers.BeanMapper;
import com.javaguru.shoppinglist.repository.ProductRepository;
import com.javaguru.shoppinglist.service.validation.ProductNotFoundException;
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

    public ProductEntity update(ProductEntity product) {
        ProductEntity existingProduct = repository.findById(product.getId())
                .orElseThrow(() -> new ProductNotFoundException("Product not found"));
        existingProduct.setName(product.getName());
        existingProduct.setPrice(product.getPrice());
        existingProduct.setDiscount(product.getDiscount());
        existingProduct.setDescription(product.getDescription());
        existingProduct.setCategory(product.getCategory());
        return repository.save(existingProduct);
    }

    public String delete(Long id){
        repository.deleteById(id);
        return "Successfully deleted " + id;
    }

    public ProductEntity findProductByName(String name) {
        return repository.findByName(name)
                .orElseThrow(() -> new ProductNotFoundException("Product not found, name: " + name));
    }

    public List<ProductEntity> findAll() {
        return repository.findAll();
    }
}
