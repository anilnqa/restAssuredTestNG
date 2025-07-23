import io.restassured.http.ContentType;
import org.json.JSONObject;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class APITest7 {

    @Test
    public void putRequest() {
        JSONObject requestData = new JSONObject();
        requestData.put("age", "36");

        given().contentType(ContentType.JSON).body(requestData).
        when().put("http://dummy.restapiexample.com/api/v1/update/2").
        then().assertThat().statusCode(200);
    }
}
