package ru.Ilnur.SimbirSoftTests;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import jdk.jfr.Description;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.*;

public class RestAssuredTests {

    @BeforeAll
    public static void setUp() {
        RestAssured.baseURI = "https://reqres.in";
    }

    @Description("Проверить, что у пользователя George Bluth e-mail = george.bluth@reqres.in")
    @Test
    public void checkGeorgeBluthEmail() {
        given().contentType(ContentType.JSON)
                .when()
                .get("/api/users")
                .then()
                .statusCode(200)
                .body("data.find{it.last_name = \"Bluth\"}.email", equalTo("george.bluth@reqres.in"));
//                .extract().response().prettyPrint();
    }


    @Description("Проверить что у пользователя Michael Lawson e-mail  michael.lawson@reqres")
    @Test
    public void checkMichaelLawsonCorrectEmail() {
        given().contentType(ContentType.JSON)
                .queryParam("page","2")
                .when()
                .get("/api/users")
                .then()
                .statusCode(200)
                .body("data.find{it.last_name = \"Lawson\"}.email", equalTo("michael.lawson@reqres.in"));
//                .extract().response().prettyPrint();
    }





}
