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
    
    private static List<ProductModel> productModels = new ArrayList<>(); // Static list to hold products
    
    @GetMapping("/TP05/task1")
    public String task1(Model model) {
        model.addAttribute("productModels", productModels);
        return "task1";
    }

    @GetMapping("/add-product")
    public String addProductPage() {
        return "add-product"; 
    }

    @PostMapping("/save-product")
    public String saveProduct(@RequestParam("productCode") String productCode,
                              @RequestParam("productName") String productName,
                              @RequestParam("originCountry") String originCountry,
                              @RequestParam("price") double price,
                              @RequestParam("cost") double cost,
                              @RequestParam("imageUrl") String imageUrl,
                              @RequestParam("description") String description,
                              Model model) {

        ProductModel newProduct = new ProductModel(productCode, productName, originCountry, price, cost, imageUrl, description);
        productModels.add(newProduct);
        
        model.addAttribute("message", "Product added successfully!");
        return "redirect:/TP05/task1"; 
    }
}


// @Controller

// public class product_controller {

//     @GetMapping("/TP05/task1")
//     public String task1(Model model) {
        
//         // List<ProductModel>productModels=new ArrayList<>();
//         // productModels.add(new ProductModel("P101", "Apple", "USA", 10, 10, "localImage.png", "Best organic apple from USA"));

//         model.addAttribute("productModels", productModels);
//         return "task1";
//     }

//     @GetMapping("/add-product")
//     public String addProductPage() {
//         return "add-product"; 
//     }

//     @PostMapping("/save-product")
//     public String saveProduct(@RequestParam("productCode") String productCode,
//                           @RequestParam("productName") String productName,
//                           @RequestParam("originCountry") String originCountry,
//                           @RequestParam("price") double price,
//                           @RequestParam("cost") double cost,
//                           @RequestParam("imageUrl") String imageUrl,
//                           @RequestParam("description") String description,
//                           Model model) {


//         model.addAttribute("message", "Product added successfully!");
//         return "redirect:/TP05/task1"; 
//     }
// }
