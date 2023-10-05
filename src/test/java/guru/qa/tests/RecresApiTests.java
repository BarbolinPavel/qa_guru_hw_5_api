package guru.qa.tests;

import guru.qa.tests.models.lombok.*;
import io.restassured.RestAssured;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

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
import static org.assertj.core.api.FactoryBasedNavigableListAssert.assertThat;
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

//    @Disabled
    @Test
    void addEmployeeTest() {
        AddEmloyeeBodyLombokModel addBodyEmploee = new AddEmloyeeBodyLombokModel();
        addBodyEmploee.setBodyName("morpheus");
        addBodyEmploee.setBodyJob("leader");
        AddEmloyeeResponseLombokModel response = given()
                .spec(addEmployeeRequestSpec)
                .body(addBodyEmploee)
                .when()
                .post()
                .then()
                .spec(addEmployeeResponseSpec)
                .extract().as(AddEmloyeeResponseLombokModel.class);
                //.body("name", is("morpheus"))
                //.body("job", is("leader"));
        assertEquals("morpheus", response.getBodyName());
        assertEquals("leader", response.getBodyJob());
    }
    @Test
    void loginEmployeeTest() {
        LoginBodyLombokModel loginBody = new LoginBodyLombokModel();
        loginBody.setEmail("eve.holt@reqres.in");
        loginBody.setPassword("cityslicka");

        LoginResponseLombokModel response = given()
                .spec(loginEmployeeRequestSpec)
                .body(loginBody)
                .when()
                .post()
                .then()
                .spec(loginEmployeeResponseSpec)
                .extract().as(LoginResponseLombokModel.class);

        assertEquals("QpwL5tke4Pnpja7X4", response.getToken());

    }
    @Test
    void changeJobEmployeeTest() {
        ChangeJobEmployeeBodyLombokModel body = new ChangeJobEmployeeBodyLombokModel();
        body.setChangeBodyName("morpheus");
        body.setChangeBodyJob("zion resident");

        ChangeJobEmployeeResponseLombokModel response = given()
                .spec(changeJobEmployeeRequestSpec)
                .body(body)
                .when()
                .put()
                .then()
                .spec(changeJobEmployeeResponseSpec)
                .extract().as(ChangeJobEmployeeResponseLombokModel.class);
        assertEquals("morpheus", response.getChangeBodyName());
        assertEquals("zion resident", response.getChangeBodyJob());
    }
}
