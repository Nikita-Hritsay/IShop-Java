package com.courseproj.CourseProject.controllers;


import com.courseproj.CourseProject.Entity.Basket;
import com.courseproj.CourseProject.Entity.Product;
import com.courseproj.CourseProject.jdbc.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class ProductController {
    private final MotherboardDAOImpl motherboardDAO;
    private final AllProductsDAOImpl allProductsDAO;
    private final GraphicsCardDAOImpl graphicsCardDAO;
    private final UserDAOImpl userDAO;
    private final ReceiptDAOImpl receiptDAO;
    private final ProcessorDAOImpl processorDAO;
    private final BasketDAOImpl basketDAO;
    private Basket basket = new Basket();


    @Autowired
    public ProductController(MotherboardDAOImpl motherboardDAO, AllProductsDAOImpl allProductsDAO, GraphicsCardDAOImpl graphicsCardDAO,UserDAOImpl userDAO, ReceiptDAOImpl receiptDAO, ProcessorDAOImpl processorDAO, BasketDAOImpl basketDAO) {
        this.motherboardDAO = motherboardDAO;
        this.allProductsDAO = allProductsDAO;
        this.graphicsCardDAO = graphicsCardDAO;
        this.userDAO = userDAO;
        this.receiptDAO = receiptDAO;
        this.processorDAO = processorDAO;
        this.basketDAO = basketDAO;
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

        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        basketDAO.addToBasket_has_product(authentication.getName(), product, Integer.parseInt(amount));

        return "redirect:/";
    }

    @GetMapping("/addProduct")
    public String addProduct(Model model){
        return "addProduct";
    }

    @PostMapping("/addProduct")
    public String addProductPost(Model model, @RequestParam String name, @RequestParam int price, @RequestParam int Img_idImg, @RequestParam int idType, @RequestParam String description){
        allProductsDAO.addProduct(name, price, Img_idImg, idType, description);
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
    public String updateProductIdPost(Model model, @RequestParam String Name, @RequestParam int Price, @RequestParam String Description, @RequestParam int idType, @RequestParam int idProduct){
        allProductsDAO.updateProduct(Name, Price, idType, idProduct, Description);
        return "redirect:/";
    }

}
