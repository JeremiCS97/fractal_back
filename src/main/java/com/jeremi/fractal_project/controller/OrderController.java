package com.jeremi.fractal_project.controller;


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

    @CrossOrigin
    @PostMapping("/insert")
    public Order insertOrder(@RequestBody Order order){
        return orderService.insertOrder(order);
    }

    @CrossOrigin
    @PostMapping("/edit/{idOrder}")
    public Order editOrder(@PathVariable("idOrder") Integer idOrder, @RequestBody Order order){
        return orderService.editOrder(idOrder,order);
    }
    @CrossOrigin
    @PostMapping("/delete/{idOrder}")
    public String deleteOrder(@PathVariable("idOrder") Integer idOrder){
        return orderService.deleteOrder(idOrder);
    }

    @CrossOrigin
    @GetMapping("/findById/{idOrder}")
    public Order findById(@PathVariable("idOrder") Integer idOrder){
        return orderService.findById(idOrder);
    }

    @CrossOrigin
    @GetMapping("/findAllOrder")
    public List<Order> findAllOrder(){
        return orderService.findAllOrder();
    }

    @CrossOrigin
    @GetMapping("/findNumberProductsOrder/{idOrder}")
    public Integer findNumberProductsOrder(@PathVariable("idOrder") Integer idOrder){
        return orderService.findNumberProductsOrder(idOrder);
    }

    @CrossOrigin
    @GetMapping("/findAmmountPriceOrder/{idOrder}")
    public Float findAmmountPriceOrder(@PathVariable("idOrder") Integer idOrder){
        return orderService.findAmmountPriceOrder(idOrder);
    }

}
