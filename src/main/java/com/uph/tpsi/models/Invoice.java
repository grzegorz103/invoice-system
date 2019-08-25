package com.uph.tpsi.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;
import java.util.Set;

@Entity
@Table(name="invoices")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Invoice
{
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Long id;

        @ManyToOne
        @JoinColumn(name="user_id")
        private User user;

        @Column(name="total_price")
        private float totalPrice;

        @ManyToMany(fetch = FetchType.EAGER)
        @JoinTable (name = "invoice_services",
                joinColumns = @JoinColumn (name = "invoice_id"),
                inverseJoinColumns = @JoinColumn (name = "service_id"))
        private Set<Service> services;

}
