package com.softserveinc.testapi.domain.model.entity;

import java.util.Map;

public class Product extends Identifiable{
    private String name;
    private String price;
    private int count;
    private User seller;
    private Map<String, String> attributes;

    public Product() {
    }

    public Product(String name, String price, int count, Map<String, String> attributes) {
        this.name = name;
        this.price = price;
        this.count = count;
        this.attributes = attributes;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public Map<String, String> getAttributes() {
        return attributes;
    }

    public void setAttributes(Map<String, String> attributes) {
        this.attributes = attributes;
    }

    public User getSeller() {
        return seller;
    }

    public void setSeller(User seller) {
        this.seller = seller;
    }
}
