package ForPayLoads;

import ForPayLoads.pojo.SampleCreateUser;
import io.restassured.RestAssured;

import static io.restassured.RestAssured.given;

public class SampleCreateUserPojo {
//using POJO  class (Plain old Java object)
    public static void main(String[] args) {

        RestAssured.baseURI = "https://reqres.in";

        SampleCreateUser sampleCreateUser = new SampleCreateUser();
        sampleCreateUser.setName("swapnil");
        sampleCreateUser.setJob("Tester");

        given().log().all().header("Content-Type","application/json")
                .body(sampleCreateUser)
                .post("/api/users")
                .then().log().all().assertThat().statusCode(201);



    }

}
