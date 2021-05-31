package com.courseproj.CourseProject.jdbc;

import com.courseproj.CourseProject.Entity.Product;
import com.courseproj.CourseProject.Entity.ProductMapper;
import com.courseproj.CourseProject.Entity.User;
import com.courseproj.CourseProject.Entity.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class AllProductsDAOImpl implements AllProductsDAO{

    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public AllProductsDAOImpl(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    private static final String SQL_GET_BY_ID = "select product.idProduct,  product.name, product.price, type.name as type, img.description," +
            " img.path_to_file " +
            " FROM product " +
            " JOIN type ON type.idType = product.idType " +
            " JOIN img on img.idImg = product.Img_idImg " +
            " where idProduct = ? " +
            " ORDER BY product.idProduct;";
    private static final String SQL_GET_ALL = "select product.idProduct,  product.name, product.price, type.name as type, img.description," +
            " img.path_to_file " +
            " FROM product " +
            " JOIN type ON type.idType = product.idType " +
            " JOIN img on img.idImg = product.Img_idImg " +
            " ORDER BY product.idProduct;";

    @Override
    public List<Product> getAllProducts(){
        return jdbcTemplate.query(SQL_GET_ALL, new ProductMapper());
    }

    @Override
    public Product index(int id) {


        Product product = jdbcTemplate.query(SQL_GET_BY_ID, new Object[]{id}, new ProductMapper())
                .stream().findAny().orElse(null);
        return product;
    }
}
