package com.example.service;

import com.example.entity.Address;
import com.example.repository.AddressRepository;
import com.example.request.AddressRequest;
import com.example.response.AddressResponse;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AddressService {

    private final AddressRepository addressRepository;
    private final ModelMapper modelMapper;

    @Autowired
    public AddressService(AddressRepository addressRepository, ModelMapper modelMapper) {
        this.addressRepository = addressRepository;
        this.modelMapper = modelMapper;
    }

    public AddressResponse createAddress(AddressRequest addressRequest) {
        Address address = Address.builder()
                .street(addressRequest.getStreet())
                .city(addressRequest.getCity())
                .build();

        Address savedAddress = addressRepository.save(address);
        return modelMapper.map(savedAddress, AddressResponse.class);
    }

    public AddressResponse getById(Long id) {
        Address address = addressRepository.findById(id).orElseThrow();
        return modelMapper.map(address, AddressResponse.class);
    }
}
