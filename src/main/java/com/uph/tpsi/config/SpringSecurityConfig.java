package com.uph.tpsi.config;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity (securedEnabled = true)
public class SpringSecurityConfig extends WebSecurityConfigurerAdapter
{
        @Override
        protected void configure ( HttpSecurity http ) throws Exception
        {
                http
                        .authorizeRequests()
                        .antMatchers( "/api/**" )
                        .permitAll()
                        .and()
                        .httpBasic()
                        .and()
                        .cors()
                        .and()
                        .csrf()
                        .disable();
        }

        @Bean
        public WebMvcConfigurer corsMappig ()
        {
                return new WebMvcConfigurer()
                {
                        @Override
                        public void addCorsMappings ( CorsRegistry registry )
                        {
                                registry.addMapping( "/**" ).allowedMethods( "*" ).allowedOrigins( "http://localhost:4200" );

                        }
                };
        }

        @Bean
        public BCryptPasswordEncoder passwordEncoder ()
        {
                return new BCryptPasswordEncoder();
        }

}
