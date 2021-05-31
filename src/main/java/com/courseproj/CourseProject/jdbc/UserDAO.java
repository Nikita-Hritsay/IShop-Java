package com.courseproj.CourseProject.jdbc;

import com.courseproj.CourseProject.Entity.User;

public interface UserDAO {
    User getCurrentUser(String ulogin);
    void updateUser(String Firstname, String Lastname, String Patronymic, String Telephone);
}
