package edu.uci.ics.vincevt1.service.people.models;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class UpdatePersonRequestModel {

    private String firstname;
    private String lastname;
    private String email;
    private String phone;

    @JsonCreator
    public UpdatePersonRequestModel(@JsonProperty(value = "firstname", required = true) String firstname,
                                    @JsonProperty(value = "lastname", required = true) String lastname,
                                    @JsonProperty(value = "email") String email,
                                    @JsonProperty(value = "phone") String phone) {
        this.firstname = firstname;
        this.lastname = lastname;
        this.email = email;
        this.phone = phone;
    }

    @JsonProperty(value = "firstname")
    public String getFirstname() {
        return firstname;
    }

    @JsonProperty(value = "lastname")
    public String getLastname() {
        return lastname;
    }

    @JsonProperty(value = "email")
    public String getEmail() {
        return email;
    }

    @JsonProperty(value = "phone")
    public String getPhone() {
        return phone;
    }
}