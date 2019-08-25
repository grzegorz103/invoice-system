package com.uph.tpsi.services;

import com.uph.tpsi.models.Service;
import com.uph.tpsi.repositories.ServiceRepository;
import com.uph.tpsi.services.interfaces.ServiceService;
import org.springframework.beans.factory.annotation.Autowired;

import javax.validation.constraints.NotNull;
import java.util.List;

@org.springframework.stereotype.Service
public class ServiceServiceImpl implements ServiceService
{
        private final ServiceRepository serviceRepository;

        @Autowired
        public ServiceServiceImpl ( ServiceRepository serviceRepository )
        {
                this.serviceRepository = serviceRepository;
        }

        @Override
        public Service create ( @NotNull Service service )
        {
                return serviceRepository.save( service );
        }

        @Override
        public List<Service> findAllServices ()
        {
                return serviceRepository.findAll();
        }
}
