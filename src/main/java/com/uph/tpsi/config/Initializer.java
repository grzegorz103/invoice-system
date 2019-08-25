package com.uph.tpsi.config;


import com.ii.uph.tpsi.models.User;
import com.ii.uph.tpsi.models.UserRole;
import com.ii.uph.tpsi.models.UserType;
import com.ii.uph.tpsi.repositories.UserRepository;
import com.ii.uph.tpsi.repositories.UserRoleRepository;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.Collections;
import java.util.HashSet;

@Configuration
public class Initializer
{
        private final UserRoleRepository userRoleRepository;

        private final UserRepository userRepository;

        private final PasswordEncoder encoder;

        @Autowired
        public Initializer ( UserRoleRepository userRoleRepository,
                             UserRepository userRepository,
                             PasswordEncoder encoder )
        {
                this.userRoleRepository = userRoleRepository;
                this.userRepository = userRepository;
                this.encoder = encoder;
        }

        @Bean
        public InitializingBean initializingBean ()
        {
                return () -> {


                        if ( userRoleRepository.findAll().isEmpty() )
                        {
                                userRoleRepository.save( new UserRole( 1L, UserType.ROLE_USER ) );
                                userRoleRepository.save( new UserRole( 2L, UserType.ROLE_ADMIN ) );
                        }

                        if ( userRepository.findAll().isEmpty() )
                        {
                                userRepository.save(
                                        User.builder()
                                                .username( "admin" )
                                                .password( encoder.encode( "admin1" ) )
                                                .userRoles( new HashSet<>( Collections.singletonList( userRoleRepository.findByUserType( UserType.ROLE_ADMIN ) ) ) )
                                                .build()
                                );

                                userRepository.save(
                                        User.builder()
                                                .username( "usertest" )
                                                .password( encoder.encode( "usertest" ) )
                                                .userRoles( new HashSet<>( Collections.singletonList( userRoleRepository.findByUserType( UserType.ROLE_USER ) ) ) )
                                                .build()
                                );
                        }

                };
        }
}
