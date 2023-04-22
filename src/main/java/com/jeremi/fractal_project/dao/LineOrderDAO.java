package com.jeremi.fractal_project.dao;

import com.jeremi.fractal_project.model.LineOrder;
import com.jeremi.fractal_project.model.Order;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface LineOrderDAO extends JpaRepository<LineOrder, Integer> {
    List<LineOrder> findAllByOrder(Order order);
}
