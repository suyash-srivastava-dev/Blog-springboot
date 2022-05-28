package com.suyash.deubank.pojo;



import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Collection;
import java.util.UUID;

@Entity @Data @NoArgsConstructor
public class Employee {


//    private String id;
    @Id
    private String name;
    private String email;
    private String password;
    @ManyToMany(fetch = FetchType.EAGER)
    private Collection<Role> role;
    private String securityQuestion;
    private String securityAnswer;

    public Employee(String id, String name, String email, String password, Collection<Role> role, String securityQuestion, String securityAnswer) {

//        this.id = id;
        this.name = name;
        this.email = email;
        this.password = password;
        this.role = role;
        this.securityQuestion = securityQuestion;
        this.securityAnswer = securityAnswer;
    }



}
