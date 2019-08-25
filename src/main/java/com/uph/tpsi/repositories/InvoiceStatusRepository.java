package com.uph.tpsi.repositories;

import com.uph.tpsi.models.InvoiceStatus;
import org.springframework.data.jpa.repository.JpaRepository;

public interface InvoiceStatusRepository extends JpaRepository<InvoiceStatus, Long>
{
        InvoiceStatus findByInvoiceType ( InvoiceStatus.InvoiceType invoiceType );
}
