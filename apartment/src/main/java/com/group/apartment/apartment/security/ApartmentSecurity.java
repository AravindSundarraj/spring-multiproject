package com.group.apartment.apartment.security;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.password.PasswordEncoder;

import javax.sql.DataSource;

@Configuration
@Slf4j
@Order(2)
public class ApartmentSecurity extends WebSecurityConfigurerAdapter {

    @Autowired
    private DataSource dataSource;

    @Autowired
    Oauth2AuthenticationSuccessHandler oauth2authSuccessHandler;

    protected void configure(HttpSecurity httpSecurity) throws Exception {
        log.info("Override Default Security {}:", httpSecurity);
        /*httpSecurity.authorizeRequests().anyRequest().authenticated()
                .and().httpBasic();*/


/*        httpSecurity.authorizeRequests()
                .antMatchers("/login","/register", "/login", "/h2-console/**", "/mylogin"
                , "/hello").
                permitAll()
                .anyRequest().authenticated()
                .and()
                .formLogin().loginPage("/login").defaultSuccessUrl("/hello").
                and().csrf().disable().rememberMe().key("mykey")
        .and().oauth2Login()
                .loginPage("/login").successHandler(oauth2authSuccessHandler);*/


        //-----------------

        httpSecurity
                .authorizeRequests()
                .antMatchers("/register","/login","/h2-console/**","/mylogin","/verify/**").permitAll()
                .anyRequest().authenticated()
                .and()
                .formLogin().loginPage("/login")
                .and().csrf().disable().rememberMe().key("myremembermekey")
                .and().logout().logoutUrl("/logout").logoutSuccessUrl("/login").deleteCookies("remember-me")

                .and().oauth2Login().loginPage("/login").successHandler(oauth2authSuccessHandler);


    }

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        log.info("DB Default Security {}:" , auth);
        auth.jdbcAuthentication()
                .dataSource(dataSource).passwordEncoder(passwordEncoder);
    }

    @Override
    public void configure(WebSecurity web) throws Exception {
        web.ignoring().antMatchers("/css/**","/app/webjars/**");
    }



}
