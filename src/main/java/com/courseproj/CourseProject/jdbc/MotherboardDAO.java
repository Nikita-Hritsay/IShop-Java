package com.courseproj.CourseProject.jdbc;

import com.courseproj.CourseProject.Entity.Product;

import java.util.List;

public interface MotherboardDAO {
    List<Product> getAllMotherbaords();

    Product index(int id);


}
