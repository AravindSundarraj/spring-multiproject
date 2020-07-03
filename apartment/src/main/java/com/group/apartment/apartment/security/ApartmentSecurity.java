package com.group.apartment.apartment.security;

import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
@Slf4j
public class ApartmentSecurity extends WebSecurityConfigurerAdapter {

    protected void configure(HttpSecurity httpSecurity)throws Exception{
        log.info("Override Default Security {}:" , httpSecurity);
        httpSecurity.authorizeRequests().anyRequest().authenticated()
                .and().httpBasic();

    }


}
