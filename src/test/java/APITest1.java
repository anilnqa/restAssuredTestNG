import io.restassured.RestAssured;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.containsString;
import static org.hamcrest.Matchers.equalTo;

public class APITest1 {

    @Test
    public void test_GetRequest() {
        RestAssured.baseURI = "https://jsonplaceholder.typicode.com";

        given()
                .when().get("/posts/1")
                .then().statusCode(200)
                .body("userId", equalTo(1));
    }

    @Test
    public void getRequest() {
        given().
                when().get("http://dummy.restapiexample.com/api/v1/employees").
                then().assertThat().statusCode(200);
    }

    @Test
    public void testCustomerService() {
        RestAssured.baseURI = "http://www.acme.com";
        given()
                .when().get("/cars")
                .then()
                .statusCode(200)
                .body(containsString("Ford"),
                        containsString("Coupe"));

    }
}
