package ForPayLoads;

import io.restassured.RestAssured;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;
import static payLoad.SampleRequestsPayload.getSampleCreate;

public class SampleCreateUserDataPro {

    @Test(dataProvider = "getData")
    public  void myTest(String name,String job)
    {

        RestAssured.baseURI = "https://reqres.in";

        given().log().all().header("Content-Type","application/json")
                .body(getSampleCreate(name,job))
                .post("/api/users")
                .then().log().all().assertThat().statusCode(201);
    }

    @DataProvider
    public Object[][] getData()
    {
        Object[][] data = {

                {"amol","Trainer"},
                {"sunny","Test Lead"},
                {"nikhil","Manager"},
                {"anand","Dev Lead"},
                {"kailas","CEO"},

        };

        return data;
    }

}
