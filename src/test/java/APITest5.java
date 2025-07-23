import com.github.fge.jsonschema.SchemaVersion;
import com.github.fge.jsonschema.cfg.ValidationConfiguration;
import com.github.fge.jsonschema.main.JsonSchemaFactory;
import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;
import static io.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchemaInClasspath;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;


public class APITest5 {

    @Test
    public void test_jsonSchemaValidator() {

        RestAssured.baseURI = "https://api.example.com";

        given().
        get("/events?id=390").then().assertThat()
                .body(matchesJsonSchemaInClasspath("responseSample.json"));
    }
    @Test
    public void test_jsonSchemaValidatorWithJsonConfiguredVersion() {
        JsonSchemaFactory jsonSchemaFactory = JsonSchemaFactory.newBuilder()
                .setValidationConfiguration(
                        ValidationConfiguration.newBuilder()
                                .setDefaultVersion(SchemaVersion.DRAFTV4).freeze())
                .freeze();
        RestAssured.baseURI = "https://api.example.com";

        given().
        get("/events?id=390").then().assertThat()
                .body(matchesJsonSchemaInClasspath("responseSample.json")
                        .using(jsonSchemaFactory));
    }

}
