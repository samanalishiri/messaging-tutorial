package com.saman.tutorial.springactivemq.model;

import java.io.Serializable;
import java.util.Objects;

public class Product implements Serializable {
 
    private String id;
     
    private String name;
 
    private int quantity;
 
    private ProductStatus status;
 
    public String getId() {
        return id;
    }
 
    public void setId(String id) {
        this.id = id;
    }
 
    public String getName() {
        return name;
    }
 
    public void setName(String name) {
        this.name = name;
    }
 
    public int getQuantity() {
        return quantity;
    }
 
    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
 
    public ProductStatus getStatus() {
        return status;
    }
 
    public void setStatus(ProductStatus status) {
        this.status = status;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Product product = (Product) o;
        return Objects.equals(getId(), product.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId());
    }

    @Override
    public String toString() {
        return String.format("Product {id:%s, name:%s, quantity:%d, status:%s}", id, name, quantity, status);
    }
}