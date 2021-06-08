package com.courseproj.CourseProject.Entity;

public class Delivery {
    private String name;
    private String deliveryInfo;

    public Delivery() {
    }

    public Delivery(String name, String deliveryInfo) {
        this.name = name;
        this.deliveryInfo = deliveryInfo;
    }

    @Override
    public String toString() {
        return "Delivery{" +
                "name='" + name + '\'' +
                ", deliveryInfo='" + deliveryInfo + '\'' +
                '}';
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDeliveryInfo() {
        return deliveryInfo;
    }

    public void setDeliveryInfo(String deliveryInfo) {
        this.deliveryInfo = deliveryInfo;
    }
}
