package com.javaguru.shoppinglist.mappers;

import com.javaguru.shoppinglist.domain.ProductEntity;
import com.javaguru.shoppinglist.dto.ProductDto;
import org.springframework.stereotype.Component;
import java.math.BigDecimal;
import java.math.MathContext;

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

        if (dto.getDiscount().compareTo(BigDecimal.ZERO) > 0) {
            dto.setActualPrice(toActualPrice(entity.getPrice(), entity.getDiscount()));
        } else {
            dto.setActualPrice(dto.getPrice());
        }

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

    private BigDecimal toActualPrice(BigDecimal price, BigDecimal discount) {
        MathContext m = new MathContext(2);
        return price.subtract(price.multiply(discount).divide(BigDecimal.valueOf(100)).round(m));
    }
}
