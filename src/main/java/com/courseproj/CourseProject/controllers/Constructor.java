package com.courseproj.CourseProject.controllers;

import com.courseproj.CourseProject.Entity.Product;
import com.courseproj.CourseProject.Entity.Type;
import com.courseproj.CourseProject.jdbc.AllProductsDAOImpl;
import com.courseproj.CourseProject.jdbc.BasketDAOImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class Constructor {

    private final AllProductsDAOImpl allProductsDAO;
    private final BasketDAOImpl basketDAO;

    private final List<Type> categories;

    @Autowired
    public Constructor(AllProductsDAOImpl allProductsDAO, BasketDAOImpl basketDAO) {
        this.allProductsDAO = allProductsDAO;
        this.categories = allProductsDAO.getAllCategories();
        this.basketDAO = basketDAO;
    }

    @GetMapping("/constructor/{idCategory}")
    public String constructor(Model model, @PathVariable Integer idCategory) {
        if(idCategory == 0){
            Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
            basketDAO.deleteBasket(authentication.getName());
        }
        model.addAttribute("categories", allProductsDAO.getAllCategories());
        model.addAttribute("products", allProductsDAO.getByCategory(categories.get(idCategory).getId()));
        return "constructor";
    }

    @PostMapping("/constructor/{idCategory}")
    public String constructorPost(Model model, @PathVariable String idCategory, @RequestParam String idProduct) {
        Product product = allProductsDAO.index(Integer.parseInt(idProduct));
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        basketDAO.addToBasket_has_product(authentication.getName(), product, 1);
        int index = categories.indexOf(categories.stream().filter(el->el.getId() == product.getIdType()).findFirst().orElse(null));
        if(++index == categories.size()){
            return "redirect:/basket";
        }
        model.addAttribute("categories", allProductsDAO.getAllCategories());
        model.addAttribute("products", allProductsDAO.getByCategory(categories.get(index).getId()));
        return "redirect:/constructor/" + index;
    }

}
