package ru.netology.data;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.filter.log.LogDetail;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;


import static io.restassured.RestAssured.given;


public class RestApiHelper {
    private static RequestSpecification requestSpec = new RequestSpecBuilder()
            .setBaseUri("http://localhost")
            .setPort(8080)
            .setAccept(ContentType.JSON)
            .setContentType(ContentType.JSON)
            .log(LogDetail.ALL)
            .build();

    public static void cardInfo(DataHelper.CardInfo cardInfo, String path) {
        given()
                .spec(requestSpec)
                .body(cardInfo)
                .when()
                .post(path)
                .then()
                .statusCode(200)
                .statusCode(400);
    }

}
