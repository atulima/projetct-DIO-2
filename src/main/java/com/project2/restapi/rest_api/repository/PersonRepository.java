package com.project2.restapi.rest_api.repository;

import com.project2.restapi.rest_api.entity.Person;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PersonRepository extends JpaRepository<Person, Long> {
    
}
