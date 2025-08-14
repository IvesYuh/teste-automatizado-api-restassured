package br.iyk.core;


import org.junit.jupiter.api.BeforeAll;

import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.http.ContentType;

public class BaseTest {
	@BeforeAll
	static void endereco() {
        RestAssured.baseURI = "http://999.99.99.99";
        RestAssured.port = /*PortaDaApi*/ 123456;
        
        RestAssured.enableLoggingOfRequestAndResponseIfValidationFails();
        
        RequestSpecBuilder requestSpecBuilder = new RequestSpecBuilder();
		requestSpecBuilder.setContentType(ContentType.JSON);
		RestAssured.requestSpecification = requestSpecBuilder.build();
    }
}
