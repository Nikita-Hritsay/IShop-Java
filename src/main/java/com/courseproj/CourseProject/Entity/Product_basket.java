package com.courseproj.CourseProject.Entity;

public class Product_basket extends Product{
    private int idProduct;
    private int amount;
    private int price;


    public void add_product_basket(Product product, int amount){
        this.amount += amount;
        this.price += product.getPrice() * amount;
    }

    public int getIdPoduct() {
        return idProduct;
    }

    public void setIdPoduct(int idPoduct) {
        this.idProduct = idPoduct;
    }

    public Product_basket(int idProduct, int amount, int price) {
        this.idProduct = idProduct;
        this.amount = amount;
        this.price = price;
    }

    public Product_basket() {
        this.amount = 0;
        this.price = 0;
    }

    public Product_basket(int amount, int price) {
        this.amount = amount;
        this.price = price;
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

    @Override
    public String toString() {
        return "Product_basket{" +
                "idProduct=" + idProduct +
                ", amount=" + amount +
                ", price=" + price +
                '}' + super.toString();
    }
}
