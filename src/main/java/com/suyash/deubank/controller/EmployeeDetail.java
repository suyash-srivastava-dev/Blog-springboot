package com.suyash.deubank.controller;


import com.suyash.deubank.pojo.Employee;
import com.suyash.deubank.pojo.Role;
import com.suyash.deubank.services.EmployeeService;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/v1/api")
@RequiredArgsConstructor
public class EmployeeDetail {
    @Autowired
   private EmployeeService employeeService;

    @GetMapping("/user/list")
    public ResponseEntity<List<Employee>> getEmployee()
    {
        return ResponseEntity.ok().body(employeeService.getEmployees());
    }
    @PostMapping("/user/create")
    public ResponseEntity<Employee> createEmployee(@RequestBody Employee employee)
    {
        URI uri = URI.create(ServletUriComponentsBuilder.fromCurrentContextPath().path("/v1/api/user/create").toUriString());
        return ResponseEntity.created(uri).body(employeeService.saveEmployee(employee));
    }
    @PostMapping("/role/create")
    public ResponseEntity<Role> createRole(@RequestBody Role role)
    {
        URI uri = URI.create(ServletUriComponentsBuilder.fromCurrentContextPath().path("/v1/api/role/create").toUriString());
        return ResponseEntity.created(uri).body(employeeService.saveRole(role));
    }
    @PostMapping("/user/add-role")
    public ResponseEntity<?> addRoleToEmployee(@RequestBody RoleToEmployee roleToEmployee)
    {
        employeeService.addRoleToEmployee(roleToEmployee.getEmployeeName(),roleToEmployee.getRoleName());
        return ResponseEntity.ok().build();
    }
}
@Data
class RoleToEmployee{
    private String employeeName;
    private String roleName;
}