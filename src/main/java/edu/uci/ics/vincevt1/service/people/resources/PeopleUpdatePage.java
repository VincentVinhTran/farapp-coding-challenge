package edu.uci.ics.vincevt1.service.people.resources;

import com.fasterxml.jackson.databind.ObjectMapper;
import edu.uci.ics.vincevt1.service.people.core.PeopleHelper;
import edu.uci.ics.vincevt1.service.people.models.UpdatePersonRequestModel;

import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.HttpHeaders;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.io.IOException;

@Path("update")
public class PeopleUpdatePage {
    @POST
    @Produces(MediaType.APPLICATION_JSON)
    public Response updatePerson(@Context HttpHeaders headers, String jsonText) {
        UpdatePersonRequestModel requestModel;
        ObjectMapper mapper = new ObjectMapper();
        try {
            requestModel = mapper.readValue(jsonText, UpdatePersonRequestModel.class);
        } catch (IOException e) {
            return Response.status(Response.Status.BAD_REQUEST).build();
        }

        if(!PeopleHelper.updatePerson(requestModel)) {
            return Response.status(Response.Status.BAD_REQUEST).build();
        }

        return Response.status(Response.Status.OK).build();
    }
}