package com.uph.tpsi.repositories;

import com.uph.tpsi.models.UserRole;
import com.uph.tpsi.models.UserType;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRoleRepository extends JpaRepository<UserRole, Long>
{
        UserRole findByUserType ( UserType userType );
}
