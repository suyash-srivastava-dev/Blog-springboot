package com.suyash.deubank.repo;

//import org.springframework.data.repository.CrudRepository;
//all the CRUD operations are already there by CrudRepository


import com.suyash.deubank.pojo.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

public interface RoleRepo extends CrudRepository<Role,String> {

    Role findByName(String roleName);
}
