package com.courseproj.CourseProject.Entity;

import java.util.ArrayList;
import java.util.List;

public class Order {

    private int idReceipt;
    private int price;
    private int idUser;
    private int idStatus;
    private int idDelivery;
    private String StatusName;

    @Override
    public String toString() {
        return "Order{" +
                "idReceipt=" + idReceipt +
                ", price=" + price +
                ", idUser=" + idUser +
                ", idStatus=" + idStatus +
                ", idDelivery=" + idDelivery +
                ", StatusName='" + StatusName + '\'' +
                ", name='" + name + '\'' +
                ", delivery_info='" + delivery_info + '\'' +
                ", receipt_idReceipt=" + receipt_idReceipt +
                ", product_basketList=" + product_basketList +
                '}';
    }

    public String getStatusName() {
        return StatusName;
    }

    public void setStatusName(String statusName) {
        StatusName = statusName;
    }

    public Order(int idReceipt, int price, int idUser, int idStatus, int idDelivery, String statusName, String name, String delivery_info, int receipt_idReceipt, List<Product_basket> product_basketList) {
        this.idReceipt = idReceipt;
        this.price = price;
        this.idUser = idUser;
        this.idStatus = idStatus;
        this.idDelivery = idDelivery;
        StatusName = statusName;
        this.name = name;
        this.delivery_info = delivery_info;
        this.receipt_idReceipt = receipt_idReceipt;
        this.product_basketList = product_basketList;
    }

    private String name;
    private String delivery_info;
    private int receipt_idReceipt;
    public List<Product_basket> product_basketList = new ArrayList<>();

    public Order(int price) {
        this.price = price;
    }

    public int getIdDelivery() {
        return idDelivery;
    }

    public void setIdDelivery(int idDelivery) {
        this.idDelivery = idDelivery;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDelivery_info() {
        return delivery_info;
    }

    public void setDelivery_info(String delivery_info) {
        this.delivery_info = delivery_info;
    }

    public int getReceipt_idReceipt() {
        return receipt_idReceipt;
    }

    public void setReceipt_idReceipt(int receipt_idReceipt) {
        this.receipt_idReceipt = receipt_idReceipt;
    }

    public Order(int idReceipt, int price, int idUser, int idStatus, int idDelivery, String name, String delivery_info, int receipt_idReceipt) {
        this.idReceipt = idReceipt;
        this.price = price;
        this.idUser = idUser;
        this.idStatus = idStatus;
        this.idDelivery = idDelivery;
        this.name = name;
        this.delivery_info = delivery_info;
        this.receipt_idReceipt = receipt_idReceipt;
    }

    public int getIdReceipt() {
        return idReceipt;
    }

    public void setIdReceipt(int idReceipt) {
        this.idReceipt = idReceipt;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getIdUser() {
        return idUser;
    }

    public void setIdUser(int idUser) {
        this.idUser = idUser;
    }

    public int getIdStatus() {
        return idStatus;
    }

    public void setIdStatus(int idStatus) {
        this.idStatus = idStatus;
    }

    public Order() {
    }

    public Order(int idReceipt, int price, int idUser, int idStatus) {
        this.idReceipt = idReceipt;
        this.price = price;
        this.idUser = idUser;
        this.idStatus = idStatus;
    }
}
