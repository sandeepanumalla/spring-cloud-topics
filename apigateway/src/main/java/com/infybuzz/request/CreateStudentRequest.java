package com.infybuzz.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CreateStudentRequest {

    private String firstName;
    private String lastName;
    private String email;
    private String street;
    private String city;

}
