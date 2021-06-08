package com.courseproj.CourseProject.jdbc;

import com.courseproj.CourseProject.Entity.Basket;
import com.courseproj.CourseProject.Entity.Delivery;
import com.courseproj.CourseProject.Entity.Order;
import com.courseproj.CourseProject.Entity.Product_basket;

import java.util.List;

public interface ReceiptDAO {
    void save_receipt(Order order, String login);
    void saveDelivery(Delivery delivery, String login);
    void saveReceiptProduct(String login, Product_basket product);
    List<Order> index(String login);
    List<Product_basket> index_product_basket(int receipt_id);
    List<Order> showAllOrders();
    Delivery showDeliveryInfo(int idReceipt);
    void changeStatus(String status, int idReceipt);
}
