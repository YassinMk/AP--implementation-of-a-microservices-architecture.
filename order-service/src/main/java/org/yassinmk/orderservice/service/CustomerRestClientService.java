package org.yassinmk.orderservice.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.yassinmk.orderservice.model.Customer;

import java.util.List;

@FeignClient(name = "CUSTOMER-SERVICE")
public interface CustomerRestClientService {
    @GetMapping(path = "/customers/{id}")
    public Customer getCustomerById(@PathVariable Long id);

    @GetMapping(path = "/customers")
    public List<Customer> getCustomers();

}
