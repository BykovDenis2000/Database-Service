package com.titles.databaseservice;

import org.springframework.data.annotation.Id;


public class HotCustomer {

    @Id
    public String id;

    public String firstName;
    public String lastName;

    public HotCustomer() {}

    public HotCustomer(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }

    @Override
    public String toString() {
        return String.format(
                "Customer[id=%s, firstName='%s', lastName='%s']",
                id, firstName, lastName);
    }

}

