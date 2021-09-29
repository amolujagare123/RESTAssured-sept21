package ForPayLoads;

import io.restassured.RestAssured;

import static io.restassured.RestAssured.given;
import static payLoad.ChatServerPayLoads.createUserPayLoad;
import static payLoad.ChatServerPayLoads.updateUserPayLoad;

public class ChatServerUpdateUser {

    public static void main(String[] args) {
        RestAssured.baseURI = "http://chat.cookingwithamol.in";

        String uId ="24";
        given().log().all()
                .auth().preemptive().basic("admin","admin123")
                .header("Content-Type","application/json")
                .body(updateUserPayLoad("amol1","pass1" ,
                        "amol1@gmail.com","amol11","ujagare999"
                ,"amol321"))

                .when().put("/index.php/site_admin/restapi/user/"+uId)
                .then().log().all().assertThat().statusCode(200);

    }
}
