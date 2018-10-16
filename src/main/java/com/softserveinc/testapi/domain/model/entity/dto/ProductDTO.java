package com.softserveinc.testapi.domain.model.entity.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.softserveinc.testapi.domain.model.entity.Person;
import com.softserveinc.testapi.domain.model.entity.Product;

import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

public class ProductDTO {
    private Long id;
    private String name;
    private String price;
    @JsonIgnore
    private int count;
    @JsonIgnore
    private PersonDTO seller;
    private Map<String, String> attributes;

    public ProductDTO() {
    }

    public ProductDTO(Product product) {
        this.id = product.getId();
        this.name = product.getName();
        this.price = product.getPrice();
        this.count = product.getCount();
        this.seller = new PersonDTO(Optional.ofNullable(product.getSeller()).orElse(new Person()));
        this.attributes = product.getAttributes();
    }

    public static List<ProductDTO> mapAll(List<Product> users) {
        return users.stream().map(ProductDTO::new).collect(Collectors.toList());
    }

    public static Product restore(ProductDTO productDTO) {
        return new Product(productDTO.getName(), productDTO.getPrice(), productDTO.getCount(), productDTO.getAttributes());
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public PersonDTO getSeller() {
        return seller;
    }

    public void setSeller(PersonDTO seller) {
        this.seller = seller;
    }

    public Map<String, String> getAttributes() {
        return attributes;
    }

    public void setAttributes(Map<String, String> attributes) {
        this.attributes = attributes;
    }
}
