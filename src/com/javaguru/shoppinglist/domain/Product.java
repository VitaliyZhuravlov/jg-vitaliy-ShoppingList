package com.javaguru.shoppinglist.domain;

import java.math.BigDecimal;
import java.math.MathContext;
import java.util.Objects;

public class Product {


    private Long id;
    private String name;
    private BigDecimal price;
    private String description;
    private double discount;
    private String category;


    public Product(String name, BigDecimal price, String description, double discount, String category) {
        this.name = name;
        this.price = price;
        this.description = description;
        this.discount = discount;
        this.category = category;
    }

    public Product(Long id,String name, BigDecimal price, String description, double discount, String category) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.description = description;
        this.discount = discount;
        this.category = category;
    }


    public Long getId() { return id; }

    public String getName() { return name; }

    public double getDiscount() { return discount; }

    public String getDescription() {
        return description;
    }

    public BigDecimal getPrice() { return price; }

    public String getCategory() { return category; }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Product product = (Product) o;
        return Double.compare(product.discount, discount) == 0 &&
                Objects.equals(id, product.id) &&
                Objects.equals(name, product.name) &&
                Objects.equals(price, product.price) &&
                Objects.equals(description, product.description) &&
                Objects.equals(category, product.category);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, price, description, discount, category);
    }

    public BigDecimal PriceWithDiscount(){
        MathContext m = new MathContext(2);
        return price.subtract(price.multiply(BigDecimal.valueOf(discount)).divide(BigDecimal.valueOf(100)).round(m));
    }

    @Override
    public String toString() {
        return "Product{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", price=" + price +
                ", description='" + description + '\'' +
                ", price with discount=" + PriceWithDiscount()+
                ", discount=" + discount +"%"+ '\'' +
                ", category=" + category +
                '}';
    }
}