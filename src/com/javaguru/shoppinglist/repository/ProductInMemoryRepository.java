package com.javaguru.shoppinglist.repository;

import com.javaguru.shoppinglist.domain.Product;

import java.util.*;


public class ProductInMemoryRepository implements ShoppingListRepository {


     private final Map<Long, Product> productRepository = new HashMap<>();
     private long productIdSequence = 0L;

    @Override
    public Product save(Product product) {
        Product ProductInsert = new Product(productIdSequence++,product.getName(),product.getPrice(),product.getDescription(),product.getDiscount(),product.getCategory());
        productRepository.put(ProductInsert.getId(), ProductInsert);
        return ProductInsert;
    }

    @Override
    public Product findProductById(Long id) {
        return productRepository.get(id);
    }

    @Override
    public Product deleteProduct(Long id) {
        productRepository.remove(productIdSequence);
        return null;
    }



}
