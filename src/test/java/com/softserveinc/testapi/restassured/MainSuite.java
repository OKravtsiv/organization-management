package com.softserveinc.testapi.restassured;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.springframework.boot.test.context.SpringBootTest;

@RunWith(Suite.class)
@Suite.SuiteClasses({
        UserControllerTest.class,
        PersonControllerTest.class
})
public class MainSuite {

}
