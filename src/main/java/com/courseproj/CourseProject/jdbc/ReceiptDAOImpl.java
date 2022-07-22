package com.courseproj.CourseProject.jdbc;

import com.courseproj.CourseProject.Entity.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ReceiptDAOImpl implements ReceiptDAO
{

    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public ReceiptDAOImpl(JdbcTemplate jdbcTemplate)
    {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public void save_receipt(Order order, String login, boolean assamble)
    {
        jdbcTemplate.update("INSERT INTO receipt (price, user_iduser, idStatus, assambleAndTest)\n" +
                        "     VALUES ( ?, (SELECT iduser FROM user WHERE login=?), \n" +
                        "     (SELECT idStatus FROM status WHERE status='В обработке'), ?);",
                order.getPrice(), login, assamble);
    }

    @Override
    public void saveDelivery(Delivery delivery, String login)
    {
        jdbcTemplate.update(
                "INSERT INTO delivery (Receipt_idReceipt, delivery_info, name)\n" +
                        "VALUES ((select MAX(idReceipt) from receipt where user_iduser = (select idUser from user where login = ?)),\n"
                        +
                        "?, ?);",
                login, delivery.getDeliveryInfo(), delivery.getName());
    }

    @Override
    public void saveReceiptProduct(String login, Basket_product product)
    {
        jdbcTemplate.update(
                "INSERT INTO reciept_has_product (idProduct, idReceipt, amount, price)\n"
                        +
                        "     VALUES (?, (select MAX(idReceipt) from receipt \n" +
                        "where user_iduser = (select idUser from user where login = ?)), ?, ?);",
                product.getIdProduct(), login, product.getAmount(),
                product.getPrice());
    }

    @Override
    public List<Order> index(String login)
    {
        return jdbcTemplate.query(
                "select idReceipt, receipt.price, status.status as receipt_status, status.idStatus, user_iduser"
                        +
                        " from receipt " +
                        " join status on receipt.idStatus = status.idStatus " +
                        " where user_iduser = (select idUser from user where login = ?)"
                        +
                        " order by idReceipt DESC", new Object[] { login },
                new ReceiptMapper());
    }

    public Order getById(Integer id)
    {
        return jdbcTemplate.query(
                "select idReceipt, receipt.price, status.status as receipt_status, status.idStatus, user_iduser"
                        +
                        " from receipt " +
                        " join status on receipt.idStatus = status.idStatus " +
                        " where idReceipt = ?   ",
                new Object[] { id },
                new ReceiptMapper()).stream().findFirst().orElse(null);
    }

    @Override
    public List<Order> showAllOrders()
    {
        return jdbcTemplate.query(
                "select idReceipt, receipt.price, status.status as receipt_status, status.idStatus, user_iduser"
                        +
                        " from receipt " +
                        " join status on receipt.idStatus = status.idStatus " +
                        " order by idReceipt DESC", new ReceiptMapper());
    }

    @Override
    public Delivery showDeliveryInfo(int idReceipt)
    {
        return jdbcTemplate.query(
                        "select idDelivery, name, delivery_info from delivery where Receipt_idReceipt = ?",
                        new Object[] { idReceipt }, new DeliveryMapper())
                .stream().findAny().orElse(null);
    }

    @Override
    public List<Product_basket> index_product_basket(int receipt_id)
    {
        return jdbcTemplate.query(
                "select product.idProduct, product.name, type.name as type, \n" +
                        "path_to_file, amount, product.price as price, reciept_has_product.price as Count_price \n "
                        +
                        "from reciept_has_product\n" +
                        "join product on product.idProduct = reciept_has_product.idProduct\n"
                        +
                        "join img on product.Img_idImg = img.idImg\n" +
                        "join type on type.idtype = product.idtype\n" +
                        "where idReceipt = ?", new Object[] { receipt_id },
                new Product_basketMapper());
    }

    @Override
    public void changeStatus(String status, int idReceipt)
    {
        int idStatus;
        switch (status)
        {
            case "В обработке":
                idStatus = 1;
                break;
            case "Готов":
                idStatus = 2;
                break;
            case "Доставлен":
                idStatus = 3;
                break;
            case "Отменен":
                idStatus = 4;
                break;
            default:
                idStatus = 1;
                break;
        }
        System.out.println(idStatus);
        jdbcTemplate.update("update receipt set idStatus = ? where idReceipt = ?",
                idStatus, idReceipt);
    }
}
