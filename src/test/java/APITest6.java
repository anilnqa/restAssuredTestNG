import io.restassured.http.ContentType;
import org.json.JSONObject;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class APITest6 {

    @Test
    public void postRequest1() {
        JSONObject requestData = new JSONObject ();
        requestData.put("name", "morpheus");
        requestData.put("salary", "786007");
        requestData.put("age", "34");

        given().contentType(ContentType.JSON).body(requestData).
                when().post("http://dummy.restapiexample.com/api/v1/create").
                then().assertThat().statusCode(200);
    }
}
