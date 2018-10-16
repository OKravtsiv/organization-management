package com.softserveinc.testapi.domain.model.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;

import java.util.List;

public class Person extends Identifiable {
    private String firstName;
    private String lastName;
    private int age;
    private String phone;
    @JsonIgnore
    private List<Product> products;
    private User user;

    public Person() {
    }

    public Person(String firstName, String lastName, int age, String phone) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
        this.phone = phone;
    }

    public Person(String firstName, String lastName, int age, String phone, List<Product> products) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
        this.phone = phone;
        this.products = products;
    }

    public void addProduct(Product product) {
        product.setSeller(this);
        products.add(product);
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public List<Product> getProducts() {
        return products;
    }

    public void setProducts(List<Product> products) {
        products.forEach((element) -> element.setSeller(this));
        this.products = products;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
