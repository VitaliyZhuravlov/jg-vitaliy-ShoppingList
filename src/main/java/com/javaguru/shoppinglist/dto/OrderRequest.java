package com.javaguru.shoppinglist.dto;

import com.javaguru.shoppinglist.domain.UserEntity;

public class OrderRequest {

    private UserEntity userEntity;

    public OrderRequest() {
    }

    public OrderRequest(UserEntity userEntity) {
        this.userEntity = userEntity;
    }

    public UserEntity getUserEntity() {
        return userEntity;
    }

    public void setUserEntity(UserEntity userEntity) {
        this.userEntity = userEntity;
    }

    @Override
    public String toString() {
        return "OrderRequest{" +
                "userEntity=" + userEntity +
                '}';
    }
}
