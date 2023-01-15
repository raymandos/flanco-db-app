package com.lungu.flancodb.controller;

import com.lungu.flancodb.entity.Branch;
import com.lungu.flancodb.entity.Product;
import com.lungu.flancodb.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import javax.persistence.EntityNotFoundException;

@Controller
@RequiredArgsConstructor
public class ProductController {

    final ProductService productService;
    @GetMapping("/sales/product/delete/{id}")
    public String deleteProduct(@PathVariable("id") String id) throws EntityNotFoundException {

        productService.deleteProductById(id);
        return "redirect:/sales";
    }

    @PostMapping("/sales/product/add")
    public String addProduct(@ModelAttribute("branch") final Product product) {
        productService.saveProduct(product);
        return "redirect:/sales";
    }

    @PostMapping("/sales/product/update/{id}")
    public String updateBranch(@ModelAttribute("product") Product product, @PathVariable("id") String id) throws EntityNotFoundException {
        productService.saveProduct(product);
        return "redirect:/sales";
    }
}
