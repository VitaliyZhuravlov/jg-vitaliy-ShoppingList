package com.javaguru.shoppinglist.mappers;

import com.javaguru.shoppinglist.domain.UserEntity;
import com.javaguru.shoppinglist.dto.UserDto;
import org.springframework.stereotype.Component;

@Component
public class UserMapper {

    public UserDto toDto(UserEntity entity) {
        UserDto dto = new UserDto();
        dto.setId(entity.getId());
        dto.setUsername(entity.getUsername());
        return dto;
    }

    public UserEntity toEntity(UserDto dto) {
        return new UserEntity(
                dto.getId(),
               dto.getUsername());
    }
}
