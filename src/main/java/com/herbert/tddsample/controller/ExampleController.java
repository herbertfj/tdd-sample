package com.herbert.tddsample.controller;

import com.herbert.tddsample.model.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ExampleController {

    @Autowired
    PersonRepository personRepository;

    @RequestMapping(value = "/person", method = RequestMethod.GET)
    public ResponseEntity<Person> getPerson() {
        return new ResponseEntity<>(personRepository.findAll().get(0), HttpStatus.OK);
    }

    @RequestMapping(value = "/person/{name}", method = RequestMethod.POST)
    public ResponseEntity<Person> postPerson(@PathVariable String name) {
        Person person = new Person();
        person.setName(name);
        person = personRepository.save(person);
        return new ResponseEntity<>(person, HttpStatus.CREATED);
    }

}
