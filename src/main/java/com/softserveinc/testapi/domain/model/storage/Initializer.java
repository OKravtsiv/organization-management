package com.softserveinc.testapi.domain.model.storage;

import com.softserveinc.testapi.domain.model.UserRights;
import com.softserveinc.testapi.domain.model.entity.Product;
import com.softserveinc.testapi.domain.model.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

@Component
public class Initializer {
    @Autowired
    private UserStorage userStorage;
    @Autowired
    private ProductStorage productStorage;

    @PostConstruct
    public void fillData() {
        User user1 = new User("Ostap", "Kravtsiv", 22, "+380639033115","OKravtsiv", "lil", UserRights.ADMIN);
        User user2 = new User("Andriy", "Kimachuk", 30, "+380638957450","AKimachuk", "lol", UserRights.MANAGER);
        User user3 = new User("Khrystyna", "Koblents", 24, "+380634902769","KKoblents", "lel", UserRights.MANAGER);
        User user4 = new User("Uliana","Pizhanska", 22, "+380634987555","UPizhanska", "lul", UserRights.MANAGER);

        Map<String, String> attributes1 = new HashMap<>();
        attributes1.put("Colour", "White");
        attributes1.put("Smell", "Orange");

        Map<String, String> attributes2 = new HashMap<>();
        attributes2.put("Length", "2 meters");
        attributes2.put("Thickness", "2 inches");

        Map<String, String> attributes3 = new HashMap<>();
        attributes3.put("Diagonal", "25 inches");
        attributes3.put("Energy consumption", "AAA");

        Map<String, String> attributes4 = new HashMap<>();
        attributes4.put("Energy consumption", "AAA");
        attributes4.put("Noise level", "12 db");

        Map<String, String> attributes5 = new HashMap<>();
        attributes5.put("Material", "Wool");
        attributes5.put("Size", "42");

        Map<String, String> attributes6 = new HashMap<>();
        attributes6.put("Material", "Wool");

        Map<String, String> attributes7 = new HashMap<>();
        attributes7.put("Manufacturer", "Samsung");
        attributes7.put("Battery capacity", "4200 mA");

        Map<String, String> attributes8 = new HashMap<>();
        attributes8.put("Processor", "Intel");

        Product product1 = new Product("Soap", "4$", 40, attributes1);
        Product product2 = new Product("Cord", "2$", 40, attributes2);
        Product product3 = new Product("TV", "1000$", 15, attributes3);
        Product product4 = new Product("Fridge", "1500$", 10, attributes4);
        Product product5 = new Product("Slippers", "50$", 20, attributes5);
        Product product6 = new Product("Gloves", "45$", 20, attributes6);
        Product product7 = new Product("Phone", "700$", 30, attributes7);
        Product product8 = new Product("PC", "1300$", 10, attributes8);

        user1.setProducts(Arrays.asList(product1, product2));
        user2.setProducts(Arrays.asList(product3, product4));
        user3.setProducts(Arrays.asList(product5, product6));
        user4.setProducts(Arrays.asList(product7, product8));

        userStorage.saveAll(Arrays.asList(user1, user2, user3, user4));
        productStorage.saveAll(Arrays.asList(product1, product2, product3, product4, product5, product6, product7, product8));
    }
}
