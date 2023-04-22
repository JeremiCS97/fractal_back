package com.jeremi.fractal_project.service;

import com.jeremi.fractal_project.dao.LineOrderDAO;
import com.jeremi.fractal_project.model.LineOrder;
import com.jeremi.fractal_project.model.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.jeremi.fractal_project.dao.OrderDAO;

import java.util.List;

@Service
public class OrderService {
    @Autowired
    private OrderDAO orderDAO;

    @Autowired
    private LineOrderDAO lineorderDAO;

    @Autowired
    private LineOrderService lineOrderService;

    public Order insertOrder(Order order){
        return orderDAO.save(order);
    }

    public Order editOrder(Integer idOrder,Order order){
        Order o = orderDAO.findById(idOrder).get();
        o.setStatusOrder(order.getStatusOrder());
        o.setOrderNumber(order.getOrderNumber());
        o.setDateOrder(order.getDateOrder());
        o.setAmmountPrice(order.getAmmountPrice());
        o.setNumberProducts(order.getNumberProducts());
        return orderDAO.save(o);
    }

    public String deleteOrder(Integer idOrder){
        Order o = orderDAO.findById(idOrder).get();
        List<LineOrder> l = lineOrderService.findByOrderId(idOrder);
        for (int i = 0; i<l.size();i++){
            LineOrder line = l.get(i);
            lineorderDAO.delete(line);
        }
        orderDAO.delete(o);
        return "La orden ha sido borrada correctamente";
    }

    public Order findById(Integer idOrder){
        return orderDAO.findById(idOrder).get();
    }

    public List<Order> findAllOrder(){
        return orderDAO.findAll();
    }

    /*public Integer findNumberProductsOrder(Integer idOrder){
        Order o = orderDAO.findById(idOrder).get();
        List<LineOrder> l = lineOrderService.findByOrderId(idOrder);
        Integer cant = 0;
        for (int i = 0; i<l.size();i++){
            cant++;
        }
        return cant;
    }

    public Float findAmmountPriceOrder(Integer idOrder){
        Order o = orderDAO.findById(idOrder).get();
        List<LineOrder> l = lineOrderService.findByOrderId(idOrder);
        Float cant = 0.0F;
        for (int i = 0; i<l.size();i++){
            cant = cant + l.get(i).getPriceLineOrder();
        }
        return cant;
    }
    */
}
