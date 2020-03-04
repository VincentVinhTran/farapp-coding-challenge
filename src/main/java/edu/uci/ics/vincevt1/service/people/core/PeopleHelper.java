package edu.uci.ics.vincevt1.service.people.core;

import edu.uci.ics.vincevt1.service.people.PeopleService;
import edu.uci.ics.vincevt1.service.people.logger.ServiceLogger;
import edu.uci.ics.vincevt1.service.people.models.GetPeopleResponseModel;
import edu.uci.ics.vincevt1.service.people.models.PersonModel;
import edu.uci.ics.vincevt1.service.people.models.UpdatePersonRequestModel;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class PeopleHelper {

    public static GetPeopleResponseModel retrievePeople(String sort) {

        GetPeopleResponseModel responseModel = new GetPeopleResponseModel();
        ArrayList<PersonModel> people = new ArrayList<>();

        try {
            // Construct the query
            String query =  "SELECT * FROM people ORDER BY ?";

            // Create the prepared statement
            PreparedStatement ps = PeopleService.getCon().prepareStatement(query);

            if(sort.equals("name")) {
                ps.setString(1, sort);
            } else if (sort.equals("email")) {
                ps.setString(1, sort);
            } else {
                ps.setString(1, "name");
            }

            ServiceLogger.LOGGER.info("Trying query: " + ps.toString());
            ResultSet rs = ps.executeQuery();
            ServiceLogger.LOGGER.info("Query succeeded.");

            while (rs.next()) {
                String email = rs.getString("email");
                String firstname = rs.getString("firstname");
                String lastname = rs.getString("lastname");
                String phone = rs.getString("phone");
                people.add(new PersonModel(firstname, lastname, email, phone));
                //ServiceLogger.LOGGER.info("Retrieved " + firstname + " " + lastname);
            }

        } catch (SQLException e) {
            ServiceLogger.LOGGER.warning("Query failed: Unable to retrieve records.");
            e.printStackTrace();
        }

        responseModel.setMessage("Retrieved people");
        responseModel.setPeople((PersonModel[])people.toArray());

        return responseModel;
    }


    public static Boolean updatePerson(UpdatePersonRequestModel requestModel) {
        try {
            // Construct the query
            String q1 =  "UPDATE peopledb.people ";
            String q2 = "SET ";
            String q3 = "WHERE firstname = ? AND lastname = ?;";

            if(requestModel.getEmail() == null && requestModel.getPhone() == null) {
                return false;
            }

            if(requestModel.getEmail() != null) {
                q2 += "email = \'" + requestModel.getEmail() + "\' ";
            }

            if(requestModel.getPhone() != null) {
                q2 += "phone = \'" + requestModel.getPhone() + "\' ";
            }

            // Create the prepared statement
            PreparedStatement ps = PeopleService.getCon().prepareStatement(q1 + q2 + q3);

            ps.setString(1, requestModel.getFirstname());
            ps.setString(2, requestModel.getLastname());

            ServiceLogger.LOGGER.info("Trying query: " + ps.toString());
            ps.executeUpdate();
            ServiceLogger.LOGGER.info("Query succeeded.");

        } catch (SQLException e) {
            ServiceLogger.LOGGER.warning("Query failed: Unable to retrieve records.");
            e.printStackTrace();
            return false;
        }

        return true;
    }
}