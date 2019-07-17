package com.api.automation;

import org.junit.Test;

import java.io.File;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.equalTo;

public class AddPetTest {
    /**
     * Positive Scenario Test: Verify that the pet has added to the store with valid data.
     */

    @Test
    public void Addpet() {

        File file = new File("C:\\Users\\sgurijala\\IdeaProjects\\Accelatest\\src\\main\\resources\\Requestfiles\\Addpet.json");
        given().body(file).
                with().contentType("application/json")
                .when().post("https://petstore.swagger.io/v2/pet")
                .then().assertThat().
                statusCode(200).
                body("category.id", equalTo(111));
    }

}