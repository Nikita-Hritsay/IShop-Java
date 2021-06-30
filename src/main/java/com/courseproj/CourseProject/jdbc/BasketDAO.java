package com.courseproj.CourseProject.jdbc;

import com.courseproj.CourseProject.Entity.BasketU;
import com.courseproj.CourseProject.Entity.Basket_product;
import com.courseproj.CourseProject.Entity.Product;

import java.util.List;

public interface BasketDAO {
    void deleteBasket(String login);
    void addToBasket_has_product(String login, Product product, int amount);
    List<Basket_product> getBasket_product(String login);
    List<Product> getBasket(String login);
    BasketU getFullPrice(String login);
}
