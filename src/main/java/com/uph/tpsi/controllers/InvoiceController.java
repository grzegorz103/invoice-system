package com.uph.tpsi.controllers;

import com.uph.tpsi.models.Invoice;
import com.uph.tpsi.services.interfaces.InvoiceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping ("/api/invoices")
@CrossOrigin
public class InvoiceController
{
        private final InvoiceService invoiceService;

        @Autowired
        public InvoiceController ( InvoiceService invoiceService )
        {
                this.invoiceService = invoiceService;
        }

        @GetMapping
        public List<Invoice> findAll ()
        {
                return invoiceService.findAll();
        }
}
