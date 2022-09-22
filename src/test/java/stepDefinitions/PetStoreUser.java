package stepDefinitions;

import io.cucumber.java.en.*;

import static io.restassured.RestAssured.given;
import static org.junit.Assert.assertEquals;

public class PetStoreUser {

    private String username;
    private String body;
    private String password;

    @Given("Admin has all the data for creating a random user")
    public void admin_has_all_the_data_for_creating_a_random_user() {
        username = "John2345";
        password = "12341234";
    }
    @When("Admin creates a user")
    public void admin_creates_a_user() {
        body = getBody(username, password);

        given().contentType("application/json")
                .log().all()
                .body(body)
                .when().post("https://petstore.swagger.io/v2/user")
                .then().log().all().statusCode(200);

    }

    @When("Admin gets the user")
    public void admin_gets_the_user() {
        given().contentType("application/json")
                .log().all()
                .when().get("https://petstore.swagger.io/v2/user/{username}", username)
                .then().log().all().statusCode(200);
    }
    @When("Admin updates the user")
    public void admin_updates_the_user() {
        given().contentType("application/json")
                .log().all()
                .body(getBody(username, "000000000"))
                .when().put("https://petstore.swagger.io/v2/user/{username}", username)
                .then().log().all().statusCode(200);
    }
    @When("Admin deletes the user")
    public void admin_deletes_the_user() {
        given().contentType("application/json")
                .log().all()
                .when().delete("https://petstore.swagger.io/v2/user/{username}", username)
                .then().log().all().statusCode(200);
    }
    @Then("Admin shouldn't see the user")
    public void admin_shouldn_t_see_the_user() {
        String actual =
                given().contentType("application/json")
                        .log().all()
                        .when().get("https://petstore.swagger.io/v2/user/{username}", username)
                        .then().log().all().statusCode(404).extract().path("message");

        String expected = "User not found";
        assertEquals(expected, actual);
    }

    private String getBody(String username, String password){
        return "{\n" +
                "    \"id\": 759237495729,\n" +
                "    \"username\": \""+username+"\",\n" +
                "    \"firstName\": \"John\",\n" +
                "    \"lastName\": \"Back\",\n" +
                "    \"email\": \"John123@gmail.com\",\n" +
                "    \"password\": \""+password+"\",\n" +
                "    \"phone\": \"123412341234\",\n" +
                "    \"userStatus\": 0\n" +
                "}";
    }

}