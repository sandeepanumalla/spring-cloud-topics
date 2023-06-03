package com.example.feignclients;

import com.example.response.AddressResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient( value = "address-service", path = "/api/address")
public interface AddressFeignClients {

    @GetMapping("/{id}")
    public AddressResponse getById(@PathVariable long id);
}
