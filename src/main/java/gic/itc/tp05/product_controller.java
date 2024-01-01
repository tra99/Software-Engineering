package gic.itc.tp05;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import models.ProductModel;

@Controller

public class product_controller {

    @GetMapping("/TP05/task1")
    public String task1(Model model) {
        
        List<ProductModel>productModels=new ArrayList<>();

        model.addAttribute("productModels", productModels);
        return "task1";
    }

    @GetMapping("/add-product")
    public String addProductPage() {
        return "add-product"; 
    }

    @PostMapping("/TP05/task1")
    public String saveProduct(@RequestParam String productCode,
                              @RequestParam String productName,
                              @RequestParam String originCountry,
                              @RequestParam double price,
                              @RequestParam double cost,
                              @RequestParam String imageUrl,
                              @RequestParam String description,
                              Model model) {

        model.addAttribute("message", "Product added successfully!");
        return "redirect:/TP05/task1";
    }
}
