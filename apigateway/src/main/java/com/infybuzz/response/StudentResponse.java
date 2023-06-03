package com.infybuzz.response;

import com.infybuzz.entity.Student;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class StudentResponse {
    private long id;
    private String firstName;
    private String lastName;
    private String email;
    private String street;
    private String city;

    public StudentResponse(Student student) {

    }
}
