package com.titles.databaseservice;

import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface HotRepository extends MongoRepository<HotCustomer, String> {
    public HotCustomer findByFirstName(String firstName);
    public List<HotCustomer> findByLastName(String lastName);
}
