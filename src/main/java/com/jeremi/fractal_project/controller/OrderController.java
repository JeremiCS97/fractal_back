package com.jeremi.fractal_project.controller;

import com.jeremi.fractal_project.model.LineOrder;
import com.jeremi.fractal_project.model.Order;
import com.jeremi.fractal_project.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/order")
public class OrderController {
    @Autowired
    private OrderService orderService;

    @PostMapping("/insert")
    public Order insertOrder(@RequestBody Order order){
        return orderService.insertOrder(order);
    }

    @PostMapping("/edit/{idOrder}")
    public Order editOrder(@PathVariable("idOrder") Integer idOrder, @RequestBody Order order){
        return orderService.editOrder(idOrder,order);
    }

    @PostMapping("/delete/{idOrder}")
    public String deleteOrder(@PathVariable("idOrder") Integer idOrder){
        return orderService.deleteOrder(idOrder);
    }

    @GetMapping("/findLineOrder/{idOrder}")
    public List<LineOrder> findLineOrdersById(@PathVariable("idOrder") Integer idOrder){
        return orderService.findLineOrdersById(idOrder);
    }

}
