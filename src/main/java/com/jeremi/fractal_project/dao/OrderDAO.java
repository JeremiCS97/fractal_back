package com.jeremi.fractal_project.dao;

import com.jeremi.fractal_project.model.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderDAO extends JpaRepository<Order, Integer> {
}
