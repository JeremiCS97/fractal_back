package com.jeremi.fractal_project.controller;

import com.jeremi.fractal_project.model.Product;
import com.jeremi.fractal_project.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/product")
public class ProductController {
    @Autowired
    private ProductService productService;

    @CrossOrigin
    @GetMapping("/findAll")
    public List<Product> findAllProduct(){
        return productService.findAllProduct();
    }

    @CrossOrigin
    @PostMapping("/insert")
    public Product insertProduct(@RequestBody Product product){
        return productService.insertProduct(product);
    }

    @CrossOrigin
    @PostMapping("/edit/{idProduct}")
    public Product editProduct(@RequestBody Product product, @PathVariable("idProduct") Integer idProduct){
        return productService.editProduct(idProduct,product);
    }

    @CrossOrigin
    @PostMapping("delete/{idProduct}")
    public String deleteProduct(@PathVariable("idProduct") Integer idProduct){
        return productService.deleteProduct(idProduct);
    }

    @CrossOrigin
    @GetMapping("findById/{idProduct}")
    public Product findProductById(@PathVariable("idProduct") Integer idProduct){
        return productService.findProductById(idProduct);
    }

    @CrossOrigin
    @GetMapping("findAllProductAvailable")
    public List<Product> findAllProductAvailable() { return productService.findAllProductAvailable(); }
}
