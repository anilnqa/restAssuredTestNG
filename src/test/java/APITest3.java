import io.restassured.RestAssured;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

public class APITest3 {

    @Test
    public void testWithBasicAuthentication() {
        RestAssured.baseURI = "https://api.example.com";

        given()
                .auth().basic("username", "password")
                .when()
                .get("/secure/resource")
                .then()
                .statusCode(200);
    }
}


