package tests.rickandmorty;

import io.qameta.allure.Description;
import io.restassured.RestAssured.*;
import io.restassured.matcher.RestAssuredMatchers.*;
import org.hamcrest.Matchers.*;
import io.restassured.module.jsv.JsonSchemaValidator.*;
import org.testng.*;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.get;
import static io.restassured.RestAssured.when;
import static org.hamcrest.Matchers.equalTo;

@Test(groups="RickAndMortyGet")
public class TestGetCharacters {
    String baseURI = "https://rickandmortyapi.com/api";
    String characterResource = "/character";

    @Description("validate status code is 200")
    @Test
    public void validateApiStatusCode() {
        when()
                .get(baseURI+characterResource)
                .then()
                .log().all()
                .statusCode(200);
    }

    @Description("validate characters count and number of pages in the response")
    @Test
    public void validateCountAndPagesNumber(){
        when()
                .get(baseURI+characterResource)
                .then()
                .log().all()
                .statusCode(200)
                .assertThat()
                .body("info.count", equalTo(671))
                .assertThat()
                .body("info.pages", equalTo(34));
    }



}