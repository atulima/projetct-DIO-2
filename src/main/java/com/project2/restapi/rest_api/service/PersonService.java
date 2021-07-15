package com.project2.restapi.rest_api.service;

import com.project2.restapi.rest_api.dto.response.MessageResponseDTO;
import com.project2.restapi.rest_api.entity.Person;
import com.project2.restapi.rest_api.repository.PersonRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PersonService {
    
    private PersonRepository personRepository;

    @Autowired
    public PersonService(PersonRepository personRepository){
        this.personRepository = personRepository;
    }

    public MessageResponseDTO createPerson(Person person){
        Person savedPerson = personRepository.save(person);
        return MessageResponseDTO.builder()
            .message("Created person with ID " + savedPerson.getId())
            .build();

    }
}
