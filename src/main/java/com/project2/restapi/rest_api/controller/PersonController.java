package com.project2.restapi.rest_api.controller;

import com.project2.restapi.rest_api.dto.response.MessageResponseDTO;
import com.project2.restapi.rest_api.entity.Person;
import com.project2.restapi.rest_api.repository.PersonRepository;
import com.project2.restapi.rest_api.service.PersonService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/api/v1/people")
// @AllArgsConstructor(onConstructor = @__(@Autowired))
public class PersonController {
    

    private PersonService personService;
    
    @Autowired
    public PersonController(PersonService personService) {
        this.personService = personService;
        
    }
    
    @PostMapping
    @ResponseStatus(code = HttpStatus.CREATED)
    public MessageResponseDTO createPerson(@RequestBody Person person) {
        return personService.createPerson(person);
    }
    

}
