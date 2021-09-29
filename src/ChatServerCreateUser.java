import io.restassured.RestAssured;

import static io.restassured.RestAssured.given;

public class ChatServerCreateUser {

    public static  void main(String[] args)
    {



        RestAssured.baseURI = "http://chat.cookingwithamol.in";

                given().log().all()
                .auth().preemptive().basic("admin","admin123")
                 .header("Content-Type","application/json")
                        .body("{\n" +
                                "  \"username\": \"sunnyUser1\",\n" +
                                "  \"password\": \"password123\",\n" +
                                "  \"email\": \"sunny@gmail.com\",\n" +
                                "  \"name\": \"sunny\",\n" +
                                "  \"surname\": \"surabha\",\n" +
                                "  \"chat_nickname\": \"sunny123\",\n" +
                                "  \"departments\": [\n" +
                                "    1,\n" +
                                "    2\n" +
                                "  ],\n" +
                                "  \"departments_read\": [\n" +
                                "    2\n" +
                                "  ],\n" +
                                "  \"department_groups\": [\n" +
                                "    1\n" +
                                "  ],\n" +
                                "  \"user_groups\": [\n" +
                                "    1\n" +
                                "  ]\n" +
                                "}")

                .when().post("/index.php/site_admin/restapi/user")
                .then().log().all().assertThat().statusCode(400);
    }

}
