package com.courseproj.CourseProject.jdbc;

import com.courseproj.CourseProject.Entity.Product;
import com.courseproj.CourseProject.Entity.ProductMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ProcessorDAOImpl implements  ProcessorDAO{

    private final JdbcTemplate jdbcTemplate;

    private static final String SQL_GET_ALL = "select product.idProduct,  product.name, product.price, type.name as type, product.productDescription," +
            " img.path_to_file " +
            " FROM product " +
            " JOIN type ON type.idType = product.idType " +
            " JOIN img on img.idImg = product.Img_idImg " +
            " where type.name = 'processor' " +
            " ORDER BY product.idProduct;";
    private static final String SQL_GET_INDEX = "select product.idProduct,  product.name, product.price, type.name as type, product.productDescription," +
            " img.path_to_file " +
            " FROM product " +
            " JOIN type ON type.idType = product.idType " +
            " JOIN img on img.idImg = product.Img_idImg " +
            " where idProduct = ? " +
            " ORDER BY product.idProduct;";

    @Autowired
    public ProcessorDAOImpl(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public List<Product> getAllProcessors() {
        return jdbcTemplate.query(SQL_GET_ALL, new ProductMapper());
    }

    @Override
    public Product index(int id) {
        return jdbcTemplate.query(SQL_GET_INDEX, new Object[]{id}, new ProductMapper())
                .stream().findAny().orElse(null);
    }


}
