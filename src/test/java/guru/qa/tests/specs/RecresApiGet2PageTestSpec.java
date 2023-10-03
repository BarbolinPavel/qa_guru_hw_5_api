package guru.qa.tests.specs;

import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.filter.log.LogDetail;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;

import static io.restassured.RestAssured.with;
import static org.hamcrest.Matchers.is;

public class RecresApiGet2PageTestSpec {
    public static RequestSpecification recresApiGet2PageRequestSpec = with()
            .basePath("/users?page=2");

    public static ResponseSpecification recresApiGet2PageResponseSpec = new ResponseSpecBuilder()
            .log(LogDetail.BODY)
            .expectBody("page", is(2))
            .expectStatusCode(200)
            .build();
}
