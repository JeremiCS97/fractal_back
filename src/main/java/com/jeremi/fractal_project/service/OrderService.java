package com.jeremi.fractal_project.service;

import com.jeremi.fractal_project.dao.LineOrderDAO;
import com.jeremi.fractal_project.dao.ProductDAO;
import com.jeremi.fractal_project.model.LineOrder;
import com.jeremi.fractal_project.model.Order;
import com.jeremi.fractal_project.model.Product;
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
    private ProductDAO productDAO;

    @Autowired
    private LineOrderService lineOrderService;

    public Order insertOrder(Order order){
        Order o = orderDAO.save(order);
        o.setOrderNumber(o.getIdOrder());
        return orderDAO.save(o);
    }

    public Order editOrder(Integer idOrder,Order order){
        Order o = orderDAO.findById(idOrder).get();
        if (order.getStatusOrder()!="Pending"){
        o.setStatusOrder(order.getStatusOrder());}
        if (order.getOrderNumber() != o.getOrderNumber()){
        o.setOrderNumber(order.getOrderNumber());}
        if (order.getDateOrder()== o.getDateOrder()){
        o.setDateOrder(order.getDateOrder());}
        if (order.getAmmountPrice() == o.getAmmountPrice()){
        o.setAmmountPrice(order.getAmmountPrice());}
        if (order.getNumberProducts() == o.getNumberProducts()){
        o.setNumberProducts(order.getNumberProducts());}
        return orderDAO.save(o);
    }

    public String deleteOrder(Integer idOrder){
        Order o = orderDAO.findById(idOrder).get();
        List<LineOrder> l = lineOrderService.findByOrderId(idOrder);
        for (int i = 0; i<l.size();i++){
            LineOrder line = l.get(i);
            Product p = productDAO.findById(line.getProduct().getIdProduct()).get();
            p.setQtyAvailable(p.getQtyAvailable()+line.getQtyLineOrder());
            productDAO.save(p);
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

    public Order updateStatusOrder(Order order){
        Order o = orderDAO.findById(order.getIdOrder()).get();
        o.setStatusOrder(order.getStatusOrder());
        return orderDAO.save(o);
    }

    public Order updateNumberOrder(Order order){
        Order o = orderDAO.findById(order.getIdOrder()).get();
        o.setOrderNumber(order.getOrderNumber());
        return orderDAO.save(o);
    }
}
