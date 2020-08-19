package com.javaguru.shoppinglist.mappers;

import com.javaguru.shoppinglist.domain.ProductEntity;
import com.javaguru.shoppinglist.dto.ProductDto;
import org.springframework.stereotype.Component;

@Component
public class ProductMapper {

    public ProductDto toDto(ProductEntity entity) {
        ProductDto dto = new ProductDto();
        dto.setId(entity.getId());
        dto.setName(entity.getName());
        dto.setPrice(entity.getPrice());
        dto.setDiscount(entity.getDiscount());
        dto.setDescription(entity.getDescription());
        dto.setCategory(entity.getCategory());
        return dto;
    }

    public ProductEntity toEntity(ProductDto dto) {
        return new ProductEntity(
                dto.getId(),
                dto.getName(),
                dto.getPrice(),
                dto.getDiscount(),
                dto.getDescription(),
                dto.getCategory());
    }
}
