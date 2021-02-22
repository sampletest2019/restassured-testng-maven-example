package tests.rickandmorty;

import io.qameta.allure.Description;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.containsString;
import static org.hamcrest.Matchers.equalTo;

@Test(groups="RickAndMortyGet")
public class TestGetCharactersMultiple {
    String baseURI = "https://rickandmortyapi.com/api";
    String characterResource = "/character";

    @DataProvider(name = "name and status")
    public static Object[][] nameAndStatus() {
        return new Object[][]{
                {"Rick", "Alive"},
                {"Morty", "Alive"},
                {"Rick", "Dead"}
        };
    }

    @Description("validating response name and status based on the parameters")
    @Test(dataProvider = "name and status")
    public void validateNameAndStatusFilterParameters(String name, String status){
        given()
                .queryParam("name", name)
                .queryParam("status", status).
        when()
                .request("GET",baseURI+characterResource)
                .then()
                .log().all()
                .statusCode(200)
                .assertThat()
                .body("results[0].'status'", equalTo(status))
                .assertThat()
                .body("results[0].'name'", containsString(name));
    }
}
