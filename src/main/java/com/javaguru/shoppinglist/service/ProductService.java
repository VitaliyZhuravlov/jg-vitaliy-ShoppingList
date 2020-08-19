package com.javaguru.shoppinglist.service;
import com.javaguru.shoppinglist.dto.ProductDto;
import com.javaguru.shoppinglist.mappers.ProductMapper;
import com.javaguru.shoppinglist.repository.ProductRepository;
import com.javaguru.shoppinglist.exceptions.ProductNotFoundException;
import org.springframework.stereotype.Service;
import java.util.ArrayList;

@Service
public class ProductService {

    private final ProductRepository repository;
    private final ProductMapper beanMapper;

    public ProductService(ProductRepository repository,
                          ProductMapper beanMapper) {
        this.repository = repository;
        this.beanMapper = beanMapper;
    }

    public ProductDto save(ProductDto productDto) {
        return beanMapper.toDto(repository.save(beanMapper.toEntity(productDto)));
    }

    public ProductDto findProductById(Long id)  {
        return beanMapper.toDto(repository.findById(id)
                .orElseThrow(() -> new ProductNotFoundException("Product not found, id: " + id)));
    }

    public void delete(Long id){
        repository.deleteById(id);
    }

    public void update(ProductDto productDto) {
        beanMapper.toDto(repository.save(beanMapper.toEntity(productDto)));
    }

    public ProductDto findProductByName(String name) {
        return beanMapper.toDto(repository.findByName(name)
                .orElseThrow(() -> new ProductNotFoundException("Product not found, name: " + name)));
    }

    public ArrayList<ProductDto> findAll() {
        ArrayList<ProductDto> dtoList = new ArrayList<>();
        repository.findAll().forEach(productEntity -> dtoList.add(beanMapper.toDto(productEntity)));
        return dtoList;
    }
}
