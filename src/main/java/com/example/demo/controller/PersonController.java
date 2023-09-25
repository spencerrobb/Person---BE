package com.example.demo.controller;

import com.example.demo.entity.Person;
import com.example.demo.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/")
@CrossOrigin(origins= "http://localhost:3000")
public class PersonController {

    @Autowired
    PersonService personService;

    // retrieve a list of persons
    @GetMapping("/persons")
    public List<Person> getAllPersons(){
        return personService.getAllPerson();
    }

    //create a person rest api
    @PostMapping("/persons")
    public Person createPerson(@RequestBody Person person){
        System.out.println("FIRSTNAME"+person.getFirstName());
        return personService.createPerson(person);
    }

    // get person by id
    @GetMapping("/persons/{id}")
    public Person getPersonById(@PathVariable Long id){
        return personService.getPersonById(id);
    }

    // delete person by id
    @DeleteMapping("/persons/{id}")
    public void  deletePersonById(@PathVariable Long id){
         personService.deletePersonById(id);
    }

    //update a person record by id
    @PutMapping("/persons/{id}")
    public Person updatePersonById(@RequestBody Person personDetails, @PathVariable Long id){
        return personService.udpatePersonById(personDetails, id);
    }

    //deletes multiple records
    @DeleteMapping("/persons/multiple")
    public String deleteRecords (@RequestParam List<Long> ids) {
        return null;
    }

    //updates multiple records
    @PutMapping("/persons/multiple")
    public String dupdateRecords (@RequestParam List<Long> ids) {
        return null;
    }

}
