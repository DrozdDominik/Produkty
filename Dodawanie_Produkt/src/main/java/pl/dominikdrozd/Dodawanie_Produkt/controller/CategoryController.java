package pl.dominikdrozd.Dodawanie_Produkt.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import pl.dominikdrozd.Dodawanie_Produkt.model.Category;
import pl.dominikdrozd.Dodawanie_Produkt.repository.CategoryRepository;

@Controller
public class CategoryController {


    @Autowired
    private CategoryRepository categoryRepository;


    @GetMapping("/categories/new")
    public String add(){
        return "categories/add";
    }

    @PostMapping("/categories")
    public String getCategories(@ModelAttribute Category category){
        categoryRepository.save(category);
        return "redirect:/categories";
    }

    @GetMapping("/categories")
    public String index(ModelMap modelMap){
        modelMap.put("categories",categoryRepository.findAll());
        return "categories/index";
    }

}
