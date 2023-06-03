package com.infybuzz.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "Address")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Address {

    @Id
    @SequenceGenerator(name = "address_gen", sequenceName = "address_gen", allocationSize = 1)
    @GeneratedValue( strategy = GenerationType.SEQUENCE, generator = "address_gen")
    @Column(name = "id")
    private long Id;
    private String street;
    private String city;
}
