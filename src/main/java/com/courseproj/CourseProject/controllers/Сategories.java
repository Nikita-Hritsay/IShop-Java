package com.courseproj.CourseProject.controllers;


import com.courseproj.CourseProject.Entity.Basket;
import com.courseproj.CourseProject.jdbc.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class Сategories {
    private final MotherboardDAOImpl motherboardDAO;
    private final AllProductsDAOImpl allProductsDAO;
    private final GraphicsCardDAOImpl graphicsCardDAO;
    private final UserDAOImpl userDAO;
    private final ReceiptDAOImpl receiptDAO;
    private final ProcessorDAOImpl processorDAO;
    private Basket basket = new Basket();


    @Autowired
    public Сategories(MotherboardDAOImpl motherboardDAO, AllProductsDAOImpl allProductsDAO, GraphicsCardDAOImpl graphicsCardDAO,UserDAOImpl userDAO, ReceiptDAOImpl receiptDAO, ProcessorDAOImpl processorDAO) {
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


    @GetMapping("/motherboard")
    public String motherboard_all(Model model){
        model.addAttribute("products", motherboardDAO.getAllMotherboards());
        return "/motherboard";
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




}
