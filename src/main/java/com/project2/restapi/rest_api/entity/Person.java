package com.project2.restapi.rest_api.entity;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor

public class Person {

    @Id
    @GeneratedValue
     private Long id;

     @Column(nullable = false)
     private String firstName;

     @Column(nullable = false)
     private String lastName;

     @Column(nullable = false, unique = true)
     private String cpf;

     @Column(nullable = false)
     private LocalDate birthDate;

     @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
     private List<Phone> phones;
}
