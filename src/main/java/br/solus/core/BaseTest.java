package br.solus.core;


import org.junit.jupiter.api.BeforeAll;

import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.http.ContentType;

public class BaseTest {
	@BeforeAll
	static void endereco() {
        RestAssured.baseURI = "http://172.16.80.21";
        RestAssured.port = PortaDaApi;
        
        RestAssured.enableLoggingOfRequestAndResponseIfValidationFails();
        
        RequestSpecBuilder requestSpecBuilder = new RequestSpecBuilder();
		requestSpecBuilder.setContentType(ContentType.JSON);
		RestAssured.requestSpecification = requestSpecBuilder.build();
    }
}
