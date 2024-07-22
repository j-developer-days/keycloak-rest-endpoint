package com.jdev.endpoint;

import jakarta.ws.rs.GET;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.ext.Provider;
import org.eclipse.microprofile.openapi.annotations.Operation;
import org.eclipse.microprofile.openapi.annotations.enums.SchemaType;
import org.eclipse.microprofile.openapi.annotations.media.Content;
import org.eclipse.microprofile.openapi.annotations.media.Schema;
import org.eclipse.microprofile.openapi.annotations.responses.APIResponse;
import org.jboss.logging.Logger;
import org.keycloak.models.KeycloakSession;
import org.keycloak.services.resource.RealmResourceProvider;

//https://github.com/el-abdel/keycloak-custom-rest-endpoint
//https://github.com/dasniko/keycloak-extensions-demo/tree/main/rest-endpoint
@Provider
//@Path("/custom")
//@jakarta.ws.rs.Path("/custom")
public class CustomEndpointResource implements RealmResourceProvider {

    private static final Logger logger = Logger.getLogger(CustomEndpointResource.class);

    private final KeycloakSession session;

    public CustomEndpointResource(KeycloakSession session) {
        this.session = session;
    }

    @javax.ws.rs.Path("/custom")
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
    public String customTest() {
        logger.info("called custom endpoint!");
        return "Test!";
    }

    @Override
    public Object getResource() {
        logger.info("CUSTOM RealmResourceProvider.getResource");
        return this;
    }


    @Override
    public void close() {
        logger.info("CUSTOM RealmResourceProvider.close");
    }
}
