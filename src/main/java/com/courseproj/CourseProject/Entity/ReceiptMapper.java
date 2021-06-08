package com.courseproj.CourseProject.Entity;

import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class ReceiptMapper implements RowMapper<Order> {

    @Override
    public Order mapRow(ResultSet resultSet, int i) throws SQLException
    {
        Order order = new Order();
        order.setIdReceipt(resultSet.getInt("idReceipt"));
        order.setReceipt_idReceipt(resultSet.getInt("idReceipt"));
        order.setPrice(resultSet.getInt("price"));
        order.setIdUser(resultSet.getInt("user_iduser"));
        order.setIdStatus(resultSet.getInt("idStatus"));
        order.setStatusName(resultSet.getString("receipt_status"));
        order.setReceipt_idReceipt(resultSet.getInt("idReceipt"));
        return order;
    }
}