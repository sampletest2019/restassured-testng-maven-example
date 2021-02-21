package tests.rickandmorty;

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
public class testGetCharacters {
    String baseURI = "https://rickandmortyapi.com/api";
    String characterResource = "/character";

    @Test
    public void validateApiStatusCode() {
        when()
                .get(baseURI+characterResource)
                .then()
                .log().all()
                .statusCode(200);
    }

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
