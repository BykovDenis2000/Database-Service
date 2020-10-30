package com.titles.databaseservice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@EnableMongoRepositories(basePackageClasses = HotRepository.class)
@EnableJpaRepositories(basePackageClasses = ColdRepository.class)
@RestController
public class GreetingController {

    @Autowired
    private HotRepository hotRepository;

    @Autowired
    private ColdRepository coldRepository;

    @GetMapping("/hello")
    public String hello() throws Exception  {

        String names = "\n";

        for (HotCustomer customer : hotRepository.findAll()) {
            names += customer.toString() + "\n";
        }

        for (ColdCustomer customer : coldRepository.findAll()) {
            names += customer.toString() + "\n";
        }

        return "Hello: " + names;
    }

    @GetMapping("/")
    public String test()  {
        return "Working";
    }

    @GetMapping("/setup")
    public String setup()  {

        hotRepository.deleteAll();
        coldRepository.deleteAll();

        // save a couple of customers to mongo
        hotRepository.save(new HotCustomer("Alice", "Smith"));
        hotRepository.save(new HotCustomer("Bob", "Smith"));

        // save a couple of customers to postgres
        hotRepository.save(new HotCustomer("Nick", "Watson"));
        hotRepository.save(new HotCustomer("Emma", "Watson"));

        return "Setup done";
    }


}

