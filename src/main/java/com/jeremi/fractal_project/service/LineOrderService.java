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
        Integer productId = lineOrder.getProduct().getIdProduct();
        Order o = orderDAO.findById(orderId).get();
        Product p = productDAO.findById(productId).get();
        p.setQtyAvailable(p.getQtyAvailable()-lineOrder.getQtyLineOrder());
        productDAO.save(p);
        lineOrder.setPriceLineOrder((lineOrder.getQtyLineOrder()*p.getUnitPrice()));
        lineOrder.setProduct(p);
        Integer numberProducts = o.getNumberProducts();
        Float ammountPrice = o.getAmmountPrice();
        if (numberProducts == null) {
            numberProducts = 0;
        }
        if (ammountPrice == null) {
            ammountPrice = 0.0F;
        }
        o.setNumberProducts(lineOrder.getQtyLineOrder() + numberProducts);
        o.setAmmountPrice((lineOrder.getQtyLineOrder()*p.getUnitPrice()) +ammountPrice);
        orderDAO.save(o);
        lineOrder.setOrder(o);
        return lineorderDAO.save(lineOrder);
    }

    public LineOrder editLineOrder(Integer idLineOrder, LineOrder lineOrder){
        LineOrder l = lineorderDAO.findById(idLineOrder).get();
        Integer orderId = l.getOrder().getIdOrder();
        Order o = orderDAO.findById(orderId).get();
        Integer idProduct = lineOrder.getProduct().getIdProduct();
        Product p = productDAO.findById(idProduct).get();
        p.setQtyAvailable(p.getQtyAvailable()+l.getQtyLineOrder()-lineOrder.getQtyLineOrder());
        productDAO.save(p);
        l.setProduct(p);
        Integer numberProducts = o.getNumberProducts();
        Float ammountPrice = o.getAmmountPrice();
        if (numberProducts == null) {
            numberProducts = 0;
        }
        if (ammountPrice == null) {
            ammountPrice = 0.0F;
        }
        o.setNumberProducts(numberProducts - l.getQtyLineOrder() + lineOrder.getQtyLineOrder());
        o.setAmmountPrice(ammountPrice - l.getPriceLineOrder()  + lineOrder.getQtyLineOrder()*p.getUnitPrice());
        orderDAO.save(o);
        l.setPriceLineOrder(lineOrder.getQtyLineOrder()*p.getUnitPrice());
        l.setQtyLineOrder(lineOrder.getQtyLineOrder());
        return lineorderDAO.save(l);

    }

    public String deleteLineOrder(Integer idLineOrder){
        LineOrder l = lineorderDAO.findById(idLineOrder).get();
        Integer orderId = l.getOrder().getIdOrder();
        Order o = orderDAO.findById(orderId).get();
        Product p = productDAO.findById(l.getProduct().getIdProduct()).get();
        p.setQtyAvailable(p.getQtyAvailable()+l.getQtyLineOrder());
        productDAO.save(p);
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
