package com.courseproj.CourseProject.Entity;

import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class BasketMapper implements RowMapper<BasketU> {

    @Override
    public BasketU mapRow(ResultSet resultSet, int i) throws SQLException
    {
        BasketU basket = new BasketU();
        basket.setIdBasket(resultSet.getInt("idBasket"));
        basket.setIdUser(resultSet.getInt("User_idUser"));
        basket.setPrice(resultSet.getInt("price"));
        return basket;
    }
}