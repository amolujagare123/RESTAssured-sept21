package ForPayLoads;

import io.restassured.RestAssured;

import static io.restassured.RestAssured.given;
import static payLoad.SampleRequestsPayload.getSampleCreate;
import static payLoad.SampleRequestsPayload.getSampleCreatePayLoad;

public class SampleCreateUser2 {

    public static void main(String[] args) {

        RestAssured.baseURI = "https://reqres.in";

        given().log().all().header("Content-Type","application/json")
                .body(getSampleCreate("amol","trainer"))
                .post("/api/users")
                .then().log().all().assertThat().statusCode(201);



    }

}
