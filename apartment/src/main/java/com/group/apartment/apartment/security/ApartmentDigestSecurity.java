package com.group.apartment.apartment.security;

import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.www.DigestAuthenticationEntryPoint;
import org.springframework.security.web.authentication.www.DigestAuthenticationFilter;

@Configuration
@Order(1)
@Slf4j
public class ApartmentDigestSecurity extends WebSecurityConfigurerAdapter {

    private DigestAuthenticationEntryPoint getDigestEntryPoint() {

        DigestAuthenticationEntryPoint digestAuthenticationEntryPoint
                = new DigestAuthenticationEntryPoint();
        digestAuthenticationEntryPoint.setRealmName("apartment-digest-realm");
        digestAuthenticationEntryPoint.setKey("apartmentDigestKey"); // nones generated using this setKey

        return digestAuthenticationEntryPoint;
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        //return new BcryptPasswordEncoder();
        return NoOpPasswordEncoder.getInstance();

    }

    /*
    here in the fly we are creating user and password using inMemoryAuthentication
     */
    protected void configure(AuthenticationManagerBuilder authManagerBuilder) throws Exception {

        log.info("Override ApartmentDigestSecurity  {}:", authManagerBuilder);

        authManagerBuilder.inMemoryAuthentication().
                withUser("digestaravind").
                password(passwordEncoder().encode("digestsecret"))
                .roles("USER")
                .and()
                .withUser("adminaravind")
                .password(passwordEncoder().encode("adminsecret")).
                roles("ADMIN")
                ;

    }

    @Bean
    public UserDetailsService userDetailsServiceBean() throws Exception {
        return super.userDetailsServiceBean();
    }

    private DigestAuthenticationFilter getDigestAuthFilter() throws Exception {
        DigestAuthenticationFilter digestAuthenticationFilter = new DigestAuthenticationFilter();
        digestAuthenticationFilter.setUserDetailsService(userDetailsServiceBean());
        digestAuthenticationFilter.setAuthenticationEntryPoint(getDigestEntryPoint());
        return digestAuthenticationFilter;
    }
    protected void configure(HttpSecurity httpSecurity)throws Exception{

        log.info("Override ApartmentDigestSecurity  {}:", httpSecurity);
        httpSecurity.antMatcher("/app/apartment/**").addFilter(getDigestAuthFilter()).exceptionHandling()
                .authenticationEntryPoint(getDigestEntryPoint()).and()
                .authorizeRequests().antMatchers("/app/apartment/**").hasRole("ADMIN")
        ;

    }
}
