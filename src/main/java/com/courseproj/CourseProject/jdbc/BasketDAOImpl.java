package com.courseproj.CourseProject.jdbc;

import com.courseproj.CourseProject.Entity.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class BasketDAOImpl implements  BasketDAO{

    private final JdbcTemplate jdbcTemplate;

    private final String SQL_GET_PRODUCTS_FROM_BASKET = "select product.idProduct,  product.name, product.price, type.name as type, product.productDescription ,img.path_to_file \n" +
            "from product\n" +
            "JOIN img on img.idImg = product.Img_idImg\n" +
            "JOIN type ON type.idType = product.idType\n" +
            "JOIN basket_product on basket_product.product_idProduct = product.idProduct\n" +
            "JOIN basket on basket_product.basket_idbasket = basket.idbasket\n" +
            "where basket.user_iduser = ?";

    @Autowired
    public BasketDAOImpl(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public void deleteBasket(String login) {
        jdbcTemplate.update("delete from basket_product where basket_user_idUser = " + new UserDAOImpl(jdbcTemplate).getCurrentUser(login).getIdUser());
    }

    @Override
    public BasketU getFullPrice(String login) {
        return jdbcTemplate.query("select * from basket where user_iduser = " + new UserDAOImpl(jdbcTemplate).getCurrentUser(login).getIdUser(),   new BasketMapper())
                .stream().findAny().orElse(null);
    }

    @Override
    public List<Basket_product> getBasket_product(String login) {
        return jdbcTemplate.query("select basket_product.amount, product.idProduct, product.price, img.path_to_file, product.productDescription, product.name from basket_product" +
                " join product on product.idProduct = basket_product.product_idProduct" +
                " join type on product.idType = type.idType" +
                " join img on product.Img_idImg = img.idImg" +
                " where basket_user_iduser = " + new UserDAOImpl(jdbcTemplate).getCurrentUser(login).getIdUser(), new Basket_productMapper());
    }

    @Override
    public List<Product> getBasket(String login) {
        List<Product> productList = jdbcTemplate.query(SQL_GET_PRODUCTS_FROM_BASKET
                , new ProductMapper(), new UserDAOImpl(jdbcTemplate).getCurrentUser(login).getIdUser());

        return productList;
    }

    @Override
    public void addToBasket_has_product(String login, Product product, int amount) {

        List<Product> list = jdbcTemplate.query("select * from basket_product, product, type, img where product_idProduct = ?", new ProductMapper(), product.getIdProduct());
        if(list.isEmpty()) {
            System.out.println("here2");
            jdbcTemplate.update("insert into courseproject.basket_product(amount, price, basket_idbasket, basket_user_iduser, product_idProduct) \n" +
                    "values(" + amount + ", " + product.getPrice() + " , (select idbasket from courseproject.basket where user_iduser = "
                    + new UserDAOImpl(jdbcTemplate).getCurrentUser(login).getIdUser() + "), " +
                    new UserDAOImpl(jdbcTemplate).getCurrentUser(login).getIdUser() + ", " +
                    product.getIdProduct() + ");");
        }else{
            System.out.println("here3");
            jdbcTemplate.update("update basket_product set amount = amount + " + amount +
                    " where product_idProduct = " + product.getIdProduct() + " " +
                    " and basket_product.basket_idbasket = (select idbasket from basket where user_iduser = " +
                    new UserDAOImpl(jdbcTemplate).getCurrentUser(login).getIdUser() + ")");
        }
    }
}
