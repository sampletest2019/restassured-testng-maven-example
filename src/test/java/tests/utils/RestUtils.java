package tests.utils;

import static io.restassured.RestAssured.when;
import static org.hamcrest.Matchers.equalTo;

public class RestUtils {

    public static void validateResponseCode(String endpoint, int statusCode) {
        when()
                .get(endpoint)
                .then()
                .statusCode(statusCode);
    }

//    public static void sendRequestAndValidateResponseValue(String endpoint, String requestType, String name, int value) {
//        when().request(requestType, endpoint)
//        .then()
//                .statusCode(200)
//                .assertThat()
//                .body(name, equalTo(value));
//    }

}
