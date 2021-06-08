package com.courseproj.CourseProject.Entity;

import java.util.ArrayList;
import java.util.List;

public class Basket {
    private List<Product> basketList = new ArrayList<Product>();

    private ArrayList<Product_basket> product_basketList = new ArrayList<>();

    public void add_to_basket(Product product, int amount){
        boolean check = false;
        for(int i = 0; i < basketList.size(); i++){
            if(basketList.get(i).getIdProduct() == product.getIdProduct()){
                check = true;
                break;
            }
        }

        if(check){
            for(int i = 0; i < product_basketList.size(); i++){
                if(product_basketList.get(i).getIdPoduct() == product.getIdProduct()){
                    product_basketList.get(i).add_product_basket(product, amount);
                }
            }
        }
        else {
            basketList.add(product);
            product_basketList.add(new Product_basket(product.getIdProduct(), amount, product.getPrice() * amount));
        }

    }

    public  List<Product> getBasketList(){
        return basketList;
    }

    public ArrayList<Product_basket> getProduct_basketList() {
        return product_basketList;
    }

    public void delete_all(){
        basketList.clear();
        product_basketList.clear();
    }

    public int getFullPrice(){
        int result = 0;
        for (int i = 0; i < product_basketList.size(); i++){
            result += product_basketList.get(i).getPrice();
        }
        return result;
    }
}