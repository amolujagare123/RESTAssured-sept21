import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

public class DeckOfCards {

    public static void main(String[] args) {

        RestAssured.baseURI = "https://deckofcardsapi.com";

        String response = given().log().all().queryParam("deck_count","1")
                .when().get("/api/deck/new/shuffle/")
                .then().log().all().assertThat().statusCode(200).extract().asString();


        System.out.println("<< ======= This is the response string =========== >>>");
        System.out.println(response);


        JsonPath jsonResponse = new JsonPath(response);


        System.out.println("deckID = "+jsonResponse.getString("deck_id"));
        System.out.println("Remaining = "+jsonResponse.getInt("remaining"));
        System.out.println("success = "+jsonResponse.getBoolean("success"));


        String deckId = jsonResponse.getString("deck_id");

     /*   int cardCount = jsonResponse.getInt("remaining");

        boolean result = jsonResponse.getBoolean("success");

        int cardCount1 = jsonResponse.get("remaining");*/

        int expectedRemaining = 49;

        given().log().all().queryParam("count","3")
                .when().get("/api/deck/"+deckId+"/draw/")
                .then().log().all().assertThat().statusCode(200)
                .body("remaining", equalTo(expectedRemaining))
                .body("success", equalTo(true));

    }
}
