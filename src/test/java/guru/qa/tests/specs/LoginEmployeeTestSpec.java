package guru.qa.tests.specs;

import io.qameta.allure.restassured.AllureRestAssured;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.filter.log.LogDetail;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;

import static io.restassured.RestAssured.with;

public class LoginEmployeeTestSpec {
    public static RequestSpecification loginEmployeeRequestSpec = with()
            .basePath("/login")
            .filter(new AllureRestAssured())
            .contentType(ContentType.JSON);


    public static ResponseSpecification loginEmployeeResponseSpec = new ResponseSpecBuilder()
            .log(LogDetail.STATUS)
            .log(LogDetail.BODY)
            .expectStatusCode(200)
            .build();
}
