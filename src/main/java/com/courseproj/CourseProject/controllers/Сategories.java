package com.courseproj.CourseProject.controllers;


import com.courseproj.CourseProject.Entity.Img;
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
        return "redirect:/basket/0";
    }


    // Поиск по категории через конкретную ссылку
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
        return "redirect:/basket/0";
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
        return "redirect:/basket/0";
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
        return "redirect:/basket/0";
    }

    // Поиск через категорию
    @GetMapping("/byCategory/{idCategory}")
    public String byCategory(Model model, @PathVariable int idCategory){
        model.addAttribute("categories", allProductsDAO.getAllCategories());
        model.addAttribute("products", allProductsDAO.getByCategory(idCategory, null));
        return "byCategory";
    }

    @PostMapping("byCategory/{idCategory}")
    public String byCategoryPost(Model model, @RequestParam int idProduct){
        Product product = allProductsDAO.index(idProduct);
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        basketDAO.addToBasket_has_product(authentication.getName(), product, 1);
        return "redirect:/basket/0";
    }

    @GetMapping("/category")
    public String category(Model model){
        model.addAttribute("categories", allProductsDAO.getAllCategories());
        return "categories";
    }

    @GetMapping("/category/{idCategory}")
    public String categoryid(Model model, @PathVariable int idCategory){
        model.addAttribute("categories", allProductsDAO.getAllCategories());
        model.addAttribute("categories", allProductsDAO.getCategoryByIndex(idCategory));
        return "categoryid";
    }

    @PostMapping("/category/{idCategory}")
    public String getByCategoryPOST(Model model, @RequestParam int idCategory, @RequestParam String name){
        allProductsDAO.updateCategory(idCategory, name);
        return "redirect:/";
    }

    @GetMapping("/addCategory")
    public String addCategory(Model model){
        model.addAttribute("categories", allProductsDAO.getAllCategories());
        return "addCategory";
    }

    @PostMapping("/addCategory")
    public String addCategoryPost(Model model, String name){
        allProductsDAO.addCategory(name);
        return "redirect:/";
    }

    @GetMapping("/deleteCategory/{idCategory}")
    public String deleteCategoryId(Model model, @PathVariable int idCategory){
        model.addAttribute("categories", allProductsDAO.getAllCategories());
        model.addAttribute("categoryId", allProductsDAO.getCategoryByIndex(idCategory));
        return "deleteCategoryId";
    }

    @PostMapping("/deleteCategory/{idCategory}")
    public String deleteCategoryIdPost(Model model, @RequestParam int idCategory){
        allProductsDAO.deleteCategory(idCategory);
        return "redirect:/";
    }
}
