package com.example.demo.service;

import com.example.demo.entity.Person;
import com.example.demo.repository.PersonRespository;
import io.micrometer.common.util.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PersonService {

    @Autowired
    PersonRespository personRepository;

    public List<Person> getAllPerson(){
        return personRepository.findAll();
    }

    public Person createPerson(Person person) {

        Person newPerson = new Person();

        if(!StringUtils.isBlank(person.getFirstName()));{
            newPerson.setFirstName(person.getFirstName());
        }
        if(!StringUtils.isBlank(person.getLastName())){
            newPerson.setFirstName(person.getLastName());
        }
        if(!StringUtils.isBlank(person.getEmail())){
            newPerson.setEmail(person.getEmail());
        }

        personRepository.save(newPerson);

        return newPerson;
    }

    public Person getPersonById(Long id) {
        return personRepository.findById(id).get();
    }

    public void deletePersonById(Long id) {
        personRepository.deleteById(id);
    }

    public Person udpatePersonById(Person personDetails, Long id) {

        Person oldPerson = personRepository.findById(id).get();
        oldPerson.setUserId(personDetails.getUserId());
        oldPerson.setFirstName(personDetails.getFirstName());
        oldPerson.setMiddleName(personDetails.getMiddleName());
        oldPerson.setLastName(personDetails.getLastName());
        oldPerson.setEmail(personDetails.getEmail());
        oldPerson.setContactNumber(personDetails.getContactNumber());

        personRepository.save(oldPerson);
        return oldPerson;
    }
}
