package com.group.apartment.apartment.repo;

import com.group.apartment.apartment.domain.MyAppUser;
import org.springframework.data.repository.CrudRepository;



public interface UserRepository extends CrudRepository<MyAppUser, String> {

    MyAppUser findByUsername(String username);
    MyAppUser findByEmail(String email);

}
