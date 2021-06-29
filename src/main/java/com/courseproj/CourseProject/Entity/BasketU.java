package com.courseproj.CourseProject.Entity;

public class BasketU {
    private int idBasket;
    private int idUser;
    private int Price;

    @Override
    public String toString() {
        return "BasketU{" +
                "idBasket=" + idBasket +
                ", idUser=" + idUser +
                ", Price=" + Price +
                '}';
    }

    public int getIdBasket() {
        return idBasket;
    }

    public void setIdBasket(int idBasket) {
        this.idBasket = idBasket;
    }

    public int getIdUser() {
        return idUser;
    }

    public void setIdUser(int idUser) {
        this.idUser = idUser;
    }

    public int getPrice() {
        return Price;
    }

    public void setPrice(int price) {
        Price = price;
    }

    public BasketU() {
    }

    public BasketU(int idBasket, int idUser, int price) {
        this.idBasket = idBasket;
        this.idUser = idUser;
        Price = price;
    }
}
