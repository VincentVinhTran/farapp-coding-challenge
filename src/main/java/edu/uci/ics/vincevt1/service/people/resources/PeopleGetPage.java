package edu.uci.ics.vincevt1.service.people.resources;

import com.fasterxml.jackson.databind.ObjectMapper;
import edu.uci.ics.vincevt1.service.people.core.PeopleHelper;
import edu.uci.ics.vincevt1.service.people.models.GetPeopleResponseModel;
import edu.uci.ics.vincevt1.service.people.models.PersonModel;
import edu.uci.ics.vincevt1.service.people.models.UpdatePersonRequestModel;

import javax.ws.rs.*;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.HttpHeaders;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.io.IOException;

@Path("get")
public class PeopleGetPage {
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response getPeople(@Context HttpHeaders headers, @QueryParam("sort") String sort) {
        GetPeopleResponseModel responseModel = PeopleHelper.retrievePeople(sort);

        return Response.status(Response.Status.OK).entity(responseModel).build();
    }
}