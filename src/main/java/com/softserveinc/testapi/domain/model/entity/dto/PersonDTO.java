package com.softserveinc.testapi.domain.model.entity.dto;

import com.softserveinc.testapi.domain.model.entity.Person;

import java.util.List;
import java.util.stream.Collectors;

public class PersonDTO {
    private Long id;
    private String firstName;
    private String lastName;
    private int age;
    private String phone;
    private UserDTO user;

    public PersonDTO() {
    }

    public PersonDTO(Person person) {
        this.id = person.getId();
        this.firstName = person.getFirstName();
        this.lastName = person.getLastName();
        this.age = person.getAge();
        this.phone = person.getPhone();
        this.user = new UserDTO(person.getUser());
    }

    public static List<PersonDTO> mapAll(List<Person> people) {
        return  people.stream().map(PersonDTO::new).collect(Collectors.toList());
    }

    public static Person restore(PersonDTO personDTO) {
        return new Person(personDTO.getFirstName(), personDTO.getLastName(), personDTO.getAge(), personDTO.getPhone());
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public UserDTO getUser() {
        return user;
    }

    public void setUser(UserDTO user) {
        this.user = user;
    }
}
