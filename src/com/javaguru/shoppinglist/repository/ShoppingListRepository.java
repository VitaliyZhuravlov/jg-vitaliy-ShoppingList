package com.javaguru.shoppinglist.repository;

import com.javaguru.shoppinglist.domain.Product;

public interface ShoppingListRepository {

    Product save (Product product);

    Product findProductById(Long id);

    Product deleteProduct(Long id);

}
