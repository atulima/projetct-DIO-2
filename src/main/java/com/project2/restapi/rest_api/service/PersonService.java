package com.project2.restapi.rest_api.service;

import java.lang.StackWalker.Option;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import com.project2.restapi.rest_api.dto.request.PersonDTO;
import com.project2.restapi.rest_api.dto.response.MessageResponseDTO;
import com.project2.restapi.rest_api.entity.Person;
import com.project2.restapi.rest_api.exception.PersonNotFoundException;
import com.project2.restapi.rest_api.mapper.PersonMapper;
import com.project2.restapi.rest_api.repository.PersonRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PersonService {
    
    private PersonRepository personRepository;
    private final PersonMapper personMapper = PersonMapper.INSTANCE;

    @Autowired
    public PersonService(PersonRepository personRepository){
        this.personRepository = personRepository;
    }

    // public MessageResponseDTO createPerson(Person person){
    //     // Person personToSave = personMapper.toModel(personDTO);
    //     Person savedPerson = personRepository.save(person);
    //     return MessageResponseDTO.builder()
    //         .message("Created person with ID " + savedPerson.getId())
    //         .build();

    // }

    public MessageResponseDTO createPerson(PersonDTO personDTO){
        Person personToSave = personMapper.toModel(personDTO);
        Person savedPerson = personRepository.save(personToSave);
        return MessageResponseDTO.builder()
            .message("Created person with ID " + savedPerson.getId())
            .build();

    }

    public List<PersonDTO> listAll() {
        List<Person> allPeople = personRepository.findAll();
        return allPeople.stream()
            .map(personMapper::toDTO)
            .collect(Collectors.toList());
    }

    public PersonDTO findaById(Long id) throws PersonNotFoundException {
        Person person = personRepository.findById(id).orElseThrow(() -> new PersonNotFoundException(id));
        // Same code for the function above

        // Optional<Person> oprtionalPerson = personRepository.findById(id);
        // if(oprtionalPerson.isEmpty()){
        //     throw new PersonNotFoundException(id); 
        // }
        return personMapper.toDTO(person);
        
    }

    public void deleteById(Long id) throws PersonNotFoundException {
        personRepository.findById(id).orElseThrow(() -> new PersonNotFoundException(id));
        personRepository.deleteById(id);
    }
}
