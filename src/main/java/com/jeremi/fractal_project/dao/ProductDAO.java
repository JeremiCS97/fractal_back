package com.jeremi.fractal_project.dao;

import com.jeremi.fractal_project.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductDAO extends JpaRepository<Product, Integer> {
}
