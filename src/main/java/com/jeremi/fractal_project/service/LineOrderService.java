package com.jeremi.fractal_project.service;

import com.jeremi.fractal_project.dao.OrderDAO;
import com.jeremi.fractal_project.dao.ProductDAO;
import com.jeremi.fractal_project.model.LineOrder;
import com.jeremi.fractal_project.model.Order;
import com.jeremi.fractal_project.model.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.jeremi.fractal_project.dao.LineOrderDAO;

import java.util.List;

@Service
public class LineOrderService {
    @Autowired
    private LineOrderDAO lineorderDAO;

    @Autowired
    private ProductDAO productDAO;

    @Autowired
    private OrderDAO orderDAO;

    public LineOrder insertLineOrder(LineOrder lineOrder){
        return lineorderDAO.save(lineOrder);
    }

    public LineOrder editLineOrder(Integer idLineOrder, LineOrder lineOrder){
        LineOrder l = lineorderDAO.findById(idLineOrder).get();
        l.setPriceLineOrder(lineOrder.getPriceLineOrder());
        l.setQtyLineOrder(lineOrder.getQtyLineOrder());
        Product p = new Product();
        p.setNameProduct(lineOrder.getProduct().getNameProduct());
        p.setQtyAvailable(lineOrder.getProduct().getQtyAvailable());
        p.setUnitPrice(lineOrder.getProduct().getUnitPrice());
        p.setIdProduct(lineOrder.getProduct().getIdProduct());
        l.setProduct(p);
        return lineorderDAO.save(l);

    }

    public String deleteLineOrder(Integer idLineOrder){
        LineOrder l = lineorderDAO.findById(idLineOrder).get();
        //Order o = orderDAO.getById(l.getOrder().getIdOrder());
        /*List<LineOrder> list_Order = o.getLineOrders();
        list_Order.remove(l);
        o.setLineOrders(list_Order);
        */
        //orderDAO.save(o);
        lineorderDAO.delete(l);
        return "Se eliminó la linea correctamente";
    }

    public List<LineOrder> findByOrderId(Integer idOrder){
        Order o = orderDAO.findById(idOrder).get();
        return lineorderDAO.findAllByOrder(o);
    }

}
