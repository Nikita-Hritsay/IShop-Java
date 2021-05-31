package com.courseproj.CourseProject.jdbc;

import com.courseproj.CourseProject.Entity.Product;

import java.util.List;

public interface AllProductsDAO {
    List<Product> getAllProducts();

    Product index(int id);
}
