package edu.uci.ics.vincevt1.service.people.resources;

import edu.uci.ics.vincevt1.service.people.logger.ServiceLogger;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("test") // Outer path
public class TestPage {
    @Path("hello") // This function's path
    @GET // Type of request
    @Produces(MediaType.APPLICATION_JSON)
    public Response helloWorld() {
        System.err.println("Hello world!");
        ServiceLogger.LOGGER.info("Hello!");
        return Response.status(Response.Status.OK).build();
    }
}
