package com.courseproj.CourseProject.Entity;

public class Basket_product extends Product{
    private int idProduct;
    private int amount;
    private int price;

    @Override
    public String toString() {
        return "Basket_product{" +
                "idProduct=" + idProduct +
                ", amount=" + amount +
                ", price=" + price +
                '}';
    }

    public int getIdProduct() {
        return idProduct;
    }

    public void setIdProduct(int idProduct) {
        this.idProduct = idProduct;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public Basket_product() {
    }

    public Basket_product(int idProduct, int amount, int price) {
        this.idProduct = idProduct;
        this.amount = amount;
        this.price = price;

    }
}
