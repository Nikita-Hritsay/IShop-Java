package com.courseproj.CourseProject.jdbc;

import com.courseproj.CourseProject.Entity.*;

import java.util.List;

public interface ReceiptDAO {
    void save_receipt(Order order, String login, boolean assamble);
    void saveDelivery(Delivery delivery, String login);
    void saveReceiptProduct(String login, Basket_product product);
    List<Order> index(String login);
    List<Product_basket> index_product_basket(int receipt_id);
    List<Order> showAllOrders();
    Delivery showDeliveryInfo(int idReceipt);
    void changeStatus(String status, int idReceipt);
}
