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
        Integer orderId = lineOrder.getOrder().getIdOrder();
        Order o = orderDAO.findById(orderId).get();
        Integer numberProducts = o.getNumberProducts();
        Float ammountPrice = o.getAmmountPrice();
        if (numberProducts == null) {
            numberProducts = 0;
        }
        if (ammountPrice == null) {
            ammountPrice = 0.0F;
        }
        o.setNumberProducts(lineOrder.getQtyLineOrder() + numberProducts);
        o.setAmmountPrice(lineOrder.getPriceLineOrder() +ammountPrice);
        orderDAO.save(o);
        return lineorderDAO.save(lineOrder);
    }

    public LineOrder editLineOrder(Integer idLineOrder, LineOrder lineOrder){
        LineOrder l = lineorderDAO.findById(idLineOrder).get();

        Integer orderId = l.getOrder().getIdOrder();
        Order o = orderDAO.findById(orderId).get();
        Integer numberProducts = o.getNumberProducts();
        Float ammountPrice = o.getAmmountPrice();
        if (numberProducts == null) {
            numberProducts = 0;
        }
        if (ammountPrice == null) {
            ammountPrice = 0.0F;
        }
        o.setNumberProducts(numberProducts - l.getQtyLineOrder() + lineOrder.getQtyLineOrder());
        o.setAmmountPrice(ammountPrice - l.getPriceLineOrder()  + lineOrder.getPriceLineOrder() );
        orderDAO.save(o);
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
        Integer orderId = l.getOrder().getIdOrder();
        Order o = orderDAO.findById(orderId).get();
        Integer numberProducts = o.getNumberProducts();
        Float ammountPrice = o.getAmmountPrice();
        if (numberProducts == null) {
            numberProducts = 0;
        }
        if (ammountPrice == null) {
            ammountPrice = 0.0F;
        }
        o.setNumberProducts(numberProducts - l.getQtyLineOrder());
        o.setAmmountPrice(ammountPrice - l.getPriceLineOrder());
        orderDAO.save(o);
        lineorderDAO.delete(l);
        return "Se eliminó la linea correctamente";
    }

    public List<LineOrder> findByOrderId(Integer idOrder){
        Order o = orderDAO.findById(idOrder).get();
        return lineorderDAO.findAllByOrder(o);
    }

}
