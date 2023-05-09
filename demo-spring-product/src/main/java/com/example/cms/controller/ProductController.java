package com.example.cms.controller;

import com.example.cms.model.Product;
import com.example.cms.service.IProductService;
import com.example.cms.service.ProductServiceImpl;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.annotation.processing.Messager;
import java.util.List;

@Controller
@RequestMapping("/product")
public class ProductController {
    private final IProductService productService = new ProductServiceImpl();

    @GetMapping("")
    public String home(Model model){
        List<Product> productList = productService.findAll();
        model.addAttribute("products",productList);
        return "/index";
    }

    @GetMapping("/create")
    public String creat(Model model){
        model.addAttribute("product",new Product());
        return "/create";
    }
    @PostMapping("/save")
    public String save(Product product){
        product.setId((int) (Math.random() * 100000));
        productService.save(product);
        return "redirect:/product";
    }

    @GetMapping("/find/{id}")
    public String find(@PathVariable("id") int id,Model model){
        model.addAttribute("product",productService.findById(id));
        return "/view";
    }

    @GetMapping("/edit/{id}")
    public String edit(@PathVariable("id") int id,Model model){
        Product product = productService.findById(id);
        model.addAttribute("product",product);
        return "/update";
    }
    @PostMapping("/update")
    public String saveNew(Product product){
         productService.update(product.getId(),new Product());
         return "redirect:/product";
    }

    @GetMapping("/delete/{id}")
    public String remove(@PathVariable("id") int id,Model model){
        model.addAttribute("product",productService.findById(id));
        return "/delete";
    }

    @PostMapping("delete")
    public String remove(Product product, RedirectAttributes attributes) {
        productService.remove(product.getId());
        attributes.addFlashAttribute("messager","remove successfully");
        return "redirect:/product";
    }

    @GetMapping("/search")
    public String search(@RequestParam("name") String name, Model model) {
        Product product = productService.search(name);
        model.addAttribute("product", product);
        return "/search";
    }
}
