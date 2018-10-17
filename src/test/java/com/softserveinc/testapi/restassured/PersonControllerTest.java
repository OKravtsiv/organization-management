package com.softserveinc.testapi.restassured;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.http.HttpStatus;
import org.springframework.test.context.junit4.SpringRunner;

import static com.jayway.restassured.RestAssured.when;

@RunWith(SpringRunner.class)
public class PersonControllerTest extends BaseTest{
    @Test
    public void pingTest() {
        when()
                .get("/users")
                .then()
                .statusCode(HttpStatus.OK.value());
    }
}
