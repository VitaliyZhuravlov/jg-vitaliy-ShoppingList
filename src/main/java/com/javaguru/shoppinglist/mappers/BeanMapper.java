package com.javaguru.shoppinglist.mappers;
import com.javaguru.shoppinglist.domain.ProductEntity;
import com.javaguru.shoppinglist.dto.ProductDto;
import org.springframework.stereotype.Component;

@Component
public class BeanMapper {

    public ProductDto toDto(ProductEntity entity) {
        ProductDto dto = new ProductDto();
        dto.setId(entity.getId());
        dto.setName(entity.getName());
        dto.setPrice(entity.getPrice());
        dto.setDescription(entity.getDescription());
        dto.setDiscount(entity.getDiscount());
        dto.setCategory(entity.getCategory());
        return dto;
    }

    public ProductEntity toEntity(ProductDto dto) {
        return new ProductEntity(dto.getId(), dto.getName(), dto.getPrice(),dto.getDescription(),dto.getDiscount(),dto.getCategory());
    }
}
