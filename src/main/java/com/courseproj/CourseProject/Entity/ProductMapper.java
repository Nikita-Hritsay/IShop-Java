package com.courseproj.CourseProject.Entity;

import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class ProductMapper implements RowMapper<Product> {

    @Override
    public Product mapRow(ResultSet resultSet, int i) throws SQLException {
        Product product = new Product();
        product.setIdProduct(resultSet.getInt("idProduct"));
        product.setName(resultSet.getString("name"));
        product.setPrice(resultSet.getInt("price"));
        product.setIdImg(resultSet.getInt("Img_idImg"));
        product.setIdType(resultSet.getInt("idType"));
        System.out.println(product.toString());

        return product;
    }
}
