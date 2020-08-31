package com.javaguru.shoppinglist.service;

import com.javaguru.shoppinglist.domain.UserEntity;
import com.javaguru.shoppinglist.dto.UserDto;
import com.javaguru.shoppinglist.mappers.UserMapper;
import com.javaguru.shoppinglist.repository.UserRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class UserServiceTest {

    @Autowired
    @Mock
    private UserService service;
    @Mock
    private UserMapper mapper;
    @MockBean
    private UserRepository repository;

    @Test
    public void shouldCreateUser(){
        when(repository.save(any())).thenReturn(entity());
        when(mapper.toDto(entity())).thenReturn(dto(1L));
        UserDto dto = service.create(dto(null));
        assertEquals(dto(1L), dto);
    }

    @Test
    public void shouldDeleteUser(){
      final Long userId=1L;
      service.delete(userId);
      service.delete(userId);
      verify(repository,times(2)).deleteById(userId);
    }

    private UserDto dto(Long id) {
        UserDto dto = new UserDto();
        dto.setId(id);
        dto.setUsername("Petya");
        return dto;
    }

    private UserEntity entity() {
        UserEntity user = new UserEntity();
        user.setId(1L);
        user.setUsername("Petya");
        return user;
    }
}