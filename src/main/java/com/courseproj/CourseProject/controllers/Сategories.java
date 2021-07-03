package com.courseproj.CourseProject.controllers;


import com.courseproj.CourseProject.Entity.Basket;
import com.courseproj.CourseProject.Entity.Product;
import com.courseproj.CourseProject.jdbc.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class Сategories {
    private final MotherboardDAOImpl motherboardDAO;
    private final AllProductsDAOImpl allProductsDAO;
    private final GraphicsCardDAOImpl graphicsCardDAO;
    private final UserDAOImpl userDAO;
    private final ReceiptDAOImpl receiptDAO;
    private final ProcessorDAOImpl processorDAO;
    private final BasketDAOImpl basketDAO;

    private Basket basket = new Basket();


    @Autowired
    public Сategories(MotherboardDAOImpl motherboardDAO, AllProductsDAOImpl allProductsDAO, GraphicsCardDAOImpl graphicsCardDAO,UserDAOImpl userDAO, ReceiptDAOImpl receiptDAO, ProcessorDAOImpl processorDAO, BasketDAOImpl basketDAO) {
        this.motherboardDAO = motherboardDAO;
        this.allProductsDAO = allProductsDAO;
        this.graphicsCardDAO = graphicsCardDAO;
        this.userDAO = userDAO;
        this.receiptDAO = receiptDAO;
        this.processorDAO = processorDAO;
        this.basketDAO = basketDAO;
    }

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String home(Model model){
        model.addAttribute("title", "Home page");
        model.addAttribute("products", allProductsDAO.getAllProducts());
        model.addAttribute("categories", allProductsDAO.getAllCategories());
        return "home";
    }

    @PostMapping("/")
    public String homePOST(Model model, @RequestParam int idProduct){
        Product product = allProductsDAO.index(idProduct);
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        basketDAO.addToBasket_has_product(authentication.getName(), product, 1);
        return "redirect:/";
    }

    @GetMapping("/motherboard")
    public String motherboard_all(Model model){
        model.addAttribute("categories", allProductsDAO.getAllCategories());
        model.addAttribute("products", motherboardDAO.getAllMotherboards());
        return "/motherboard";
    }

    @PostMapping("/motherboard")
    public String motherboard_allPOST(Model model, @RequestParam int idProduct){
        Product product = allProductsDAO.index(idProduct);
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        basketDAO.addToBasket_has_product(authentication.getName(), product, 1);
        return "redirect:/";
    }

    @GetMapping("/graphicsCard")
    public String graphicsCard_all(Model model){
        model.addAttribute("categories", allProductsDAO.getAllCategories());
        model.addAttribute("products", graphicsCardDAO.getAllGraphicsCards());
        return "/motherboard";
    }

    @PostMapping("/graphicsCard")
    public String graphicsCard_allPOST(Model model, @RequestParam int idProduct){
        Product product = allProductsDAO.index(idProduct);
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        basketDAO.addToBasket_has_product(authentication.getName(), product, 1);
        return "redirect:/";
    }

    @GetMapping("/processor")
    public String processor_all(Model model){
        model.addAttribute("categories", allProductsDAO.getAllCategories());
        model.addAttribute("products", processorDAO.getAllProcessors());
        return "/processors";
    }

    @PostMapping("/processor")
    public String processor_allPOST(Model model, @RequestParam int idProduct){
        Product product = allProductsDAO.index(idProduct);
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        basketDAO.addToBasket_has_product(authentication.getName(), product, 1);
        return "redirect:/";
    }

    @GetMapping("/category/{name}")
    public String getByCategory(Model model, @RequestParam String name){
        model.addAttribute("categories", allProductsDAO.getAllCategories());
        model.addAttribute("products", allProductsDAO.getByCategory(name));
        return "byCategory";
    }

    @PostMapping("/category/{name}")
    public String getByCategoryPOST(Model model, @RequestParam int idProduct){
        Product product = allProductsDAO.index(idProduct);
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        basketDAO.addToBasket_has_product(authentication.getName(), product, 1);
        return "redirect:/";
    }

}
