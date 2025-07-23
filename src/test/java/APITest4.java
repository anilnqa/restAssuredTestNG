import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

public class APITest4 {

    @Test
    public void testResponseValidationWithJsonPath() {
        RestAssured.baseURI = "https://api.example.com";

        String responseBody = given()
                .when().get("/users")
                .then().statusCode(200)
                .extract().response().asString();

        String username = JsonPath.from(responseBody).getString("username");
        assertThat(username, equalTo("testuser"));
    }
}
