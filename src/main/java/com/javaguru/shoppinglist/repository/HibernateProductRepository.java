package com.javaguru.shoppinglist.repository;
import com.javaguru.shoppinglist.domain.ProductEntity;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.List;
import java.util.Optional;

@Repository
@Profile("hibernate")
@Transactional
public class HibernateProductRepository implements ProductRepository {

    private final SessionFactory sessionFactory;

    public HibernateProductRepository(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public ProductEntity save(ProductEntity productEntity) {
        sessionFactory.getCurrentSession().save(productEntity);
        return productEntity;
    }

    @Override
    public Optional<ProductEntity> findProductById(Long id) {
        ProductEntity productEntity = sessionFactory.getCurrentSession().find(ProductEntity.class,id);
        return Optional.ofNullable(productEntity);
    }

    @Override
    public Optional<ProductEntity> findProductByName(String name) {
        ProductEntity productEntity = (ProductEntity) sessionFactory.getCurrentSession().createQuery("FROM ProductEntity E WHERE E.name = :name")
                .setParameter("name",name)
                .getSingleResult();
        return Optional.ofNullable(productEntity);
    }

    @Override
    public void deleteProduct(Long id) {
        Session session = sessionFactory.getCurrentSession();
        ProductEntity productEntity = session.load(ProductEntity.class,id);
        session.delete(productEntity);
    }

    @Override
    public void update(ProductEntity productEntity) {
        sessionFactory.getCurrentSession().update(productEntity);
    }

    @Override
    public List<ProductEntity> findAll() {
        Session currentSession = sessionFactory.getCurrentSession();
        CriteriaBuilder builder = currentSession.getCriteriaBuilder();
        CriteriaQuery<ProductEntity> query = builder.createQuery(ProductEntity.class);
        Root<ProductEntity> root = query.from(ProductEntity.class);
        query.select(root);
        return currentSession.createQuery(query).getResultList();
    }
}
