package com.softserveinc.testapi.domain.model.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.softserveinc.testapi.domain.model.UserRights;

import java.util.List;

public class User extends Identifiable {
    private String firstName;
    private String secondName;
    private int age;
    private String phone;
    @JsonIgnore
    private String login;
    @JsonIgnore
    private String password;
    @JsonIgnore
    private UserRights rights;
    @JsonIgnore
    private List<Product> products;

    public User() {
    }

    public User(String login, String password) {
        this.login = login;
        this.password = password;
    }

    public User(String firstName, String secondName, int age, String phone, String login, String password, UserRights rights) {
        this(login, password);
        this.firstName = firstName;
        this.secondName = secondName;
        this.age = age;
        this.phone = phone;
        this.rights = rights;
    }

    public User(String firstName, String secondName, int age, String phone, String login, String password, UserRights rights, List<Product> products) {
        this(firstName, secondName, age, phone, login, password, rights);
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

    public String getSecondName() {
        return secondName;
    }

    public void setSecondName(String secondName) {
        this.secondName = secondName;
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

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public UserRights getRights() {
        return rights;
    }

    public void setRights(UserRights rights) {
        this.rights = rights;
    }

    public List<Product> getProducts() {
        return products;
    }

    public void setProducts(List<Product> products) {
        products.forEach((element) -> element.setSeller(this));
        this.products = products;
    }
}
