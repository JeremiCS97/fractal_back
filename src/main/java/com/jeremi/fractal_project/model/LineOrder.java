package com.jeremi.fractal_project.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.JoinColumn;
import org.hibernate.annotations.Fetch;

@Entity
public class LineOrder {

    @Id
    @Column (name = "idLineOrder")
    @GeneratedValue()
    private Integer idLineOrder;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name ="idProduct")
    private Product product;

    @ManyToOne(fetch= FetchType.EAGER)
    @JoinColumn(name = "idOrder")
    private Order order;

    @Column (name ="qtyLineOrder")
    private Integer qtyLineOrder;

    @Column (name = "priceLineOrder")
    private Float priceLineOrder;

    public LineOrder() {
    }

    public LineOrder(Integer idLineOrder, Product product, Order order, Integer qtyLineOrder, Float priceLineOrder, Order order1) {
        this.idLineOrder = idLineOrder;
        this.product = product;
        this.order = order;
        this.qtyLineOrder = qtyLineOrder;
        this.priceLineOrder = priceLineOrder;
    }

    public Integer getIdLineOrder() {
        return idLineOrder;
    }

    public void setIdLineOrder(Integer idLineOrder) {
        this.idLineOrder = idLineOrder;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public Order getOrder() {
        return order;
    }

    public void setOrder(Order order) {
        this.order = order;
    }

    public Integer getQtyLineOrder() {
        return qtyLineOrder;
    }

    public void setQtyLineOrder(Integer qtyLineOrder) {
        this.qtyLineOrder = qtyLineOrder;
    }

    public Float getPriceLineOrder() {
        return priceLineOrder;
    }

    public void setPriceLineOrder(Float priceLineOrder) {
        this.priceLineOrder = priceLineOrder;
    }
}
