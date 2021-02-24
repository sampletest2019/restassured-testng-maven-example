package tests.utils;

import static io.restassured.RestAssured.when;

public class RestUtils {

    public static void validateResponseCode(String endpoint, int statusCode) {
        when()
                .get(endpoint)
                .then()
                .statusCode(statusCode);
    }

}
