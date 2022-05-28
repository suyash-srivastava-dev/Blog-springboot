package com.suyash.deubank.services;


import com.suyash.deubank.pojo.Employee;
import com.suyash.deubank.pojo.Role;
import com.suyash.deubank.repo.EmployeeRepo;
import com.suyash.deubank.repo.RoleRepo;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.UUID;

@Service @RequiredArgsConstructor @Transactional @Slf4j
public class EmployeeServiceImpl implements  EmployeeService, UserDetailsService {
    private final EmployeeRepo employeeRepo;
    private final RoleRepo roleRepo;

    private final PasswordEncoder passwordEncoder;
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Employee user= employeeRepo.findByName(username);
        if(user == null)
        {
            log.error("User not found in the database");
            throw  new UsernameNotFoundException("User not found in DB");
        }
        else{
            log.info("User found in the database");
        }
        Collection<SimpleGrantedAuthority> authorities =new ArrayList<>();
        user.getRole().forEach(
                role -> {
                    authorities.add(new SimpleGrantedAuthority(role.getName()));
                }
        );
        return new User(user.getName(),user.getPassword(),authorities);
    }

    @Override
    public Employee saveEmployee(Employee employee) {
        log.info("Saving new user {}",employee);
        UUID uuid = UUID.randomUUID();
        String uuidAsString = uuid.toString();
//        employee.setId(uuidAsString);
        employee.setPassword(passwordEncoder.encode(employee.getPassword()));
        return employeeRepo.save(employee);
    }

    @Override
    public Role saveRole(Role role) {
        log.info("Saving new role {}",role.getName());
        UUID uuid = UUID.randomUUID();
        String uuidAsString = uuid.toString();
        role.setId(uuidAsString);
        return roleRepo.save(role);
    }


    @Override
    public void addRoleToEmployee(String employeeName, String roleName) {
        log.info("Adding new user: {} to role:{}",employeeName,roleName);

        Employee employee= employeeRepo.findByName(employeeName);
        Role role=roleRepo.findByName(roleName);
        employee.getRole().add(role);
    }

    @Override
    public Employee getEmployee(String employeeName) {
        log.info("get user {}",employeeName);

        return employeeRepo.findByName(employeeName);
    }

    @Override
    public List<Employee> getEmployees() {
        log.info("Listing all users");

        return (List<Employee>) employeeRepo.findAll();
    }


}
