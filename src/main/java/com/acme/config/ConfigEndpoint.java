package com.acme.config;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.core.Response;
import org.eclipse.microprofile.config.inject.ConfigProperty;

@Path("/")
public class ConfigEndpoint {

  @ConfigProperty(name = "my.prop")
  String myProp;

  @GET
  @Path("/config")
  public Response greeting() {
    return Response.ok(myProp).build();
  }
}
