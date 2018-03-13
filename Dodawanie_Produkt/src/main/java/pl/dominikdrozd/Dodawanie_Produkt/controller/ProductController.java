package pl.dominikdrozd.Dodawanie_Produkt.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import pl.dominikdrozd.Dodawanie_Produkt.model.Comment;
import pl.dominikdrozd.Dodawanie_Produkt.model.Product;
import pl.dominikdrozd.Dodawanie_Produkt.repository.CategoryRepository;
import pl.dominikdrozd.Dodawanie_Produkt.repository.ProductRepository;

import java.util.Optional;

@Controller
public class ProductController {

    @Autowired
    ProductRepository productRepository;

    @Autowired
    CategoryRepository categoryRepository;



    @GetMapping("/products/add")
    public String add(ModelMap modelMap) {
        modelMap.addAttribute("categories", categoryRepository.findAll());
        modelMap.addAttribute("product", new Product());
        return "/products/add";
    }
    @ResponseBody
    @PostMapping("/products")
    public String create(@ModelAttribute Product product) {
        productRepository.save(product);
        return "created";
    }

    @GetMapping("/products")
    public String listProducts(ModelMap modelMap) {
        modelMap.addAttribute("products", productRepository.findAll());
        return "/products/index";
    }

    @GetMapping("products/{productId}")
    public String product(@PathVariable Long productId, ModelMap modelMap) {

        Optional<Product> productOptional = productRepository.findById(productId);
        productOptional.ifPresent(product -> {
            modelMap.addAttribute("product", product);
            modelMap.addAttribute("comments", product.getComments());
        });

        return "products/show";
    }

    @PostMapping("/products/addComment")
    public String addComment(@RequestParam String commentBody,
                             @RequestParam Long productId) {


        Optional<Product> productOptional = productRepository.findById(productId);

        productOptional.ifPresent(
                product -> {
                    Comment comment = new Comment();
                    comment.setComment(commentBody);
                    product.addComment(comment);
                    productRepository.save(product);
                }
        );

        return "redirect:/products/" + productId;
    }


}
