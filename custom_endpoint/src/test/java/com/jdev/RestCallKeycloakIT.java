package com.jdev;

import com.jdev.dto.KeycloakResponseDto;
import io.restassured.RestAssured;
import io.restassured.http.Header;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import jakarta.ws.rs.core.MediaType;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import javax.ws.rs.core.HttpHeaders;
import java.util.stream.Collectors;

public class RestCallKeycloakIT {


    private static final String KEYCLOAK_URL_HTTP = "http://localhost:9101/";
    private static final String KEYCLOAK_REALM_URL_PART = "realms/master";

    @Test
    void test_keycloakCustomEndpoint() {
        Response response = getRequestSpecificationWithContentType().header(getKeycloakHeader())
                .get(KEYCLOAK_URL_HTTP + KEYCLOAK_REALM_URL_PART + "/custom-endpoint/custom");
        showResponse(response, "custom");
        Assertions.assertEquals(200, response.statusCode());
    }

    public static void showResponse(Response response, String endpointName) {
        consoleDelimiter(endpointName);
        System.out.println("statusCode - " + response.statusCode());
        System.out.println("headers - \n\t" + response.getHeaders()
                .asList()
                .stream()
                .map(header -> header.getName() + " : " + header.getValue())
                .collect(Collectors.joining(";\n\t")));
        System.out.println("body - " + response.getBody().asPrettyString());
        consoleDelimiter("");
    }

    protected RequestSpecification getRequestSpecificationWithContentType() {
        return RestAssured.given().header(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON);
    }

    private Header getKeycloakHeader() {
        KeycloakResponseDto keycloakResponseDto = getKeycloakResponseDto();
        return new Header(HttpHeaders.AUTHORIZATION,
                keycloakResponseDto.getTokenType() + " " + keycloakResponseDto.getAccessToken());
    }

    private KeycloakResponseDto getKeycloakResponseDto() {
        Response post = RestAssured.given()
                .contentType(MediaType.APPLICATION_FORM_URLENCODED)
                .formParam("grant_type", "client_credentials")
                .formParam("client_id", "test_client")
                .formParam("client_secret", "Q2eQQyqmr86ISTQJrEgbmXJ8yL28WXTb")
                .when()
                .post(KEYCLOAK_URL_HTTP + KEYCLOAK_REALM_URL_PART + "/protocol/openid-connect/token");

        showResponse(post, "protocol/openid-connect/token");
        return post.getBody().as(KeycloakResponseDto.class);
    }

    private static void consoleDelimiter(String message) {
        System.out.println("***************************[" + message + "]***************************");
    }
}
