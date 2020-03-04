package edu.uci.ics.vincevt1.service.people.models;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class GetPeopleResponseModel {

    @JsonProperty(value = "message", required = true)
    private String message;

    @JsonProperty(value = "people", required = true)
    private PersonModel[] people;

    @JsonCreator
    public GetPeopleResponseModel(@JsonProperty(value = "message", required = true) String message,
                                  @JsonProperty(value = "people", required = true) PersonModel[] people) {
        this.message = message;
        this.people = people;
    }

    public GetPeopleResponseModel() {
    }

    @JsonProperty("message")
    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    @JsonProperty("people")
    public PersonModel[] getPeople() {
        return people;
    }

    public void setPeople(PersonModel[] people) {
        this.people = people;
    }
}