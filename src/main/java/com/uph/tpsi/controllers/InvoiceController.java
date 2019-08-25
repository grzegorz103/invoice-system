package com.uph.tpsi.controllers;

import com.uph.tpsi.models.Invoice;
import com.uph.tpsi.services.interfaces.InvoiceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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

        @GetMapping ("/byUser")
        public List<Invoice> findByUser ()
        {
                return invoiceService.findByUser();
        }

        @PostMapping
        public Invoice create ( @RequestBody Invoice invoice )
        {
                return invoiceService.create( invoice );
        }

        @PatchMapping ("/{id}")
        public Invoice updateStatus ( @PathVariable ("id") Long id )
        {
                return invoiceService.updateStatus( id );
        }

        @DeleteMapping ("/{id}")
        public void deleteById ( @PathVariable ("id") Long id )
        {
                invoiceService.deleteById( id );
        }
}
