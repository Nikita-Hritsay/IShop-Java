package com.courseproj.CourseProject.controllers;

import com.courseproj.CourseProject.jdbc.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class UserController {
    private final MotherboardDAOImpl motherboardDAO;
    private final AllProductsDAOImpl allProductsDAO;
    private final GraphicsCardDAOImpl graphicsCardDAO;
    private final UserDAOImpl userDAO;
    private final ReceiptDAOImpl receiptDAO;
    private final ProcessorDAOImpl processorDAO;



    @Autowired
    public UserController(MotherboardDAOImpl motherboardDAO, AllProductsDAOImpl allProductsDAO, GraphicsCardDAOImpl graphicsCardDAO,UserDAOImpl userDAO, ReceiptDAOImpl receiptDAO, ProcessorDAOImpl processorDAO) {
        this.motherboardDAO = motherboardDAO;
        this.allProductsDAO = allProductsDAO;
        this.graphicsCardDAO = graphicsCardDAO;
        this.userDAO = userDAO;
        this.receiptDAO = receiptDAO;
        this.processorDAO = processorDAO;
    }

    @GetMapping("/user")
    public String user(Model model){
        model.addAttribute("title", "User page");
        model.addAttribute("account", "аккаунт");
        model.addAttribute("categories", allProductsDAO.getAllCategories());
        return "user";
    }

    @GetMapping("/profilePage")
    public String profilePage(Model model){
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String currentUser = authentication.getName();
        model.addAttribute("users", userDAO.getCurrentUser(currentUser));
        model.addAttribute("categories", allProductsDAO.getAllCategories());
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

}
