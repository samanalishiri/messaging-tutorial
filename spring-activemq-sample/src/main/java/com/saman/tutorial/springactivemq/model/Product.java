package com.saman.tutorial.springactivemq.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreType;

import java.io.Serializable;
import java.util.Objects;

public class Product implements Serializable {
 
    private String id;
     
    private String name;
 
    private int quantity;
 
    private ProductStatus status;

    public Product() {
    }

    @JsonIgnore
    private Product(Builder builder) {
        setId(builder.id);
        setName(builder.name);
        setQuantity(builder.quantity);
        setStatus(builder.status);
    }

    @JsonIgnore
    public static Builder builder() {
        return new Builder();
    }

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

    @JsonIgnoreType
    public static final class Builder {
        private String id;
        private String name;
        private int quantity;
        private ProductStatus status;

        private Builder() {
        }

        public Builder id(String val) {
            id = val;
            return this;
        }

        public Builder name(String val) {
            name = val;
            return this;
        }

        public Builder quantity(int val) {
            quantity = val;
            return this;
        }

        public Builder status(ProductStatus val) {
            status = val;
            return this;
        }

        public Product build() {
            return new Product(this);
        }
    }
}