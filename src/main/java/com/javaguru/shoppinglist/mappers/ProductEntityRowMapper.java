package com.javaguru.shoppinglist.mappers;

import com.javaguru.shoppinglist.domain.ProductEntity;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;
import java.sql.ResultSet;
import java.sql.SQLException;

@Component
public class ProductEntityRowMapper implements RowMapper<ProductEntity> {

    @Override
    public ProductEntity mapRow(ResultSet rs, int rowNum) throws SQLException {
        return new ProductEntity.Builder()
                .withId(rs.getLong("id"))
                .withName(rs.getString("name"))
                .withPrice(rs.getBigDecimal("price"))
                .withDiscount(rs.getBigDecimal("discount"))
                .withDescription(rs.getString("description"))
                .withCategory(rs.getString("category"))
                .build();
    }
}
