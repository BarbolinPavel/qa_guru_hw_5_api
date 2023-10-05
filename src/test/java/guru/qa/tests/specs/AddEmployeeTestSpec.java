package guru.qa.tests.specs;

import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.filter.log.LogDetail;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;

import static io.restassured.RestAssured.with;

public class AddEmployeeTestSpec {
    public static RequestSpecification addEmployeeRequestSpec = with()
            .basePath("/users")
            .contentType(ContentType.JSON);

    public static ResponseSpecification addEmployeeResponseSpec = new ResponseSpecBuilder()
            .expectStatusCode(201)
            .log(LogDetail.BODY)
            .build();

}
