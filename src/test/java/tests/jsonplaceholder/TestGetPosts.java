package tests.jsonplaceholder;

import io.qameta.allure.Description;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.when;
import static org.hamcrest.Matchers.equalTo;

@Test(groups="JsonPlaceholderGet")
public class TestGetPosts {
    String baseURI = "https://jsonplaceholder.typicode.com";
    String characterResource = "/posts";

    @Description("validate status code is 200")
    @Test
    public void validateApiStatusCode() {
        when()
                .get(baseURI+characterResource)
                .then()
                .log().all()
                .statusCode(200);
    }

    @Description("validate last id is 100")
    @Test
    public void validateLastId(){
        when()
                .get(baseURI+characterResource)
                .then()
                .log().all()
                .statusCode(200)
                .assertThat()
                .body("id[99]", equalTo(100));
    }
}
