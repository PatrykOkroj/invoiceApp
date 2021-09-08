package com.okrojp.invoiceApp.controller;

import com.okrojp.invoiceApp.model.CustomerEntity;
import com.okrojp.invoiceApp.service.CustomerService;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("customer")
@RequiredArgsConstructor
public class CustomerController {
    @Getter
    private final CustomerService service;

    @PostMapping()
    public CustomerEntity addCustomer(@RequestBody CustomerEntity customer) {
        return service.getRepository().save(customer);
    }

    @GetMapping()
    public List<CustomerEntity> allCustomers() {
        return service.getRepository().findAll();
    }
}
