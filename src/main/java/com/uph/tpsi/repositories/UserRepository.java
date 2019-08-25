package com.uph.tpsi.repositories;

import com.ii.uph.tpsi.models.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long>
{
        boolean existsByUsername ( String username );

        User findByUsername ( String s );
}
