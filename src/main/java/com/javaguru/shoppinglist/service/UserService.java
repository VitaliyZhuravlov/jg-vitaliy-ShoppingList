package com.javaguru.shoppinglist.service;

import com.javaguru.shoppinglist.domain.UserEntity;
import com.javaguru.shoppinglist.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    private final UserRepository userRepository;

    public UserService(UserRepository repository) {
        this.userRepository = repository;
    }

    public UserEntity save(UserEntity userEntity){
        return userRepository.save(userEntity);
    }

    public UserEntity findUserById(Long userId) {
        return userRepository.findUserById(userId);
    }

}
