package com.jdev.endpoint;

import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.ext.Provider;
import org.eclipse.microprofile.openapi.annotations.Operation;
import org.eclipse.microprofile.openapi.annotations.enums.SchemaType;
import org.eclipse.microprofile.openapi.annotations.media.Content;
import org.eclipse.microprofile.openapi.annotations.media.Schema;
import org.eclipse.microprofile.openapi.annotations.responses.APIResponse;
import org.jboss.logging.Logger;

//https://github.com/el-abdel/keycloak-custom-rest-endpoint
//https://github.com/dasniko/keycloak-extensions-demo/tree/main/rest-endpoint
@Provider
@javax.ws.rs.ext.Provider
@javax.ws.rs.Path("/")
@Path("/")
public class CustomEndpointResource {

    private static final Logger logger = Logger.getLogger(CustomEndpointResource.class);

    @javax.ws.rs.Path("custom")
    @Path("custom")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Operation(
            summary = "Public hello endpoint",
            description = "This endpoint returns hello and the name of the requested realm."
    )
    @APIResponse(
            responseCode = "200",
            description = "",
            content = {@Content(
                    schema = @Schema(
                            implementation = String.class,
                            type = SchemaType.STRING
                    )
            )}
    )
    public jakarta.ws.rs.core.Response customTest() {
        logger.info("called custom endpoint!");
        return jakarta.ws.rs.core.Response.ok("Test!").build();
    }/*
    public String customTest() {
        logger.info("called custom endpoint!");
        return "Test!";
    }*/

}
