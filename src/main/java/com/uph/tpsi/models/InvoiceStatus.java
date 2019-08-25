package com.uph.tpsi.models;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table (name = "invoice_types")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class InvoiceStatus
{
        @Id
        @GeneratedValue (strategy = GenerationType.IDENTITY)
        private Long id;

        @Enumerated (EnumType.STRING)
        private InvoiceType invoiceType;

        public enum InvoiceType
        {
                AWAITING,
                PAID
        }
}
