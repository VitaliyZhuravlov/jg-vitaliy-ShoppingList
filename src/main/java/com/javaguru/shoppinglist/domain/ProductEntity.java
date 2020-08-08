package com.javaguru.shoppinglist.domain;
import lombok.EqualsAndHashCode;
import lombok.ToString;

import javax.persistence.*;
import java.math.BigDecimal;
import java.math.MathContext;
import java.util.Optional;

@Entity
@Table(name = "products")
@EqualsAndHashCode(of ={"id"})
@ToString(of= {"id","name","price","discount","description","category"})
public class ProductEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;
    @Column(name = "name", unique = true)
    private String name;
    @Column(name = "price")
    private BigDecimal price;
    @Column(name = "discount")
    private BigDecimal discount;
    @Column(name = "description")
    private String description;
    @Column(name ="category")
    private  String category;

    @ManyToOne
    private UserEntity user;

    public ProductEntity() {
    }

    public ProductEntity(Long id, String name, BigDecimal price, BigDecimal discount, String description, String category) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.discount = discount;
        this.description = description;
        this.category = category;
    }

    private ProductEntity(Builder builder) {
        setId(builder.id);
        setName(builder.name);
        setPrice(builder.price);
        setDiscount(builder.discount);
        setDescription(builder.description);
        setCategory(builder.category);
        setUser(builder.user);
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public BigDecimal getDiscount() {
        return discount;
    }

    public String getDescription() {
        return description;
    }

    public String getCategory() {
        return category;
    }

    public UserEntity getUser() {
        return user;
    }

    public void setUser(UserEntity user) {
        this.user = user;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public void setDiscount(BigDecimal discount) {
        this.discount = discount;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public static final class Builder {
        private Long id;
        private String name;
        private BigDecimal price;
        private BigDecimal discount;
        private String description;
        private String category;
        private UserEntity user;

        public Builder() {
        }

        public Builder withId(Long id) {
            this.id = id;
            return this;
        }

        public Builder withName(String name) {
            this.name = name;
            return this;
        }

        public Builder withPrice(BigDecimal price) {
            this.price = price;
            return this;
        }

        public Builder withDiscount(BigDecimal discount) {
            this.discount = discount;
            return this;
        }

        public Builder withDescription(String description) {
            this.description = description;
            return this;
        }

        public Builder withCategory(String category) {
            this.category = category;
            return this;
        }

        public Builder withUser(UserEntity user) {
            this.user = user;
            return this;
        }

        public ProductEntity build() {
            return new ProductEntity(this);
        }
    }
}