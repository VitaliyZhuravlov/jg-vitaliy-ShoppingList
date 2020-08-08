package com.javaguru.shoppinglist.repository;
import com.javaguru.shoppinglist.domain.ProductEntity;

import java.util.List;
import java.util.Optional;

public interface ShoppingListRepository {

    ProductEntity save (ProductEntity productEntity);

    ProductEntity findProductById(Long id);

    void deleteProduct(Long id);

    Optional<ProductEntity> findProductByName(String name);

    void update (ProductEntity productEntity);

    List<ProductEntity> findAll();

}
