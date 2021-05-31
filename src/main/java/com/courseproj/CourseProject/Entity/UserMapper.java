package com.courseproj.CourseProject.Entity;

import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class UserMapper implements RowMapper<User> {

    @Override
    public User mapRow(ResultSet resultSet, int i) throws SQLException {
        User user = new User();
        user.setIdUser(resultSet.getInt("iduser"));
        user.setLogin(resultSet.getString("Login"));
        user.setUser_password(resultSet.getString("User_password"));
        user.setFirstname(resultSet.getString("Firstname"));
        user.setLastname(resultSet.getString("Lastname"));
        user.setPatronymic(resultSet.getString("Patronymic"));
        user.setTelephone(resultSet.getString("Telephone"));
        user.setIdRole(resultSet.getInt("idRole"));
        return user;
    }
}