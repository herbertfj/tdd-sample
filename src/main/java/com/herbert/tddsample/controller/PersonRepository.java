package com.herbert.tddsample.controller;

import com.herbert.tddsample.model.Person;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Component;

@Component
public interface PersonRepository extends MongoRepository<Person, String> {

}
