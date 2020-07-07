package com.group.apartment.apartment.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "users")
@Setter
@Getter
public class MyAppUser {

    @Id
    @NotNull
    private  String username;
    @NotNull
    private String firstName;
    @NotNull
    private String lastName;
    @Email
    @NotNull
    private String email;
    @NotNull
    private String password;

    private boolean enabled=true;

    @ElementCollection

    @Column(name="AUTHORITY")
    @CollectionTable(name = "AUTHORITIES",joinColumns = {@JoinColumn(name="USERNAME")})
    private Set<String> authorities;



    public MyAppUser() {
        authorities= new HashSet<>();
        authorities.add("USER");
    }


    public MyAppUser( String username,  String firstName,  String lastName,
                      String email,  String password, boolean enabled) {
        super();
        this.username = username;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.password = password;
        this.enabled=enabled;
        authorities= new HashSet<>();
        authorities.add("USER");
    }










}