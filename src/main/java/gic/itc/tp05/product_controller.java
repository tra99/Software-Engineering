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
    
    private static List<ProductModel> productModels = new ArrayList<>();
    
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
    private ProductModel getProductByCode(String productCode) {
        for (ProductModel product : productModels) {
            if (product.getProductCode().equals(productCode)) {
                return product;
            }
        }
        return null; 
    }

    @GetMapping("/update-product")
    public String editProduct(@RequestParam("productCode") String productCode, Model model) {
        // Fetch the product based on the product code and populate the model
        ProductModel product = getProductByCode(productCode);
        model.addAttribute("product", product);
        return "edit-product"; // Assuming "edit-product" is your edit form view
    }

    @PostMapping("/update-product")
    public String updateProduct(@RequestParam("productCode") String productCode,
                                @RequestParam("productName") String productName,
                                @RequestParam("originCountry") String originCountry,
                                @RequestParam("price") double price,
                                @RequestParam("cost") double cost,
                                @RequestParam("imageUrl") String imageUrl,
                                @RequestParam("description") String description,
                                Model model) {

        ProductModel productToUpdate = getProductByCode(productCode);

        if (productToUpdate != null) {
            // Update the product's information
            productToUpdate.setProductName(productName);
            productToUpdate.setOriginCountry(originCountry);
            productToUpdate.setPrice(price);
            productToUpdate.setCost(cost);
            productToUpdate.setImageUrl(imageUrl);
            productToUpdate.setDescription(description);
            
            model.addAttribute("message", "Product updated successfully!");
            return "redirect:/TP05/task1";
        } else {
            return "redirect:/TP05/task1";
        }
    }
}
