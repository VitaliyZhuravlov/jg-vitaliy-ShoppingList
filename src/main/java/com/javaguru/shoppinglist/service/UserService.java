package com.javaguru.shoppinglist.service;

import com.javaguru.shoppinglist.dto.UserDto;
import com.javaguru.shoppinglist.mappers.UserMapper;
import com.javaguru.shoppinglist.repository.UserRepository;
import com.javaguru.shoppinglist.exceptions.ProductNotFoundException;
import org.springframework.stereotype.Service;
import java.util.ArrayList;

@Service
public class UserService {

    private final UserRepository repository;
    private final UserMapper mapper;

    public UserService(UserRepository repository, UserMapper mapper) {
        this.repository = repository;
        this.mapper = mapper;
    }

    public UserDto create(UserDto dto) {
        return mapper.toDto(repository.save(mapper.toEntity(dto)));
    }

    public UserDto findUserById(Long id)  {
        return mapper.toDto(repository.findById(id)
                .orElseThrow(() -> new ProductNotFoundException("User not found, id: " + id)));
    }

    public void update(UserDto dto) {
        mapper.toDto(repository.save(mapper.toEntity(dto)));
    }

    public void delete(Long id){
        repository.deleteById(id);
    }

    public UserDto findUserByName(String username) {
        return mapper.toDto(repository.findByUsername(username)
                .orElseThrow(() -> new ProductNotFoundException("Product not found, name: " + username)));
    }

    public ArrayList<UserDto> findAll() {
        ArrayList<UserDto> dtoList = new ArrayList<>();
        repository.findAll().forEach(userEntity -> dtoList.add(mapper.toDto(userEntity)));
        return dtoList;
    }
}
