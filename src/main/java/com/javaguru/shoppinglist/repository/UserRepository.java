package com.javaguru.shoppinglist.repository;
import com.javaguru.shoppinglist.domain.UserEntity;

public interface UserRepository {

    UserEntity save(UserEntity userEntity);

    UserEntity findUserById(Long id);

    void update(UserEntity userEntity);
}
