package com.uph.tpsi.services;

import com.uph.tpsi.models.Invoice;
import com.uph.tpsi.models.InvoiceStatus;
import com.uph.tpsi.repositories.InvoiceRepository;
import com.uph.tpsi.repositories.UserRepository;
import com.uph.tpsi.services.interfaces.InvoiceService;
import com.uph.tpsi.repositories.InvoiceStatusRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import javax.validation.constraints.NotNull;
import java.util.List;

@Service
public class InvoiceServiceImpl implements InvoiceService
{
        private final InvoiceRepository invoiceRepository;

        private final UserRepository userRepository;

        @Autowired
        private InvoiceStatusRepository invoiceStatusRepository;

        @Autowired
        public InvoiceServiceImpl ( InvoiceRepository invoiceRepository,
                                    UserRepository userRepository )
        {
                this.invoiceRepository = invoiceRepository;
                this.userRepository = userRepository;
        }

        @Override
        public List<Invoice> findAll ()
        {
                return invoiceRepository.findAll();
        }

        @Override
        public List<Invoice> findByUser ()
        {
                Authentication loggedInUser = SecurityContextHolder.getContext().getAuthentication();
                String username = loggedInUser.getName();

                return invoiceRepository.findAllByUser_Username( username );
        }

        @Override
        public Invoice create ( @NotNull Invoice invoice )
        {
                Authentication loggedInUser = SecurityContextHolder.getContext().getAuthentication();
                String username = loggedInUser.getName();
                invoice.setInvoiceStatus( invoiceStatusRepository.findByInvoiceType( InvoiceStatus.InvoiceType.AWAITING ) );
                invoice.setUser( userRepository.findByUsername( username ) );
                return invoiceRepository.save( invoice );
        }

        @Override
        public Invoice updateStatus ( Long id )
        {
                Invoice invoice = invoiceRepository.findById( id ).orElseThrow( () -> new RuntimeException( "Nie znaleziono faktury" ) );

                invoice.setInvoiceStatus(
                        invoice.getInvoiceStatus().getInvoiceType() == InvoiceStatus.InvoiceType.AWAITING
                                ? invoiceStatusRepository.findByInvoiceType( InvoiceStatus.InvoiceType.PAID )
                                : invoiceStatusRepository.findByInvoiceType( InvoiceStatus.InvoiceType.AWAITING )
                );
                return invoiceRepository.save( invoice );
        }

        @Override
        public void deleteById ( Long id )
        {
                invoiceRepository.deleteById( id );
        }
}
