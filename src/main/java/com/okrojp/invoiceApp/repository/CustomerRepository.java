package com.okrojp.invoiceApp.repository;

import com.okrojp.invoiceApp.model.CustomerEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRepository extends JpaRepository<CustomerEntity, Long> {
}
