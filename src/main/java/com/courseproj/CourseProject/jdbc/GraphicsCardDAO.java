package com.courseproj.CourseProject.jdbc;

import com.courseproj.CourseProject.Entity.Product;

import java.util.List;

public interface GraphicsCardDAO {
    List<Product> getAllGraphicsCards();

    Product index(int id);
}
