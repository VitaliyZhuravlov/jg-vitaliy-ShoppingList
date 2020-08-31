package com.javaguru.shoppinglist.dto;

public class OrderRequest {

    private UserDto dto;

    public OrderRequest() {
    }

    public UserDto getDto() {
        return dto;
    }

    public void setDto(UserDto dto) {
        this.dto = dto;
    }

    @Override
    public String toString() {
        return "OrderRequest{" +
                "dto=" + dto +
                '}';
    }
}
