package com.example.controller;

import com.example.request.AddressRequest;
import com.example.response.AddressResponse;
import com.example.service.AddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/address")
public class AddressController {

    private final AddressService addressService;

    @Autowired
    public AddressController(AddressService addressService) {
        this.addressService = addressService;
    }

    @PostMapping("/create")
    public AddressResponse createAddress(@RequestBody AddressRequest addressRequest) {
        return addressService.createAddress(addressRequest);
    }

    @GetMapping("/{id}")
    public AddressResponse getAddressById(@PathVariable Long id){
        return addressService.getById(id);
    }
}
