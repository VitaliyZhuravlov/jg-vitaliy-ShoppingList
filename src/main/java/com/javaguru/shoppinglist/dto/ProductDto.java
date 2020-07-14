package com.javaguru.shoppinglist.dto;
import java.math.BigDecimal;
import java.math.MathContext;
import java.util.Objects;

public class ProductDto {
    private Long id;
    private String name;
    private BigDecimal price;
    private String description;
    private double discount;
    private String category;

    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

    public BigDecimal getPrice() {
        return price;
    }
    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public String getDescription() {
        return description;
    }
    public void setDescription(String description) {
        this.description = description;
    }

    public double getDiscount() {
        return discount;
    }
    public void setDiscount(double discount) {
        this.discount = discount;
    }

    public String getCategory() {
        return category;
    }
    public void setCategory(String category) {
        this.category = category;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ProductDto that = (ProductDto) o;
        return Double.compare(that.discount, discount) == 0 &&
                Objects.equals(id, that.id) &&
                Objects.equals(name, that.name) &&
                Objects.equals(price, that.price) &&
                Objects.equals(description, that.description) &&
                Objects.equals(category, that.category);
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
                ", price=€" + price +
                ", description='" + description + '\'' +
                ", price with discount=" + PriceWithDiscount()+
                ", discount=" + discount +"%"+ '\'' +
                ", category=" + category +
                '}';
    }
}
