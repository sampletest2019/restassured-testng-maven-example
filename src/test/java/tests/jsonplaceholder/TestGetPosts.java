package tests.jsonplaceholder;

import io.qameta.allure.Description;
import io.restassured.http.ContentType;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.when;
import static io.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchema;
import static io.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchemaInClasspath;
import static org.hamcrest.Matchers.equalTo;

@Test(groups="JsonPlaceholderGet")
public class TestGetPosts {
    String baseURI = "https://jsonplaceholder.typicode.com";
    String postsResource = "/posts";

    @Description("validate status code is 200")
    @Test
    public void validateApiStatusCode() {
        when()
                .get(baseURI+ postsResource)
                .then()
                .log().all()
                .statusCode(200);
    }

    @Description("validate last id is 100")
    @Test
    public void validateLastId(){
        when()
                .request("GET", baseURI+ postsResource)
                .then()
                .log().all()
                .statusCode(200)
                .assertThat()
                .body("id[99]", equalTo(100))
                .and()
                .assertThat()
                .body("userId[99]", equalTo(10));
    }

    @Description("validate schema is correct")
    @Test
    public void validateSchema(){
        when()
                .request("GET", baseURI+ postsResource)
                .then()
                .contentType(ContentType.JSON)
                .assertThat()
                .body(matchesJsonSchemaInClasspath("jsonplaceholder_get.json"));
    }

}
