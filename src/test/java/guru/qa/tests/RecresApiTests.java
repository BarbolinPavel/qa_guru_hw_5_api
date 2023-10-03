package guru.qa.tests;

import guru.qa.tests.models.lombok.AddEmloyeeLombokModel;
import guru.qa.tests.models.lombok.ChangeJobEmployeeLombokModel;
import guru.qa.tests.models.lombok.LoginBodyLombokModel;
import guru.qa.tests.models.lombok.LoginResponseLombokModel;
import io.qameta.allure.restassured.AllureRestAssured;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.util.*;

import static guru.qa.tests.specs.AddEmployeeTestSpec.addEmployeeRequestSpec;
import static guru.qa.tests.specs.AddEmployeeTestSpec.addEmployeeResponseSpec;
import static guru.qa.tests.specs.ChangeJobEmployeeTestSpec.changeJobEmployeeRequestSpec;
import static guru.qa.tests.specs.ChangeJobEmployeeTestSpec.changeJobEmployeeResponseSpec;
import static guru.qa.tests.specs.LoginEmployeeTestSpec.loginEmployeeRequestSpec;
import static guru.qa.tests.specs.LoginEmployeeTestSpec.loginEmployeeResponseSpec;
import static guru.qa.tests.specs.RecresApiGet2PageTestSpec.recresApiGet2PageRequestSpec;
import static guru.qa.tests.specs.RecresApiGet2PageTestSpec.recresApiGet2PageResponseSpec;
import static guru.qa.tests.specs.UserIdForSecondPageTestSpec.userIdForSecondPageRequestSpec;
import static guru.qa.tests.specs.UserIdForSecondPageTestSpec.userIdForSecondPageResponseSpec;
import static io.restassured.RestAssured.given;
import static io.restassured.RestAssured.requestSpecification;
import static org.hamcrest.Matchers.is;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class RecresApiTests {
    @BeforeEach
    void beforeEach(){
        RestAssured.baseURI = "https://reqres.in/api";
    }
    @Test
    void recresApiGet2PageTest() {

        given()
                .when()
                .spec(recresApiGet2PageRequestSpec)
                .then()
                .spec(recresApiGet2PageResponseSpec);
    }

    @Test
    void userIdForSecondPageTest() {

        given()
                .when()
                .spec(userIdForSecondPageRequestSpec)
                .then()
                .spec(userIdForSecondPageResponseSpec);
    }

    @Test
    void addEmployeeTest() {
        AddEmloyeeLombokModel addbodyEmploee = new AddEmloyeeLombokModel();
        addbodyEmploee.setBodyEmloyee("{ \"name\": \"morpheus\", \"job\": \"leader\" }");

        AddEmloyeeLombokModel response = given()
                .spec(addEmployeeRequestSpec)
                .body(addbodyEmploee)
                .when()
                .post()
                .then()
                .spec(addEmployeeResponseSpec)
                .extract().as(AddEmloyeeLombokModel.class);
                //.body("name", is("morpheus"))
                //.body("job", is("leader"));

        assertEquals("morpheus", response.getBodyEmloyee());
        assertEquals("leader", response.getBodyEmloyee());
    }
    @Test
    void loginEmployeeTest() {
        LoginBodyLombokModel login = new LoginBodyLombokModel();
        login.setEmail("eve.holt@reqres.in");
        login.setPassword("cityslicka");

        LoginResponseLombokModel response = given()
                .spec(loginEmployeeRequestSpec)
                .body(login)
                .when()
                .post()
                .then()
                .spec(loginEmployeeResponseSpec)
                .extract().as(LoginResponseLombokModel.class);

        assertEquals("QpwL5tke4Pnpja7X4", response.getToken());

    }
    @Test
    void changeJobEmployeeTest() {
        ChangeJobEmployeeLombokModel body = new ChangeJobEmployeeLombokModel();
        body.setChangeBody("{ \"name\": \"morpheus\", \"job\": \"zion resident\" }");

        ChangeJobEmployeeLombokModel response = given()
                .spec(changeJobEmployeeRequestSpec)
                .body(body)
                .when()
                .put()
                .then()
                .spec(changeJobEmployeeResponseSpec)
                .extract().as(ChangeJobEmployeeLombokModel.class);
        assertEquals("morpheus", response.getChangeBody());
        assertEquals("zion resident", response.getChangeBody());
    }
}
