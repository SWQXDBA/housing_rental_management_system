package com.example.housing_rental_management_system.Configs;

import com.example.housing_rental_management_system.SecurityHandler.UserAuthenticationFailureHandler;
import com.example.housing_rental_management_system.SecurityHandler.UserAuthenticationSuccessHandler;
import com.example.housing_rental_management_system.Service.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
public class SecurityConfig extends WebSecurityConfigurerAdapter {
    @Autowired
    UserAuthenticationFailureHandler failureHandler;
    @Autowired
    UserAuthenticationSuccessHandler successHandler;
    @Autowired
    UserServiceImpl service;
    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(service);
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.formLogin()
                .loginProcessingUrl("/login")
                .usernameParameter("userName")
                .passwordParameter("password")
                .successHandler(successHandler)
                .failureHandler(failureHandler)
                .and()
                .cors()
                .and()
                .csrf().disable();

    }


}
