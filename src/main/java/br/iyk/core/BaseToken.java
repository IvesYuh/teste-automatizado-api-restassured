package br.iyk.core;

import static io.restassured.RestAssured.given;

import java.util.HashMap;
import java.util.Map;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;

public class BaseToken {
    private static final String TOKEN_INSTALL = "token";
    private static final String ENDERECO = "http://999.99.99.99:123456/v1";
    
    public static String retornaTokenInstall() {
        Map<String, String> body = new HashMap<>();
        body.put("login", "Exemplo");
        body.put("senha", "123456");
        body.put("acessToken", TOKEN_INSTALL);
        
        return given()
        		.header("Authorization", TOKEN_INSTALL)
        		.contentType(ContentType.JSON)
        		.body(body)
            .when()
                .post(ENDERECO + "/install")
            .then()
            	.statusCode(200)
            	.extract().path("accessToken")
        ;
    }

    public static void retornaToken() {
        Map<String, String> body = new HashMap<>();
        body.put("login", "Exemplo");
        body.put("senha", "123456");
        String token = 
        	given()
                .header("Authorization", retornaTokenInstall()) 
                .contentType(ContentType.JSON)
                .body(body)
            .when()
                .post(ENDERECO + "/login")
            .then()
                .statusCode(200)
                .extract().path("token")
                ;
        RestAssured.requestSpecification.header("Authorization", "Bearer " + token);
    }
}
