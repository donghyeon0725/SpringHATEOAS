package com.example.demo;

import org.springframework.hateoas.ResourceSupport;

public class Order extends ResourceSupport {
    private String identity;
    private String goods;
    private Integer quantity;
    private String orderer;

    public Order() {
        // TODO Auto-generated constructor stub
    }

    public Order(String identity, String orderer, String goods, Integer quantity) {
        super();
        this.identity = identity;
        this.goods = goods;
        this.quantity = quantity;
        this.orderer = orderer;
    }

    public String getOrderer() {
        return orderer;
    }

    public Order setOrderer(String orderer) {
        this.orderer = orderer;
        return this;
    }

    public String getIdentity() {
        return identity;
    }

    public Order setIdentity(String identity) {
        this.identity = identity;
        return this;
    }

    public String getGoods() {
        return goods;
    }

    public Order setGoods(String goods) {
        this.goods = goods;
        return this;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public Order setQuantity(Integer quantity) {
        this.quantity = quantity;
        return this;
    }

    @Override
    public String toString() {
        return "Order{" +
                "identity='" + identity + '\'' +
                ", goods='" + goods + '\'' +
                ", quantity=" + quantity +
                ", orderer='" + orderer + '\'' +
                '}';
    }
}
