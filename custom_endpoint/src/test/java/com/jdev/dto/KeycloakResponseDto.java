package com.jdev.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.NoArgsConstructor;

/*
 * https://www.keycloak.org/docs-api/latest/rest-api/index.html#_users
 * */
@NoArgsConstructor
@Data
public class KeycloakResponseDto {
    @JsonProperty("access_token")
    private String accessToken;
    @JsonProperty("expires_in")
    private String expiresIn;
    @JsonProperty("refresh_expires_in")
    private String refreshExpiresIn;
    @JsonProperty("token_type")
    private String tokenType;
    @JsonProperty("not-before-policy")
    private String notBeforePolicy;
    @JsonProperty
    private String scope;
}