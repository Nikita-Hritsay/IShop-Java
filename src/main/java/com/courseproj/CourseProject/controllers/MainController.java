package com.courseproj.CourseProject.controllers;

import com.courseproj.CourseProject.Entity.*;
import com.courseproj.CourseProject.jdbc.*;
import org.apache.juli.logging.Log;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;


@Controller
public class MainController {
    private final MotherboardDAOImpl motherboardDAO;
    private final AllProductsDAOImpl allProductsDAO;
    private final GraphicsCardDAOImpl graphicsCardDAO;
    private final UserDAOImpl userDAO;
    private final ReceiptDAOImpl receiptDAO;
    private final ProcessorDAOImpl processorDAO;
    private Basket basket = new Basket();


    @Autowired
    public MainController(MotherboardDAOImpl motherboardDAO, AllProductsDAOImpl allProductsDAO, GraphicsCardDAOImpl graphicsCardDAO,UserDAOImpl userDAO, ReceiptDAOImpl receiptDAO, ProcessorDAOImpl processorDAO) {
        this.motherboardDAO = motherboardDAO;
        this.allProductsDAO = allProductsDAO;
        this.graphicsCardDAO = graphicsCardDAO;
        this.userDAO = userDAO;
        this.receiptDAO = receiptDAO;
        this.processorDAO = processorDAO;
    }

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String home(Model model){
        model.addAttribute("title", "Home page");
        model.addAttribute("products", allProductsDAO.getAllProducts());
        return "home";
    }

    @GetMapping("/user")
    public String user(Model model){
        model.addAttribute("title", "User page");
        model.addAttribute("account", "аккаунт");
        return "user";
    }

    @GetMapping("/profilePage")
    public String profilePage(Model model){
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String currentUser = authentication.getName();
        model.addAttribute("users", userDAO.getCurrentUser(currentUser));
        return "profilePage";
    }

    @PostMapping("/profilePage")
    public String profilePagePost(Model model, @RequestParam String Firstname,
                                  @RequestParam String Lastname,
                                  @RequestParam String Patronymic,
                                  @RequestParam String Telephone){
        System.out.println(Firstname + "\t" + Lastname + "\t" + Patronymic + "\t" + Telephone);
        userDAO.updateUser(Firstname, Lastname, Patronymic, Telephone);
        return "redirect:/";
    }

    @GetMapping("/basket")
    public String basketPage(Model model){
        model.addAttribute("baskets", basket.getBasketList());
        return "basket";
    }

    @PostMapping("/basket")
    public String BasketPagePost(Model model, @RequestParam String name, @RequestParam String delivery_info) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        receiptDAO.save_receipt(new Order(basket.getFullPrice()), authentication.getName());
        ArrayList<Product_basket> product_baskets = basket.getProduct_basketList();
        for(int i = 0; i < product_baskets.size(); i++){
            receiptDAO.saveReceiptProduct(authentication.getName(), product_baskets.get(i));
        }
        Delivery delivery = new Delivery(name, delivery_info);
        receiptDAO.saveDelivery(delivery, authentication.getName());
        basket.delete_all();
        return "redirect:/";
    }

    @GetMapping("/admin")
    public String admin(Model model){
        model.addAttribute("title", "Admin page");
        model.addAttribute("account", "аккаунт");
        return "admin";
    }

    @GetMapping("/orders")
    public String order(Model model){
        List<Order> list = receiptDAO.showAllOrders();
        model.addAttribute("orders", list);
        return "orders";
    }

    @GetMapping("/order/{idReceipt}")
    public String orderId(Model model, @PathVariable int idReceipt){
        List<Product_basket> product_baskets = receiptDAO.index_product_basket(idReceipt);
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


    @GetMapping("/login")
    public String getLogin(@RequestParam(value = "error", required = false) String error,
                           @RequestParam(value = "logout", required = false) String logout,
                           Model model){
        model.addAttribute("error", error != null);
        model.addAttribute("logout", logout != null);
        return "login";
    }

    @GetMapping("/registration")
    public String registration(Model model){
        return "registration";
    }

    @PostMapping("/registration")
    public String registrationPost(Model model, @RequestParam String Firstname,
                                   @RequestParam String Lastname,
                                   @RequestParam String Patronymic,
                                   @RequestParam String Telephone,
                                   @RequestParam String Login,
                                   @RequestParam String Password){
        userDAO.addUser(Firstname, Lastname, Patronymic, Telephone, Login, Password);
        return "redirect:/";
    }

    @GetMapping("/motherboard")
    public String motherboard_all(Model model){
        model.addAttribute("products", motherboardDAO.getAllMotherboards());
        return "/motherboard";
    }

    @GetMapping("/product/{idProduct}")
    public String get_product_by_id(Model model, @PathVariable int idProduct){
        model.addAttribute("products", allProductsDAO.index(idProduct));
        return "/productid";
    }

    @PostMapping("/product/{idProduct}")
    public String get_product_by_idPost(Model model, @RequestParam String amount, @RequestParam int idProduct){
        Product product = allProductsDAO.index(idProduct);
        basket.add_to_basket(product, Integer.parseInt(amount));
        return "redirect:/";
    }

    @GetMapping("/graphicsCard")
    public String graphicsCard_all(Model model){
        model.addAttribute("products", graphicsCardDAO.getAllGraphicsCards());
        return "/motherboard";
    }

    @GetMapping("/processor")
    public String processor_all(Model model){
        model.addAttribute("products", processorDAO.getAllProcessors());
        return "/processors";
    }



    @GetMapping("/addProduct")
    public String addProduct(Model model){
        return "addProduct";
    }

    @PostMapping("/addProduct")
    public String addProductPost(Model model, @RequestParam String name, @RequestParam int price, @RequestParam int Img_idImg, @RequestParam int idType){
        allProductsDAO.addProduct(name, price, Img_idImg, idType);
        return "redirect:/";
    }

    @GetMapping("/editProduct")
    public String deleteProduct(Model model){
        model.addAttribute("products", allProductsDAO.getAllProducts());
        return "editProduct";
    }

    @GetMapping("/deleteProduct/{idProduct}")
    public String deleteProductId(Model model, @PathVariable int idProduct){
        model.addAttribute("products", allProductsDAO.index(idProduct));
        return "deleteProductid";
    }

    @PostMapping("/deleteProduct/{idProduct}")
    public String deleteProductIdPost(Model model, @RequestParam int idProduct){
        allProductsDAO.deleteProduct(idProduct);
        return "redirect:/";
    }

    @GetMapping("/updateProduct/{idProduct}")
    public String updateProductId(Model model, @PathVariable int idProduct){
        model.addAttribute("products", allProductsDAO.index(idProduct));
        return "updateProductid";
    }

    @PostMapping("/updateProduct/{idProduct}")
    public String updateProductIdPost(Model model, @RequestParam String Name, @RequestParam int Price, @RequestParam int idType, @RequestParam int idProduct){
        System.out.println(Name + " " + Price + " " + idType + " " + idProduct );
        allProductsDAO.updateProduct(Name, Price, idType, idProduct);
        return "redirect:/";
    }




}