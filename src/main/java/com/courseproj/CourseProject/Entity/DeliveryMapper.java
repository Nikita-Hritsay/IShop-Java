package com.courseproj.CourseProject.Entity;

import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class DeliveryMapper implements RowMapper<Delivery> {
    @Override
    public Delivery mapRow(ResultSet resultSet, int i) throws SQLException {
        Delivery delivery = new Delivery();
        delivery.setDeliveryInfo(resultSet.getString("delivery_info"));
        delivery.setName(resultSet.getString("name"));
        return delivery;
    }
}
