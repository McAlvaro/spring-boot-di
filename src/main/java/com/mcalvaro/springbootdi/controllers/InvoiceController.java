package com.mcalvaro.springbootdi.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mcalvaro.springbootdi.domain.Invoice;

@RestController
@RequestMapping("/invoice")
public class InvoiceController {
 
    @Autowired
    private Invoice invoice;

    @GetMapping("/show")
    public ResponseEntity<Invoice> show() {

        return ResponseEntity.ok(invoice);
    }
}
