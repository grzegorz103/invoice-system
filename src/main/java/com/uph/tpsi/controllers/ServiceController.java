package com.uph.tpsi.controllers;

import com.uph.tpsi.models.Service;
import com.uph.tpsi.services.interfaces.ServiceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping ("/api/invoices")
@CrossOrigin
public class ServiceController
{
        private final ServiceService serviceService;

        @Autowired
        public ServiceController ( ServiceService serviceService )
        {
                this.serviceService = serviceService;
        }

        @GetMapping
        public List<Service> findAll ()
        {
                return serviceService.findAllServices();
        }

        @PostMapping
        public Service create ( @RequestBody Service service )
        {
                return serviceService.create( service );
        }
}
