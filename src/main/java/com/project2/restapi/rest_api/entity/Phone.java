package com.project2.restapi.rest_api.entity;

import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import com.project2.restapi.rest_api.enums.PhoneType;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Builder
@Data
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity

public class Phone {
    @Id
    @GeneratedValue
    private  Long id;

    @Column(nullable = false)
    private PhoneType type;

    @Column(nullable = false)
    private String number;
}
