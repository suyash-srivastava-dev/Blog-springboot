package com.suyash.deubank.services;



import com.suyash.deubank.pojo.Employee;
import com.suyash.deubank.pojo.Role;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

public interface EmployeeService
{
    Employee saveEmployee(Employee employee);
    Role saveRole(Role role);
    void addRoleToEmployee(String employeeName,String roleName);
    Employee getEmployee(String employeeName);
    List<Employee> getEmployees();


}
