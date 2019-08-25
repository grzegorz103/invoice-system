package com.uph.tpsi.services.interfaces;

import com.uph.tpsi.models.Service;

import java.util.List;

public interface ServiceService
{
        Service create(Service service);

        List<Service> findAllServices();
}
