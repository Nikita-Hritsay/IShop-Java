package com.courseproj.CourseProject.controllers;

import com.courseproj.CourseProject.Entity.Product;
import com.courseproj.CourseProject.jdbc.*;
import com.sun.tools.javac.Main;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;


@Controller
public class MainController {
    private final MotherboardDAOImpl motherboardDAO;
    private final AllProductsDAOImpl allProductsDAO;
    private final GraphicsCardDAOImpl graphicsCardDAO;
    private final UserDAOImpl userDAO;


    @Autowired
    public MainController(MotherboardDAOImpl motherboardDAO, AllProductsDAOImpl allProductsDAO, GraphicsCardDAOImpl graphicsCardDAO,UserDAOImpl userDAO) {
        this.motherboardDAO = motherboardDAO;
        this.allProductsDAO = allProductsDAO;
        this.graphicsCardDAO = graphicsCardDAO;
        this.userDAO = userDAO;
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

    @GetMapping("/admin")
    public String admin(Model model){
        model.addAttribute("title", "Admin page");
        model.addAttribute("account", "аккаунт");
        return "admin";
    }

    @GetMapping("/login")
    public String getLogin(@RequestParam(value = "error", required = false) String error,
                           @RequestParam(value = "logout", required = false) String logout,
                           Model model){
        model.addAttribute("error", error != null);
        model.addAttribute("logout", logout != null);
        return "login";
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

    @GetMapping("/graphicsCard")
    public String graphicsCard_all(Model model){
        model.addAttribute("products", graphicsCardDAO.getAllGraphicsCards());
        return "/motherboard";
    }







}