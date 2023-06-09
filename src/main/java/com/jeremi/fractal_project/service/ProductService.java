package com.jeremi.fractal_project.service;

import com.jeremi.fractal_project.model.LineOrder;
import com.jeremi.fractal_project.model.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.jeremi.fractal_project.dao.ProductDAO;

import java.util.ArrayList;
import java.util.List;

@Service
public class ProductService {
    @Autowired
    private ProductDAO productDAO;

    public List<Product> findAllProduct(){
        return productDAO.findAll();
    }
    public Product insertProduct(Product product){
        return productDAO.save(product);
    }

    public Product editProduct(Integer idProduct,Product product){
        Product p = productDAO.findById(idProduct).get();
        p.setNameProduct(product.getNameProduct());
        p.setQtyAvailable(product.getQtyAvailable());
        p.setUnitPrice(product.getUnitPrice());
        return productDAO.save(p);
    }

    public String deleteProduct(Integer idProduct){
        Product p = productDAO.findById(idProduct).get();
        productDAO.delete(p);
        return "El producto se eliminó correctamente";
    }

    public Product findProductById(Integer idProduct){
        return productDAO.findById(idProduct).get();
    }
    
    public List<Product> findAllProductAvailable(){
        List<Product> l = productDAO.findAll();
        List<Product> newL = new ArrayList<>();
        for (int i = 0; i<l.size();i++){
            Product p = l.get(i);
            if(p.getQtyAvailable()>0){
                newL.add(p);
            }
        }
        return newL;
    }
}
