package com.example.service;

import com.example.entity.Student;
import com.example.feignclients.AddressFeignClients;
import com.example.repository.StudentRepository;
import com.example.request.StudentRequest;
import com.example.response.AddressResponse;
import com.example.response.StudentResponse;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

@Service
public class StudentService {


    private final StudentRepository studentRepository;

    private final WebClient webClient;

    private final ModelMapper modelMapper;

    private final AddressFeignClients addressFeignClients;

    @Autowired
    public StudentService(StudentRepository studentRepository, WebClient webClient, ModelMapper modelMapper, AddressFeignClients addressFeignClients) {
        this.studentRepository = studentRepository;
        this.webClient = webClient;
        this.modelMapper = modelMapper;
        this.addressFeignClients = addressFeignClients;
    }

    public StudentResponse createStudent(StudentRequest createStudentRequest) {

        Student student = new Student();
        student.setFirstName(createStudentRequest.getFirstName());
        student.setLastName(createStudentRequest.getLastName());
        student.setEmail(createStudentRequest.getEmail());

        student.setAddressId(createStudentRequest.getAddressId());
        student = studentRepository.save(student);

        StudentResponse studentResponse = modelMapper.map(student, StudentResponse.class);

//        studentResponse.setAddressResponse(getAddressById(student.getAddressId()));
        studentResponse.setAddressResponse(addressFeignClients.getById(student.getAddressId()));
         return studentResponse;
    }

    public StudentResponse getById (long id) {
        Student student = studentRepository.findById(id).get();
        StudentResponse studentResponse = modelMapper.map(student, StudentResponse.class);

//        studentResponse.setAddressResponse(getAddressById(student.getAddressId()));

        studentResponse.setAddressResponse(addressFeignClients.getById(student.getAddressId()));
        return studentResponse;
    }

    public AddressResponse getAddressById (long addressId) {
        Mono<AddressResponse> addressResponse =
                webClient.get().uri("/" + addressId)
                        .retrieve().bodyToMono(AddressResponse.class);

        return addressResponse.block();
    }
}
