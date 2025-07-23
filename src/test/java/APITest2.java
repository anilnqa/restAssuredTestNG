import io.restassured.RestAssured;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

public class APITest2 {

    @Test
    public void testWithPathAndQueryParams() {
        RestAssured.baseURI = "https://api.example.com";

        given()
                .pathParam("id", 123)
                .queryParam("status", "active")
                .when()
                .get("/users/{id}")
                .then()
                .statusCode(200)
                .body("status", equalTo("active"));
    }
}
