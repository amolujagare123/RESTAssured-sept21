package ForPayLoads.usingJsonFile;

import io.restassured.RestAssured;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

import static io.restassured.RestAssured.given;
import static payLoad.ChatServerPayLoads.createUserPayLoad;

public class ChatServerCreateUserPayload {

    public static  void main(String[] args) throws IOException {



        RestAssured.baseURI = "http://chat.cookingwithamol.in";

                given().log().all()
                .auth().preemptive().basic("admin","admin123")
                 .header("Content-Type","application/json")
                        .body(new String(Files.readAllBytes(Paths.get("D:\\JsonSamples\\createuser.json"))))
                .when().post("/index.php/site_admin/restapi/user")
                .then().log().all().assertThat().statusCode(200);
    }

}
