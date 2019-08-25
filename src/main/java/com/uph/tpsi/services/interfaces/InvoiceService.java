package com.uph.tpsi.services.interfaces;

import com.uph.tpsi.models.Invoice;

import java.util.List;

public interface InvoiceService
{
        List<Invoice> findAll ();

        List<Invoice> findByUser ();

        Invoice create ( Invoice invoice );

        Invoice updateStatus(Long id);

        void deleteById(Long id);
}
