package com.jeremi.fractal_project.controller;

import com.jeremi.fractal_project.model.LineOrder;
import com.jeremi.fractal_project.service.LineOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/lineorder")
public class LineOrderController {
    @Autowired
    private LineOrderService lineorderService;

    @PostMapping("/insert")
    public LineOrder insertLineOrder(@RequestBody LineOrder lineOrder){
        return lineorderService.insertLineOrder(lineOrder);
    }

    @PostMapping("/edit/{idLineOrder}")
    public LineOrder editLineOrder(@PathVariable("idLineOrder") Integer idLineOrder, @RequestBody LineOrder lineOrder){
        return lineorderService.editLineOrder(idLineOrder,lineOrder);
    }

    @PostMapping("/delete/{idLineOrder}")
    public String deleteLineOrder(@PathVariable("idLineOrder") Integer idLineOrder){
        return lineorderService.deleteLineOrder(idLineOrder);
    }

    @GetMapping("/findByOrderId/{idOrder}")
    public List<LineOrder> findByOrderId(@PathVariable("idOrder") Integer idOrder){
        return lineorderService.findByOrderId(idOrder);
    }

}
