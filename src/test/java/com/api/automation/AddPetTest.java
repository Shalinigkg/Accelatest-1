package com.api.automation;

import org.junit.Test;

import java.io.File;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.equalTo;

public class AddPetTest {
    /**
     * Positive Scenario Test
     */
    @Test
    public void whenAddAPetThenHttpStatusCodeMustBe200() {

        File file = new File("C:\\Users\\sgurijala\\IdeaProjects\\Accelatest\\src\\main\\resources\\Requestfiles\\Addpet.json");
        given().body(file).
                with().contentType("application/json")
                .when().post("http://petstore.swagger.io/v2/pet")
                .then().assertThat().
                statusCode(200).
                body("category.id", equalTo(111));
    }

}