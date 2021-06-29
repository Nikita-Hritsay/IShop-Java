package com.courseproj.CourseProject.Entity;

import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class Basket_productMapper implements RowMapper<Basket_product> {
    @Override
    public Basket_product mapRow(ResultSet resultSet, int i) throws SQLException {
        Basket_product basket_product = new Basket_product();
        basket_product.setAmount(resultSet.getInt("amount"));
        basket_product.setIdProduct(resultSet.getInt("idProduct"));
        basket_product.setPrice(resultSet.getInt("price"));
        basket_product.setPath_to_file(resultSet.getString("path_to_file"));
        //basket_product.setType(resultSet.getString("type"));
        basket_product.setIdProduct(resultSet.getInt("idProduct"));
        basket_product.setName(resultSet.getString("name"));
        return basket_product;
    }
}