package com.javaguru.shoppinglist.service.validation;
import com.javaguru.shoppinglist.domain.Category;
import com.javaguru.shoppinglist.domain.ProductEntity;
import com.javaguru.shoppinglist.dto.ProductDto;

public class ProductCategoryValidationRule implements ProductValidationRule {
    @Override
    public void validate(ProductDto productDto) {
        checkNotNull(productDto);
        Category categoryValue = Category.valueOf(productDto.getCategory());
        if(categoryValue == null){ throw new IllegalArgumentException("No such category"); }
    }
}
