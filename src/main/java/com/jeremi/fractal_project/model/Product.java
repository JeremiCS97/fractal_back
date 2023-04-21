package com.jeremi.fractal_project.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.GeneratedValue;


@Entity
public class Product {

    @Id
    @Column(name = "idProduct")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idProduct;

    @Column(name = "nameProduct")
    private String nameProduct;

    @Column(name = "unitPrice")
    private Float unitPrice;

    @Column(name = "qtyAvailable")
    private Integer qtyAvailable;

    public Product(){

    }

    public Product(Integer idProduct, String nameProduct, Float unitPrice, Integer qtyAvailable) {
        this.idProduct = idProduct;
        this.nameProduct = nameProduct;
        this.unitPrice = unitPrice;
        this.qtyAvailable = qtyAvailable;
    }

    public Integer getIdProduct() {
        return idProduct;
    }

    public void setIdProduct(Integer idProduct) {
        this.idProduct = idProduct;
    }

    public String getNameProduct() {
        return nameProduct;
    }

    public void setNameProduct(String nameProduct) {
        this.nameProduct = nameProduct;
    }

    public Float getUnitPrice() {
        return unitPrice;
    }

    public void setUnitPrice(Float unitPrice) {
        this.unitPrice = unitPrice;
    }

    public Integer getQtyAvailable() {
        return qtyAvailable;
    }

    public void setQtyAvailable(Integer qtyAvailable) {
        this.qtyAvailable = qtyAvailable;
    }
}
