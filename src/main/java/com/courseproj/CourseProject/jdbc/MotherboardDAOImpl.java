package com.courseproj.CourseProject.jdbc;

import com.courseproj.CourseProject.Entity.Product;
import com.courseproj.CourseProject.Entity.ProductMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import javax.sql.DataSource;
import java.util.List;

@Component
public class MotherboardDAOImpl implements MotherboardDAO{

    private final JdbcTemplate jdbcTemplate;

    private static final String SQL_GET_ALL = "select * from product";
    private static final String SQL_GET_INDEX = "select * from product where idProduct = ?";

    @Autowired
    public MotherboardDAOImpl(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public List<Product> getAllMotherbaords(){
        return jdbcTemplate.query(SQL_GET_ALL, new ProductMapper());
    }

    public Product index(int id){
        return jdbcTemplate.query(SQL_GET_INDEX, new Object[]{id}, new ProductMapper())
                .stream().findAny().orElse(null);
    }

}
