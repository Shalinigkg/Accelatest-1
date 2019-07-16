package com.api.automation;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.junit.Assert;
import org.junit.Test;

import java.io.File;

import static io.restassured.RestAssured.given;

public class VerifyPetTest {

    /**
     * Negative Scenario Test:. Verify that the pet is not added to the store when request is submitted with an invalid data.
     */
    @Test
    public void verifyPet() {
        //Reading Json file
        File file = new File("C:\\Users\\sgurijala\\IdeaProjects\\Accelatest\\src\\main\\resources\\Requestfiles\\Addpet.json");

        //Submitting the request and verifying the status code
                given().body(file).
                with().contentType("application/json")
                .when().post("https://petstore.swagger.io/v2/pet")
                .then().assertThat().statusCode(200);

        Response Res = RestAssured.get("https://petstore.swagger.io/v2/pet/125412323444444444444444444444444");
        int Code = Res.getStatusCode();
        System.out.println("Status code is " + Code);

        Assert.assertEquals(404, Code);

    }
}
