package com.javaguru.shoppinglist.repository;
import com.javaguru.shoppinglist.domain.ProductEntity;
import org.springframework.stereotype.Repository;
import java.util.*;
@Repository
public class ProductInMemoryRepository implements ShoppingListRepository {

     private final Map<Long, ProductEntity> productRepository = new HashMap<>();
     private long productIdSequence = 0L;

    @Override
    public ProductEntity save(ProductEntity productEntity) {
        ProductEntity productEntityInsert = new ProductEntity(productIdSequence++, productEntity.getName(), productEntity.getPrice(), productEntity.getDescription(), productEntity.getDiscount(), productEntity.getCategory());
        productRepository.put(productEntityInsert.getId(), productEntityInsert);
        return productEntityInsert;
    }

    @Override
    public ProductEntity findProductById(Long id) {
        return productRepository.get(id);
    }

    @Override
    public void deleteProduct(Long id) {
        productRepository.remove(productIdSequence);
    }

    @Override
    public  Optional<ProductEntity> FindProductByName(String name) {
        return productRepository.values().stream()
                .filter(entity -> entity.getName().equalsIgnoreCase(name))
                .findFirst();
    }
}
