package org.example;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;
import static org.testng.Assert.assertEquals;

public class RequestMethodsTest {

    @BeforeClass
    public void setup() {
        RestAssured.baseURI = "https://postman-echo.com";
    }

    @Test
    public void testGetRequest() {
        Response response = given()
                .queryParam("foo1", "bar1")
                .queryParam("foo2", "bar2")
                .when()
                .get("/get")
                .then()
                .statusCode(200)
                .extract()
                .response();

        // Проверка тела ответа
        String foo1 = response.jsonPath().getString("args.foo1");
        String foo2 = response.jsonPath().getString("args.foo2");

        assertEquals(foo1, "bar1", "Incorrect value for foo1");
        assertEquals(foo2, "bar2", "Incorrect value for foo2");
    }

    @Test
    public void testPostRawText() {
        String requestBody = "This is expected to be sent back as part of response body.";

        Response response = given()
                .header("Content-Type", "text/plain")
                .body(requestBody)
                .when()
                .post("/post")
                .then()
                .statusCode(200)
                .extract()
                .response();

        // Проверка тела ответа
        String data = response.jsonPath().getString("data");

        assertEquals(data, requestBody, "Incorrect value for data");
    }

    @Test
    public void testPostFormData() {
        Response response = given()
                .formParam("foo1", "bar1")
                .formParam("foo2", "bar2")
                .when()
                .post("/post")
                .then()
                .statusCode(200)
                .extract()
                .response();

        // Проверка тела ответа
        String foo1 = response.jsonPath().getString("form.foo1");
        String foo2 = response.jsonPath().getString("form.foo2");

        assertEquals(foo1, "bar1", "Incorrect value for foo1");
        assertEquals(foo2, "bar2", "Incorrect value for foo2");
    }

    @Test
    public void testPutRequest() {
        String requestBody = "This is expected to be sent back as part of response body.";

        Response response = given()
                .header("Content-Type", "text/plain")
                .body(requestBody)
                .when()
                .put("/put")
                .then()
                .statusCode(200)
                .extract()
                .response();

        // Проверка тела ответа
        String data = response.jsonPath().getString("data");

        assertEquals(data, requestBody, "Incorrect value for data");
    }

    @Test
    public void testPatchRequest() {
        String requestBody = "This is expected to be sent back as part of response body.";

        Response response = given()
                .header("Content-Type", "text/plain")
                .body(requestBody)
                .when()
                .patch("/patch")
                .then()
                .statusCode(200)
                .extract()
                .response();

        // Проверка тела ответа
        String data = response.jsonPath().getString("data");

        assertEquals(data, requestBody, "Incorrect value for data");
    }

    @Test
    public void testDeleteRequest() {
        String requestBody = "This is expected to be sent back as part of response body.";

        Response response = given()
                .header("Content-Type", "text/plain")
                .body(requestBody)
                .when()
                .delete("/delete")
                .then()
                .statusCode(200)
                .extract()
                .response();

        // Проверка тела ответа
        String data = response.jsonPath().getString("data");

        assertEquals(data, requestBody, "Incorrect value for data");
    }
}