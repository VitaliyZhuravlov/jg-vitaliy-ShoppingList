package com.javaguru.shoppinglist.domain;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;
import java.math.BigDecimal;
import java.util.Set;
import static org.junit.Assert.*;

public class ProductEntityTest {

    private static ValidatorFactory validatorFactory;
    private static Validator validator;

    @BeforeClass
    public static void createValidator() {
        validatorFactory = Validation.buildDefaultValidatorFactory();
        validator = validatorFactory.getValidator();
    }

    @AfterClass
    public static void close() {
        validatorFactory.close();
    }

    @Test
    public void shouldDetectNotEmpty() {
        ProductEntity product = new ProductEntity();
        product.setId(20L);
        product.setName("Banana");
        product.setPrice(new BigDecimal(0.79));
        product.setDiscount(new BigDecimal(10));
        product.setDescription("Banana kg");
        product.setCategory("FRUIT");
        Set<ConstraintViolation<ProductEntity>> violations = validator.validate(product);
        assertTrue(violations.isEmpty());
    }

}