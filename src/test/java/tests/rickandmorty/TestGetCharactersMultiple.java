package tests.rickandmorty;

import io.qameta.allure.Description;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import tests.enums.RickAndMortyEndpoints;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.containsString;
import static org.hamcrest.Matchers.equalTo;

@Test(groups="RickAndMortyGet")
public class TestGetCharactersMultiple {
    String characterEndpoint = RickAndMortyEndpoints.RICK_AND_MORTY_CHARACTER.getValue();

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
                .request("GET",characterEndpoint)
                .then()
                .log().all()
                .statusCode(200)
                .assertThat()
                .body("results[0].'status'", equalTo(status))
                .assertThat()
                .body("results[0].'name'", containsString(name));
    }
}
