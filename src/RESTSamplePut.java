import io.restassured.RestAssured;

import static io.restassured.RestAssured.given;

import static io.restassured.RestAssured.baseURI;

public class RESTSamplePut {

    public static void main(String[] args) {

        baseURI = "https://reqres.in/";

        given().log().all().header("Content-Type","application/json")
                .body("{\n" +
                        "    \"name\": \"amol\",\n" +
                        "    \"job\": \"abcd\"\n" +
                        "}")
                .when().put("/api/users/2")
                .then().log().all().assertThat().statusCode(200);


    }
}
