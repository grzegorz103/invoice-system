package com.uph.tpsi.models;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table (name = "services")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Service
{
        @Id
        @GeneratedValue (strategy = GenerationType.IDENTITY)
        private Long id;

        @Column (name = "name")
        private String name;

        @Column (name = "price")
        private float price;
}
