package com.okrojp.invoiceApp.controller;

import com.okrojp.invoiceApp.model.CustomerEntity;
import com.okrojp.invoiceApp.service.InvoiceService;
import com.stripe.exception.StripeException;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/invoice")
@RequiredArgsConstructor
public class InvoiceController {
    @Getter
    private final InvoiceService service;

    @GetMapping("/customers")
    public ResponseEntity<?> getCustomers() throws StripeException {
        return ResponseEntity.ok(service.allCustomers());
    }

    @GetMapping("/invoices")
    public ResponseEntity<?> getInvoices() throws StripeException {
        return ResponseEntity.ok(service.getInvoices());
    }

    @PostMapping("/addCustomer/{id}")
    public ResponseEntity<?> addCustomer(@PathVariable Long id) throws StripeException {
        return ResponseEntity.ok(service.addCustomer(id));
    }

    @PostMapping("/addInvoice")
    public ResponseEntity<?> addInvoice(@RequestParam String customerId, @RequestParam Long amount) throws StripeException {
        return ResponseEntity.ok(service.createInvoice(customerId, amount));
    }
}
