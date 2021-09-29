package ForPayLoads;

import io.restassured.RestAssured;

import static io.restassured.RestAssured.given;
import static payLoad.ChatServerPayLoads.createUserPayLoad;

public class ChatServerCreateUserPayload {

    public static  void main(String[] args)
    {



        RestAssured.baseURI = "http://chat.cookingwithamol.in";

                given().log().all()
                .auth().preemptive().basic("admin","admin123")
                 .header("Content-Type","application/json")
                        .body(createUserPayLoad())

                .when().post("/index.php/site_admin/restapi/user")
                .then().log().all().assertThat().statusCode(400);
    }

}
