package com.courseproj.CourseProject.jdbc;

import com.courseproj.CourseProject.Entity.Product;
import com.courseproj.CourseProject.Entity.Type;

import java.util.List;

public interface AllProductsDAO {
    List<Product> getAllProducts();
    Product index(int id);
    void addProduct(String name, int price, int Img_idImg, int idType, String Description);
    void deleteProduct(int idProduct);
    void updateProduct(String name, int price, int idType, int idProduct, String Description);
    List<Type> getAllCategories();
    List<Product> getByCategory(int idCategory);
    Type getCategoryByIndex(int idCategory);
    void updateCategory(int idCategory, String name);
    void addCategory(String name);
    void deleteCategory(int idCategory);
}
