package tests.jsonplaceholder;

import io.qameta.allure.Description;
import org.json.JSONObject;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

@Test(groups="JsonPlaceholderPost")
public class TestPostPosts {

    String baseURI = "https://jsonplaceholder.typicode.com";
    String postsResource = "/posts";

    JSONObject jsonObj = new JSONObject()
            .put("title","foo")
            .put("body","bar")
            .put("userId", 1);

    @Description("validate status response for POST is 201")
    @Test
    public void validatePostStatusResponse() {
        given()
                .header("Content-type", "application/json")
                .body(jsonObj.toString())
                .when()
                .request("POST", baseURI + postsResource)
                .then()
                .statusCode(201);
    }

}
