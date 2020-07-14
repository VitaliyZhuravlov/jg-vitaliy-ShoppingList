package com.javaguru.shoppinglist.service.validation;

public class ValidationExceptionMessages {
    private ValidationExceptionMessages() {
    }
    public static final String UNIQUE_NAME_VALIDATION_MSG = "Product name should be unique.";
    public static final String SHORT_NAME_VALIDATION_MSG = "Name is too short";
    public static final String LONG_NAME_VALIDATION_MSG = "Name is too long";
    public static final String PRICE_VALIDATION_MSG = "Please enter a positive price!";
    public static final String DESCRIPTION_VALIDATION_MSG = "Product description is to short.";
    public static final String DISCOUNT_VALIDATION_MSG = "Product discount can not be more than 100%";
    public static final String NEGATIVE_DISCOUNT_VALIDATION_MSG = "Please enter positive discount!";
}
