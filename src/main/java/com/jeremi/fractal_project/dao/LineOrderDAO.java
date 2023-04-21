package com.jeremi.fractal_project.dao;

import com.jeremi.fractal_project.model.LineOrder;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LineOrderDAO extends JpaRepository<LineOrder, Integer> {
}
