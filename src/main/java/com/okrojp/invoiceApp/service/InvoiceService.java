package com.okrojp.invoiceApp.service;

import com.okrojp.invoiceApp.model.CustomerEntity;
import com.okrojp.invoiceApp.repository.CustomerRepository;
import com.stripe.Stripe;
import com.stripe.exception.StripeException;
import com.stripe.model.*;
import com.stripe.param.*;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Value;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

@Component
@RequiredArgsConstructor
public class InvoiceService {

    @Getter
    private final CustomerRepository customerRepository;


    public String allCustomers() throws StripeException {
        Stripe.apiKey = "sk_test_51JXKbPDOsxG0yiZfBVUPPaoV9KV43FtbeFwqBzhl2zuVQbqkTeYiyL3k093YHyXgOOGkO3ymfyg0FI4LJy4M6qrm00xYCFL4kd";
        CustomerListParams listParams = CustomerListParams.builder().build();
        return Customer.list(listParams).toString();
    }

    public String addCustomer(Long id) throws StripeException {
        Stripe.apiKey = "sk_test_51JXKbPDOsxG0yiZfBVUPPaoV9KV43FtbeFwqBzhl2zuVQbqkTeYiyL3k093YHyXgOOGkO3ymfyg0FI4LJy4M6qrm00xYCFL4kd";
        Optional<CustomerEntity> customerById = customerRepository.findById(id);

        CustomerCreateParams params =
                CustomerCreateParams.builder()
                        .setName(customerById.get().getName())
                        .setEmail(customerById.get().getEmail())
                        .setPhone(customerById.get().getPhone())
                        .build();

        Customer customer = Customer.create(params);

        return customer.toString();
    }


    public String createInvoice(String customerId, Long amount) throws StripeException {
        Stripe.apiKey = "sk_test_51JXKbPDOsxG0yiZfBVUPPaoV9KV43FtbeFwqBzhl2zuVQbqkTeYiyL3k093YHyXgOOGkO3ymfyg0FI4LJy4M6qrm00xYCFL4kd";

        InvoiceItemCreateParams invoiceItemParams =
                InvoiceItemCreateParams.builder()
                        .setCustomer(customerId)
                        .setAmount(amount)
                        .setCurrency("PLN")
                        .build();

        InvoiceItem.create(invoiceItemParams);

        InvoiceCreateParams invoiceParams =
                InvoiceCreateParams.builder()
                        .setCustomer(customerId)
                        .setAutoAdvance(true) // auto-finalize this draft after ~1 hour
                        .build();
        Invoice.create(invoiceParams);
        return invoiceParams.toString();

    }

    public String getInvoices() throws StripeException {
        Stripe.apiKey = "sk_test_51JXKbPDOsxG0yiZfBVUPPaoV9KV43FtbeFwqBzhl2zuVQbqkTeYiyL3k093YHyXgOOGkO3ymfyg0FI4LJy4M6qrm00xYCFL4kd";
        Map<String, Object> params = new HashMap<>();
        params.put("limit", 3);
        InvoiceCollection invoices = Invoice.list(params);
        return invoices.toString();
    }
}
