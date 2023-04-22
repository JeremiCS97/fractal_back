package com.jeremi.fractal_project.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;
import java.util.Date;


@Entity
@Table(name = "orderv")
public class Order {

    @Id
    @Column (name="idOrder")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idOrder;


    @Column (name = "orderNumber")
    private Integer orderNumber;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern="yyyy-MM-dd")
    @Column (name = "dateOrder")
    private Date dateOrder;

    @Column (name ="statusOrder")
    private String statusOrder;

    public Order() {
    }

    public Order(Integer idOrder, Integer orderNumber, Date dateOrder, String statusOrder) {
        this.idOrder = idOrder;
        this.orderNumber = orderNumber;
        this.dateOrder = dateOrder;
        this.statusOrder = statusOrder;
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
}
