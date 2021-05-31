package com.courseproj.CourseProject.jdbc;

import com.courseproj.CourseProject.Entity.ProductMapper;
import com.courseproj.CourseProject.Entity.User;
import com.courseproj.CourseProject.Entity.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowCallbackHandler;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;

import java.sql.*;

@Component
public class UserDAOImpl implements UserDAO{

    private final JdbcTemplate jdbcTemplate;

    private String SQL_USER_GETCURRENT = "select * from user where Login = ?";

    @Autowired
    public UserDAOImpl(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public User getCurrentUser(String ulogin) {

        User user = jdbcTemplate.query(SQL_USER_GETCURRENT, new Object[]{ulogin}, new UserMapper())
                .stream().findAny().orElse(null);

        return user;
    }

    @Override
    public void updateUser(String Firstname, String Lastname, String Patronymic, String Telephone){
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String currentUser = authentication.getName();
        User user = getCurrentUser(currentUser);
        String query = "update user set Firstname = '" + (Firstname == null ? user.getFirstname() : Firstname)
                + "', Lastname = '" + (Lastname == null ? user.getLastname() : Lastname)
                + "', Patronymic = '" + (Patronymic == null ? user.getPatronymic() : Patronymic)
                + "', Telephone = '" + (Telephone == null ? user.getTelephone() : Telephone)
                + "' where Login = '" + user.getLogin() + "'";
        System.out.println(query);
        jdbcTemplate.update(query);
    }

}
