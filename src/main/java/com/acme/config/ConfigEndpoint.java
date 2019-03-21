package com.acme.config;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.core.Response;
import org.eclipse.microprofile.config.inject.ConfigProperty;
import org.eclipse.microprofile.openapi.annotations.Operation;
import org.eclipse.microprofile.openapi.annotations.media.Content;
import org.eclipse.microprofile.openapi.annotations.media.Schema;
import org.eclipse.microprofile.openapi.annotations.responses.APIResponse;
import org.eclipse.microprofile.openapi.annotations.responses.APIResponses;

@Path("/")
public class ConfigEndpoint {

  @ConfigProperty(name = "my.prop")
  String myProp;

  @GET
  @APIResponses(value = {@APIResponse(responseCode = "204", //
      description = "A response with no content", content = @Content(mediaType = "application/json",
          schema = @Schema(implementation = String.class)))})
  @Operation(summary = "Say Hello World")
  @Path("/config")
  public Response greeting() {
    return Response.ok(myProp).build();
  }
}
