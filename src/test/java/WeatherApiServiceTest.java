import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;

public class WeatherApiServiceTest {

    @Test
    public void getWeather(){
        Response response = RestAssured.get("http://samples.openweathermap.org/data/2.5/weather?q=London,uk&appid=439d4b804bc8187953eb36d2a8c26a02");
        int respCode = response.getStatusCode();
        String respData = response.asString();
        Assert.assertEquals(200, respCode);
        System.out.println("The data is "+respData);

        System.out.println("The response time is :"+response.getTime());
    }

}
