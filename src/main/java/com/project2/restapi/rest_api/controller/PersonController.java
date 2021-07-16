package com.project2.restapi.rest_api.controller;

import java.util.List;

import javax.validation.Valid;

import com.project2.restapi.rest_api.dto.request.PersonDTO;
import com.project2.restapi.rest_api.dto.response.MessageResponseDTO;
import com.project2.restapi.rest_api.entity.Person;
import com.project2.restapi.rest_api.exception.PersonNotFoundException;
import com.project2.restapi.rest_api.repository.PersonRepository;
import com.project2.restapi.rest_api.service.PersonService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/api/v1/people")
public class PersonController {
    
    private PersonService personService;

    @Autowired
    public PersonController(PersonService personService) {
        this.personService = personService;
    }

   @PostMapping
   public MessageResponseDTO createPerson(@RequestBody @Valid PersonDTO personDTO){
       return personService.createPerson(personDTO);
   }
    
//    @PostMapping
//    public MessageResponseDTO createPerson(@RequestBody Person person){
//        return personService.createPerson(person);
//    }
    @GetMapping
    public List<PersonDTO> listAll(){
        return personService.listAll();
    }

    @GetMapping("/{id}")
    public PersonDTO findById(@PathVariable Long id) throws PersonNotFoundException{
        return personService.findaById(id);
    }

    @PutMapping("/{id}")
    public MessageResponseDTO updateById(@PathVariable Long id, @RequestBody @Valid PersonDTO personDTO) throws PersonNotFoundException{
        return personService.updateById(id, personDTO);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(code = HttpStatus.NO_CONTENT)
    public void deleteById(@PathVariable Long id) throws PersonNotFoundException{
        personService.deleteById(id);
    }
}
