package com.courseproj.CourseProject.controllers;

import com.courseproj.CourseProject.Entity.Product;
import com.courseproj.CourseProject.jdbc.MotherboardDAOImpl;
import com.sun.tools.javac.Main;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@Controller
public class MainController {
    private final MotherboardDAOImpl motherboardDAO;

    @Autowired
    public MainController(MotherboardDAOImpl motherboardDAO) {
        this.motherboardDAO = motherboardDAO;
    }

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String home(Model model){
        model.addAttribute("title", "Home page");
        model.addAttribute("account", "войти");
        return "home";
    }

    @GetMapping("/user")
    public String user(Model model){
        model.addAttribute("title", "User page");
        model.addAttribute("account", "аккаунт");
        return "user";
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
        model.addAttribute("products", motherboardDAO.getAllMotherbaords());
        return "/motherboard";
    }

    @GetMapping("/motherboard/{idProduct}")
    public String motherboard_index(Model model, @PathVariable int idProduct){
        model.addAttribute("products", motherboardDAO.index(idProduct));
        return "/productid";
    }


}