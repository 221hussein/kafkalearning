package com.codartfun.kafkajsonmessage.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class User {

    private int id;
    private String firstName;
    private String lastName;

    public User() {
    }

    public User(String firstName, int id, String lastName) {
        this.firstName = firstName;
        this.id = id;
        this.lastName = lastName;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @JsonProperty("firstName")
    public String getFirstName() {
        return firstName;
    }


    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    @JsonProperty("lastName")
    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                '}';
    }
}
