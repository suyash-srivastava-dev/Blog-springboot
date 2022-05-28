package com.suyash.deubank.repo;

//import org.springframework.data.repository.CrudRepository;
//all the CRUD operations are already there by CrudRepository


import com.suyash.deubank.pojo.Employee;

import org.springframework.data.repository.CrudRepository;

public interface  EmployeeRepo extends CrudRepository<Employee,String> {

    Employee findByName(String employeeName);
}
