package com.jeremi.fractal_project.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;


import java.util.Date;
import java.util.List;

@Entity
@Table(name = "orderv")
public class Order {

    @Id
    @Column (name="idOrder")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idOrder;


    @Column (name = "orderNumber")
    private Integer orderNumber;

    @Column (name = "dateOrder")
    private Date dateOrder;

    @Column (name ="statusOrder")
    private String statusOrder;

    @JsonIgnore
    @OneToMany (fetch = FetchType.EAGER)
    //@LazyCollection(LazyCollectionOption.FALSE)
    @JoinColumn(name = "idLineOrder")
    private  List<LineOrder> LineOrders;

    public Order() {
    }

    public Order(Integer idOrder, Integer orderNumber, Date dateOrder, String statusOrder, List<LineOrder> lineOrders) {
        this.idOrder = idOrder;
        this.orderNumber = orderNumber;
        this.dateOrder = dateOrder;
        this.statusOrder = statusOrder;
        LineOrders = lineOrders;
    }

    public Integer getIdOrder() {
        return idOrder;
    }

    public void setIdOrder(Integer idOrder) {
        this.idOrder = idOrder;
    }

    public Integer getOrderNumber() {
        return orderNumber;
    }

    public void setOrderNumber(Integer orderNumber) {
        this.orderNumber = orderNumber;
    }

    public Date getDateOrder() {
        return dateOrder;
    }

    public void setDateOrder(Date dateOrder) {
        this.dateOrder = dateOrder;
    }

    public String getStatusOrder() {
        return statusOrder;
    }

    public void setStatusOrder(String statusOrder) {
        this.statusOrder = statusOrder;
    }

    public List<LineOrder> getLineOrders() {
        return LineOrders;
    }

    public void setLineOrders(List<LineOrder> lineOrders) {
        LineOrders = lineOrders;
    }
}
