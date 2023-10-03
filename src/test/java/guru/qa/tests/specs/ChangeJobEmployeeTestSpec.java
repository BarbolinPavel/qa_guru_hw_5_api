package guru.qa.tests.specs;

import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;

import static io.restassured.RestAssured.with;

public class ChangeJobEmployeeTestSpec {
    public static RequestSpecification changeJobEmployeeRequestSpec = with()
            .basePath("/users/2")
            .contentType(ContentType.JSON);

    public static ResponseSpecification changeJobEmployeeResponseSpec = new ResponseSpecBuilder()
            .expectStatusCode(200)
            .build();
}
