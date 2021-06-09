package com.courseproj.CourseProject.jdbc;

import com.courseproj.CourseProject.Entity.Product;

import java.util.List;

public interface ProcessorDAO {
    List<Product> getAllProcessors();

    Product index(int id);

}
