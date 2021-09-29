import io.restassured.RestAssured;
import io.restassured.authentication.PreemptiveBasicAuthScheme;

import static io.restassured.RestAssured.given;

public class ChatServerGetChats {

    public static  void main(String[] args)
    {



        RestAssured.baseURI = "http://chat.cookingwithamol.in";

                given().log().all()
                .auth().preemptive().basic("admin","admin123")
                .when().get("/index.php/site_admin/restapi/chats")
                .then().log().all().assertThat().statusCode(200);
    }

}
