package stepDefinitions;

import io.restassured.response.Response;
import org.junit.Test;

import static io.restassured.RestAssured.given;
import static org.junit.Assert.assertEquals;

public class PetOrder {

    @Test
    public void addPetToTheStore() {
        //given -> all the inputs for single API
        //When  -> make the request and get the response
        //then  -> verification and/or extraction of data
        Response response =
                given().contentType("application/json")
                        .body("")
                        .log().all()
                        .when().post("https://petstore.swagger.io/v2/pet")
                        .then().statusCode(200).log().all().extract().response();

        //GET call
        long id = response.path("id");

        long actual = given().contentType("application/json")
                     .when().get("https://petstore.swagger.io/v2/pet/{}", id)
                     .then().log().all().statusCode(200).extract().response().path("id");

        assertEquals(id, actual);

        //PUT call
        given().contentType("application/json")
               .body("")
        .when().put("")
               .then().log().all().statusCode(200);

        //DELETE call
        given().contentType("application/json")
        .when().delete("https://petstore.swagger.io/v2/pet/{id}", id)
        .then().log().all().statusCode(200);
    }


}
