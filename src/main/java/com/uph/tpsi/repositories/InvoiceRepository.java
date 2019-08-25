package com.uph.tpsi.repositories;

import com.uph.tpsi.models.Invoice;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface InvoiceRepository extends JpaRepository<Invoice, Long>
{
        List<Invoice> findAllByUser_Username(String username);
}
