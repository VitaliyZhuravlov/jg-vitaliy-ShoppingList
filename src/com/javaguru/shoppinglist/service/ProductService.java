package com.javaguru.shoppinglist.service;

import com.javaguru.shoppinglist.domain.Product;
import com.javaguru.shoppinglist.repository.ProductInMemoryRepository;
import com.javaguru.shoppinglist.repository.ShoppingListRepository;
import com.javaguru.shoppinglist.service.validation.ProductNotFoundException;
import com.javaguru.shoppinglist.service.validation.ProductValidationService;

public class ProductService {

    private final ShoppingListRepository shoppingListRepository = new ProductInMemoryRepository();
    private final ProductValidationService validationService = new ProductValidationService();

    public Product save(Product product) {
        validationService.validate(product);
        Product createdProduct = shoppingListRepository.save(product);
        return createdProduct;

    }

     public Product findProductById(Long id)  {
        Product product =  shoppingListRepository.findProductById(id);
        if(product !=null){
            return product;
        } else {
            throw new ProductNotFoundException("Product not found " + id);
        }

    }

    public Product deleteProduct(Long id){
        Product deleted = shoppingListRepository.deleteProduct(id);
        return deleted;
    }
}