package com.uph.tpsi.config;

import com.uph.tpsi.models.*;
import com.uph.tpsi.repositories.InvoiceStatusRepository;
import com.uph.tpsi.repositories.ServiceRepository;
import com.uph.tpsi.repositories.UserRepository;
import com.uph.tpsi.repositories.UserRoleRepository;
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

        private final ServiceRepository serviceRepository;

        @Autowired
        private InvoiceStatusRepository invoiceStatusRepository;

        private final PasswordEncoder encoder;

        @Autowired
        public Initializer ( UserRoleRepository userRoleRepository,
                             UserRepository userRepository,
                             PasswordEncoder encoder,
                             ServiceRepository serviceRepository )
        {
                this.userRoleRepository = userRoleRepository;
                this.userRepository = userRepository;
                this.encoder = encoder;
                this.serviceRepository = serviceRepository;
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

                        if ( invoiceStatusRepository.findAll().isEmpty() )
                        {
                                invoiceStatusRepository.save( InvoiceStatus.builder().invoiceType( InvoiceStatus.InvoiceType.AWAITING ).build() );
                                invoiceStatusRepository.save( InvoiceStatus.builder().invoiceType( InvoiceStatus.InvoiceType.PAID ).build() );
                        }

                        if ( serviceRepository.findAll().isEmpty() )
                        {
                                serviceRepository.save( Service.builder().name( "Ocieplenie ścian" ).price( 1500f ).build() );
                                serviceRepository.save( Service.builder().name( "Malowanie" ).price( 500f ).build() );
                                serviceRepository.save( Service.builder().name( "Tynkowanie" ).price( 2000f ).build() );
                                serviceRepository.save( Service.builder().name( "Montaż instalacji elektrycznej" ).price( 1500f ).build() );
                                serviceRepository.save( Service.builder().name( "Murowanie" ).price( 3500f ).build() );
                        }

                };
        }
}
