import ForPayLoads.pojo.CreateUserChat;
import io.restassured.RestAssured;
import scala.Int;

import java.util.ArrayList;

import static io.restassured.RestAssured.given;

public class ChatServerCreateUserPOJO {

    public static  void main(String[] args)
    {



        RestAssured.baseURI = "http://chat.cookingwithamol.in";

        CreateUserChat createUserChat = new CreateUserChat();

        createUserChat.setUsername("vishal");
        createUserChat.setPassword("kkk");
        createUserChat.setName("vishal");
        createUserChat.setSurname("k");
        createUserChat.setChat_nickname("Vish_k");
        createUserChat.setEmail("vish@gmail.com");

      /*  ArrayList<Integer> dept = new ArrayList<>();
        dept.add(1);
        dept.add(2);*/

        ArrayList<Integer> dept = new ArrayList<>(){{
            add(1);
            add(2);
        }};


        createUserChat.setDepartments(dept);

        ArrayList<Integer> deptRead = new ArrayList<>();
        deptRead.add(2);

        createUserChat.setDepartments_read(deptRead);

        ArrayList<Integer> deptGrps = new ArrayList<>() {{
            add(1);

        }};

        createUserChat.setDepartment_groups(deptGrps);
        ArrayList<Integer> userGrps = new ArrayList<>() {{
            add(1);

        }};

        createUserChat.setUser_groups(userGrps);

        given().log().all()
                .auth().preemptive().basic("admin","admin123")
                 .header("Content-Type","application/json")
                        .body(createUserChat)

                .when().post("/index.php/site_admin/restapi/user")
                .then().log().all().assertThat().statusCode(400);
    }

}
