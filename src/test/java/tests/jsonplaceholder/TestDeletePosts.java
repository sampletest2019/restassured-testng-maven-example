package tests.jsonplaceholder;

import io.qameta.allure.Description;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

@Test(groups="JsonPlaceholderDelete")
public class TestDeletePosts {
    String baseURI = "https://jsonplaceholder.typicode.com";
    String postsResource = "/posts";

    @Description("validate status response for DELETE is 200")
    @Test
    public void validateDeleteStatusResponse() {
        given()
                .pathParams("postId", "1")
                .when()
                .request("DELETE", baseURI + postsResource + "/{postId}")
                .then()
                .statusCode(200);
    }

}
