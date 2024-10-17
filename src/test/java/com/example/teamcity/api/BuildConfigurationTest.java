package com.example.teamcity.api;

import com.example.teamcity.models.User;
import com.example.teamcity.spec.Specifications;
import org.testng.annotations.Test;
import org.apache.http.HttpStatus;
import io.restassured.RestAssured;

public class BuildConfigurationTest extends BaseApiTest {
    @Test
    public void buildConfigurationTest(){
        var user = User.builder()
                        .username("admin")
                        .password("admin")
                        .build();
        var token = RestAssured
                .given()
                .spec(Specifications.getSpec().authSpec(user))
                .get("http://admin:admin@192.168.0.14:8111/authenticationTest.html?crsf")
                .then().assertThat().statusCode(HttpStatus.SC_OK)
                .extract().asString();
        System.out.println("HI"+token);
    }
}
