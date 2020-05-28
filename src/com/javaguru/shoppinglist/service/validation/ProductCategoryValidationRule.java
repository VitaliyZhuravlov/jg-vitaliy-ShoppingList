package com.javaguru.shoppinglist.service.validation;

import com.javaguru.shoppinglist.domain.Category;
import com.javaguru.shoppinglist.domain.Product;

public class ProductCategoryValidationRule implements ProductValidationRule {
    @Override
    public void validate(Product product) {

        Category f = Category.valueOf(product.getCategory());
        if(f !=null){
            System.out.println(f);
        }


    }
}
