package com.courseproj.CourseProject.controllers;

import com.courseproj.CourseProject.Entity.*;
import com.courseproj.CourseProject.jdbc.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailSender;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;


@Controller
public class MainController {
    private final MotherboardDAOImpl motherboardDAO;
    private final AllProductsDAOImpl allProductsDAO;
    private final GraphicsCardDAOImpl graphicsCardDAO;
    private final UserDAOImpl userDAO;
    private final ReceiptDAOImpl receiptDAO;
    private final ProcessorDAOImpl processorDAO;
    private final BasketDAOImpl basketDAO;
    private BasketU basketU = new BasketU();

    @Autowired
    private MailSender mailSender;

    @Autowired
    public MainController(MotherboardDAOImpl motherboardDAO, AllProductsDAOImpl allProductsDAO, GraphicsCardDAOImpl graphicsCardDAO,UserDAOImpl userDAO, ReceiptDAOImpl receiptDAO, ProcessorDAOImpl processorDAO, BasketDAOImpl basketDAO) {
        this.motherboardDAO = motherboardDAO;
        this.allProductsDAO = allProductsDAO;
        this.graphicsCardDAO = graphicsCardDAO;
        this.userDAO = userDAO;
        this.receiptDAO = receiptDAO;
        this.processorDAO = processorDAO;
        this.basketDAO = basketDAO;
    }

    @GetMapping("/basket")
    public String basketPage(Model model){
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        model.addAttribute("baskets", basketDAO.getBasket(authentication.getName()));
        model.addAttribute("FullPrice", basketDAO.getFullPrice(authentication.getName()));
        model.addAttribute("categories", allProductsDAO.getAllCategories());
        return "basket";
    }

    @PostMapping("/basket")
    public String BasketPagePost(Model model, @RequestParam String name, @RequestParam String delivery_info) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        receiptDAO.save_receipt(new Order(basketDAO.getFullPrice(authentication.getName()).getPrice()), authentication.getName());
        List<Basket_product> product_baskets = basketDAO.getBasket_product(authentication.getName());
        for(int i = 0; i < product_baskets.size(); i++){
            receiptDAO.saveReceiptProduct(authentication.getName(), product_baskets.get(i));
        }
        Delivery delivery = new Delivery(name, delivery_info);
        receiptDAO.saveDelivery(delivery, authentication.getName());

        basketDAO.deleteBasket(authentication.getName());
        return "redirect:/";
    }

    @PostMapping("/delete_basket")
    public String delete_basket(Model model) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        basketDAO.deleteBasket(authentication.getName());
        return "redirect:/";
    }

    @GetMapping("/admin")
    public String admin(Model model){
        model.addAttribute("title", "Admin page");
        model.addAttribute("account", "аккаунт");
        model.addAttribute("categories", allProductsDAO.getAllCategories());
        return "admin";
    }

    @GetMapping("/orders")
    public String order(Model model){
        List<Order> list = receiptDAO.showAllOrders();
        model.addAttribute("categories", allProductsDAO.getAllCategories());
        model.addAttribute("orders", list);
        return "orders";
    }

    @GetMapping("/order/{idReceipt}")
    public String orderId(Model model, @PathVariable int idReceipt){
        List<Product_basket> product_baskets = receiptDAO.index_product_basket(idReceipt);
        model.addAttribute("categories", allProductsDAO.getAllCategories());
        User user = userDAO.getUserByReceiptid(idReceipt);
        Delivery delivery = receiptDAO.showDeliveryInfo(idReceipt);
        model.addAttribute("idReceipt", idReceipt);
        model.addAttribute("product_baskets", product_baskets);
        model.addAttribute("userInfo", user);
        model.addAttribute("delivery_info", delivery);
        return "orderid";
    }

    @PostMapping("/order/{idReceipt}")
    public String orderIdPost(Model model, @RequestParam String status, @RequestParam int idReceipt){
        receiptDAO.changeStatus(status, idReceipt);
        return "redirect:/";
    }

    @GetMapping("/userOrders")
    public String userOrders(Model model){
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        model.addAttribute("orders", receiptDAO.index(authentication.getName()));
        model.addAttribute("categories", allProductsDAO.getAllCategories());
        System.out.println(receiptDAO.index(authentication.getName()));
        return "userOrders";
    }



}