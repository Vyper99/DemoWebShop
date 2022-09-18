package stepDefinitions;

import io.restassured.response.Response;
import org.junit.Test;

import static io.restassured.RestAssured.given;

public class Store {

    @Test
    public void placeOrder() {
        Response response =
        given().contentType("application/json")
                .body("{\n" +
                        "    \"id\": 0,\n" +
                        "    \"petId\": 1,\n" +
                        "    \"quantity\": 2,\n" +
                        "    \"shipDate\": \"2022-09-15T21:37:48.707Z\",\n" +
                        "    \"status\": \"placed\",\n" +
                        "    \"complete\": true\n" +
                        "}")
                .log().all()
        .when().post("https://petstore.swagger.io/v2/store/order")
        .then().statusCode(200).log().all().extract().response();
        long id = response.path("id");
    }


}
