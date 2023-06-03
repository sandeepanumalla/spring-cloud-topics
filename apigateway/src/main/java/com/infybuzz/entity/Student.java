package com.infybuzz.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Student {
    @Id
    @SequenceGenerator(name = "student_id_gen",sequenceName = "student_id_gen", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "student_id_gen")
    private long id;
    private String firstName;
    private String lastName;
    private String email;

    @OneToOne
    @JoinColumn(name = "address_id")
    private Address address;
    private String city;
}
