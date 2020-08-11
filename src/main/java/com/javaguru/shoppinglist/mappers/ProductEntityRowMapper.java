package com.javaguru.shoppinglist.mappers;
import com.javaguru.shoppinglist.domain.ProductEntity;
import org.springframework.jdbc.core.RowMapper;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ProductEntityRowMapper implements RowMapper<ProductEntity> {

    @Override
    public ProductEntity mapRow(ResultSet rs, int rowNum) throws SQLException {
        return new ProductEntity.Builder()
                .withId(rs.getLong("id"))
                .withName(rs.getString("name"))
                .withPrice(rs.getBigDecimal("price"))
                .withDiscount(rs.getBigDecimal("discount"))
                .withDescription(rs.getString("description"))
                .withCategory(rs.getString("Category"))
                .build();
    }
}