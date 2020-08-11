package com.javaguru.shoppinglist.repository;
import com.javaguru.shoppinglist.domain.UserEntity;

import java.util.List;
import java.util.Optional;

public interface UserRepository {

    UserEntity save(UserEntity userEntity);

    Optional<UserEntity> findById(Long id);

    void update(UserEntity userEntity);

    List<UserEntity> findAll();
}
