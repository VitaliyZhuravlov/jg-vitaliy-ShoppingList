package com.javaguru.shoppinglist.service;

import com.javaguru.shoppinglist.domain.UserEntity;
import com.javaguru.shoppinglist.repository.UserRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import java.util.ArrayList;
import java.util.List;
import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class UserServiceTest {

    @Autowired
    @Mock
    private UserService service;

    @MockBean
    private UserRepository repository;

    @Test
    public void shouldCreateUser(){
        UserEntity userEntity = new UserEntity();
        userEntity.setId(1L);
        userEntity.setUsername("Petya");
        when(repository.save(userEntity)).thenReturn(userEntity);
        assertEquals(service.create(userEntity),userEntity);
    }

    @Test
    public void shouldDeleteUser(){
      final Long userId=1L;
      service.delete(userId);
      service.delete(userId);
      verify(repository,times(2)).deleteById(userId);
    }

    @Test
    public void shouldFindAllUsers(){
        UserEntity userEntity = new UserEntity();
        userEntity.setId(1L);
        userEntity.setUsername("Petya");

        UserEntity userEntity2 = new UserEntity();
        userEntity2.setId(2L);
        userEntity2.setUsername("Vasya");

        List<UserEntity> userEntityList = new ArrayList<>();
        userEntityList.add(userEntity);
        userEntityList.add(userEntity2);

        when(repository.findAll()).thenReturn(userEntityList);
        assertEquals(service.findAll(),userEntityList);
    }
}