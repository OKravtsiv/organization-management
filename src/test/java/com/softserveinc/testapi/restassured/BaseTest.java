package com.softserveinc.testapi.restassured;

import com.jayway.restassured.RestAssured;
import com.jayway.restassured.builder.RequestSpecBuilder;
import com.jayway.restassured.filter.log.LogDetail;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.springframework.boot.test.context.SpringBootTest;

@RunWith(Suite.class)
@Suite.SuiteClasses({
        UserControllerTest.class,
        PersonControllerTest.class
})
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.DEFINED_PORT)
public class BaseTest {

    private static final String DEFAULT_AUTH_HEADER_NAME = "Authorization";
    private static final String DEFAULT_AUTH_HEADER_VALUE = "Basic dXNlcjp1c2VyUGFzc3dvcmQ=";
    private static final String DEFAULT_BASE_URI = "http://localhost";
    private static final int DEFAULT_PORT = 8085;

    @BeforeClass
    public static void setUp() {
        RestAssured.baseURI = DEFAULT_BASE_URI;
        RestAssured.port = DEFAULT_PORT;
        RestAssured.requestSpecification = new RequestSpecBuilder()
                .addHeader(DEFAULT_AUTH_HEADER_NAME, DEFAULT_AUTH_HEADER_VALUE)
                .and()
                .log(LogDetail.ALL)
                .build();
    }
}
