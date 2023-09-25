package guru.qa.tests;

import com.codeborne.selenide.conditions.Value;
import io.restassured.http.ContentType;
import io.restassured.internal.common.assertion.Assertion;
import io.restassured.matcher.ResponseAwareMatcher;
import io.restassured.response.Response;
import org.assertj.core.api.InstanceOfAssertFactories;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.*;

import static com.google.common.base.Predicates.equalTo;
import static io.restassured.RestAssured.given;
import static io.restassured.RestAssured.when;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.BDDAssertions.then;
import static org.assertj.core.api.InstanceOfAssertFactories.MAP;
import static org.hamcrest.Matchers.in;
import static org.hamcrest.Matchers.is;

public class RecresApiTests {
    @Test
    void recresApiTests1() {

        given()
                .when()
                        .get("https://reqres.in/api/users?page=2")
                .then()
                .body("page", is(2))
                .statusCode(200);

    }
    @Test
    void recresApiTests2() {
        List<Integer> value = Arrays.asList(7, 8, 9, 10, 11, 12);

        given()
                .when()
                .get("https://reqres.in/api/users?page=2")
                .then()
                .body("data.id", is(value));

    }
    @Test
    void recresApiTests3() {
        String body = "{ \"name\": \"morpheus\", \"job\": \"leader\" }";

        given()
                .body(body)
                .contentType(ContentType.JSON)
                .when()
                .post("https://reqres.in/api/users")
                .then()
                .statusCode(201)
                .body("name", is("morpheus"))
                .body("job", is("leader"));
    }
    @Test
    void recresApiTests4() {
        String body = "{ \"email\": \"eve.holt@reqres.in\", \"password\": \"cityslicka\" }";

        given()
                .body(body)
                .contentType(ContentType.JSON)
                .when()
                .post("https://reqres.in/api/login")
                .then()
                .statusCode(200)
                .body("token", is("QpwL5tke4Pnpja7X4"));
    }
    @Test
    void recresApiTests5() {
    String body = "{ \"name\": \"morpheus\", \"job\": \"zion resident\" }";
        given()
                .body(body)
                .contentType(ContentType.JSON)
                .when()
                .put("https://reqres.in/api/users/2")
                .then()
                .statusCode(200)
                .body("name", is("morpheus"))
                .body ("job", is("zion resident"));
    }
}
