package tests.rickandmorty;

import io.qameta.allure.Description;
import io.restassured.http.ContentType;
import org.testng.annotations.Test;
import tests.enums.RickAndMortyEndpoints;
import tests.utils.RestUtils;

import static io.restassured.RestAssured.when;
import static io.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchemaInClasspath;
import static org.hamcrest.Matchers.equalTo;

@Test(groups="RickAndMortyGet")
public class TestGetCharacters {
    String characterEndpoint = RickAndMortyEndpoints.RICK_AND_MORTY_CHARACTER.getValue();


    @Description("validate status code is 200")
    @Test
    public void validateApiResponseStatusCode() {
        RestUtils.validateResponseCode(characterEndpoint, 200);
    }

    @Description("validate characters count and number of pages in the response")
    @Test
    public void validateCountAndPagesNumber(){
        when()
                .request("GET", characterEndpoint)
                .then()
                .log().all()
                .statusCode(200)
                .assertThat()
                .body("info.count", equalTo(671))
                .assertThat()
                .body("info.pages", equalTo(34));
    }

    @Description("validate schema is correct")
    @Test
    public void validateSchema(){
        when()
                .request("GET", characterEndpoint)
                .then()
                .contentType(ContentType.JSON)
                .assertThat()
                .body(matchesJsonSchemaInClasspath("rickandmorty_character_get.json"));
    }



}
