package com.courseproj.CourseProject.Entity;

import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class Product_basketMapper implements RowMapper<Product_basket> {
    @Override
    public Product_basket mapRow(ResultSet resultSet, int i) throws SQLException {
        Product_basket product_basket = new Product_basket();
        product_basket.setAmount(resultSet.getInt("amount"));
        product_basket.setIdPoduct(resultSet.getInt("idProduct"));
        product_basket.setPrice(resultSet.getInt("price"));
        product_basket.setPath_to_file(resultSet.getString("path_to_file"));
        product_basket.setType(resultSet.getString("type"));
        product_basket.setIdProduct(resultSet.getInt("idProduct"));
        product_basket.setName(resultSet.getString("name"));
        return product_basket;
    }
}