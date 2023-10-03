package guru.qa.tests.specs;

import guru.qa.tests.RecresApiTests;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;

import java.util.Arrays;
import java.util.List;

import static io.restassured.RestAssured.with;
import static org.hamcrest.Matchers.is;

public class UserIdForSecondPageTestSpec {
    static List<Integer> value = Arrays.asList(7, 8, 9, 10, 11, 12);

    public static RequestSpecification userIdForSecondPageRequestSpec = with()
            .basePath("/users?page=2");

    public static ResponseSpecification userIdForSecondPageResponseSpec = new ResponseSpecBuilder()
            .expectBody("data.id", is(value))
            .build();
}
