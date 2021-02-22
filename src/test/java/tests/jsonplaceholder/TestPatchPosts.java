package tests.jsonplaceholder;

import io.qameta.allure.Description;
import org.json.JSONObject;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

@Test(groups="JsonPlaceholderPatch")
public class TestPatchPosts {
    String baseURI = "https://jsonplaceholder.typicode.com";
    String postsResource = "/posts";

    JSONObject jsonObj = new JSONObject()
            .put("title","foo");

    @Description("validate status response for PATCH is 200")
    @Test
    public void validatePatchStatusResponse() {
        given()
                .header("Content-type", "application/json")
                .pathParams("postId", "1")
                .body(jsonObj.toString())
                .when()
                .request("PATCH", baseURI + postsResource + "/{postId}")
                .then()
                .statusCode(200);
    }

}
