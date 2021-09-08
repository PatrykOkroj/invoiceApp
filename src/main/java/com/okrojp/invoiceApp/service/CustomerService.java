package com.okrojp.invoiceApp.service;

import com.okrojp.invoiceApp.repository.CustomerRepository;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CustomerService {
    @Getter
    private final CustomerRepository repository;
}
