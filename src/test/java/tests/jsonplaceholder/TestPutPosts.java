package tests.jsonplaceholder;

import io.qameta.allure.Description;
import org.json.JSONObject;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

@Test(groups="JsonPlaceholderPut")
public class TestPutPosts {
    String baseURI = "https://jsonplaceholder.typicode.com";
    String postsResource = "/posts";

    JSONObject jsonObj = new JSONObject()
            .put("id", 1)
            .put("title","foo")
            .put("body","bar")
            .put("userId", 1);

    @Description("validate status response for POST is 201")
    @Test
    public void validatePostStatusResponse() {
        given()
                .pathParams("postId", "1")
                .header("Content-type", "application/json")
                .body(jsonObj.toString())
                .when()
                .request("PUT", baseURI + postsResource + "/{postId}")
                .then()
                .statusCode(200);
    }
}
