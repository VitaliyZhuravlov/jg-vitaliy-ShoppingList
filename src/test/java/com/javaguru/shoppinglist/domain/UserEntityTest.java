package com.javaguru.shoppinglist.domain;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;
import java.util.Set;
import static org.junit.Assert.*;

public class UserEntityTest {

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
    public void shouldDetectInvalidUsername() {
        UserEntity userEntity = new UserEntity(2L,"a");
        Set<ConstraintViolation<UserEntity>> violations = validator.validate(userEntity);
        assertEquals(violations.size(), 1);

        ConstraintViolation<UserEntity> violation = violations.iterator().next();
        assertEquals("username", violation.getPropertyPath().toString());
        assertEquals("a", violation.getInvalidValue());
    }

    @Test
    public void shouldDetectEmpty() {
        UserEntity userEntity = new UserEntity();
        Set<ConstraintViolation<UserEntity>> violations = validator.validate(userEntity);
        assertFalse(violations.isEmpty());
    }
}