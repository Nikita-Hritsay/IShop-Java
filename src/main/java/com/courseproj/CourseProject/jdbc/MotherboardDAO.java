package com.courseproj.CourseProject.jdbc;

import com.courseproj.CourseProject.Entity.Product;

import java.util.List;

public interface MotherboardDAO {
    List<Product> getAllMotherboards();

    Product index(int id);
}
