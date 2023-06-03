package com.example.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import jakarta.persistence.Entity;


@Entity
@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "Address")
public class Address {
    @jakarta.persistence.Id
    @SequenceGenerator(name = "id_gen", sequenceName = "id_gen", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "id_gen")
    private Long id;
    private String street;
    private String city;
}
