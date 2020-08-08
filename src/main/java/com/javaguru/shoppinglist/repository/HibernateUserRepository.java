package com.javaguru.shoppinglist.repository;
import com.javaguru.shoppinglist.domain.UserEntity;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import java.util.Optional;

@Repository
@Transactional
public class HibernateUserRepository implements UserRepository {

    private final SessionFactory sessionFactory;

    public HibernateUserRepository(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public UserEntity save(UserEntity userEntity) {
        sessionFactory.getCurrentSession().save(userEntity);
        return userEntity;
    }

    @Override
    public UserEntity findUserById(Long id) {
        UserEntity userEntity = sessionFactory.getCurrentSession().find(UserEntity.class, id);
        return userEntity;
    }

    @Override
    public void update(UserEntity userEntity) {
        sessionFactory.getCurrentSession().update(userEntity);
    }
}
