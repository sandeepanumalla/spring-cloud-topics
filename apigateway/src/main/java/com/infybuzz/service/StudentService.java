package com.infybuzz.service;

import com.infybuzz.entity.Address;
import com.infybuzz.entity.Student;
import com.infybuzz.repository.AddressRepository;
import com.infybuzz.repository.StudentRepository;
import com.infybuzz.request.CreateStudentRequest;
import com.infybuzz.response.StudentResponse;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StudentService {

    private final AddressRepository addressRepository;
    private final StudentRepository studentRepository;
    private final ModelMapper modelMapper;

    @Autowired
    public StudentService(AddressRepository addressRepository,
                          StudentRepository studentRepository, ModelMapper modelMapper) {
        this.addressRepository = addressRepository;
        this.studentRepository = studentRepository;
        this.modelMapper = modelMapper;
    }

    public StudentResponse createStudent(CreateStudentRequest createStudentRequest) {
        Address address = Address.builder()
                .street(createStudentRequest.getStreet())
                .city(createStudentRequest.getCity())
                .build();

        address = addressRepository.save(address);

        Student student = Student.builder()
                .firstName(createStudentRequest.getFirstName())
                .lastName(createStudentRequest.getLastName())
                .email(createStudentRequest.getEmail())
                .address(address)
                .build();

        student = studentRepository.save(student);

        StudentResponse studentResponse = modelMapper.map(student, StudentResponse.class);
        return studentResponse;
    }

    public StudentResponse getStudentById(long id) {
         Student student = studentRepository.getById(id);
         StudentResponse studentResponse = modelMapper.map(student, StudentResponse.class);
         return studentResponse;
    }
}
