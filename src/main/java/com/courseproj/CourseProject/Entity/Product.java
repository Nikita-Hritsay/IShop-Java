package com.courseproj.CourseProject.Entity;

public class Product {
    private int idProduct;
    private String name;
    private int price;
    private int idImg;
    private int idType;

    public Product(int idProduct, String name, int price, int idImg, int idType) {
        this.idProduct = idProduct;
        this.name = name;
        this.price = price;
        this.idImg = idImg;
        this.idType = idType;
    }

    public Product() {
    }

    public Product(String name, int price, int idImg, int idType) {
        this.name = name;
        this.price = price;
        this.idImg = idImg;
        this.idType = idType;
    }

    @Override
    public String toString() {
        return "Product{" +
                "idProduct=" + idProduct +
                ", name='" + name + '\'' +
                ", price=" + price +
                ", idImg=" + idImg +
                ", idType=" + idType +
                '}';
    }

    public int getIdProduct() {
        return idProduct;
    }

    public void setIdProduct(int idProduct) {
        this.idProduct = idProduct;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getIdImg() {
        return idImg;
    }

    public void setIdImg(int idImg) {
        this.idImg = idImg;
    }

    public int getIdType() {
        return idType;
    }

    public void setIdType(int idType) {
        this.idType = idType;
    }
}
