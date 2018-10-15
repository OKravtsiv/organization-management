package com.softserveinc.testapi.domain.model.dto;

import com.softserveinc.testapi.domain.model.entity.Product;
import com.softserveinc.testapi.domain.model.entity.User;

import java.util.List;

public class UserDTO {
    private long id;
    private String firstName;
    private String secondName;
    private List<Product> products;

    public UserDTO() {
    }

    public UserDTO(User user) {
        this.id = user.getId();
        this.firstName = user.getFirstName();
        this.secondName = user.getSecondName();
        this.products = user.getProducts();
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getSecondName() {
        return secondName;
    }

    public void setSecondName(String secondName) {
        this.secondName = secondName;
    }

    public List<Product> getProducts() {
        return products;
    }

    public void setProducts(List<Product> products) {
        this.products = products;
    }
}
