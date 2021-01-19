package com.threegorges.demo.domain;

import lombok.Data;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Collection;


@Entity
@Table(name = "ROLE")
public class Role implements Serializable {

    @Id
    @GeneratedValue(generator = "uuid.hex")
    @GenericGenerator(name = "uuid.hex", strategy = "org.hibernate.id.UUIDHexGenerator")
    private String id;

    private String roleName;

    @ManyToMany
//    @JoinTable(name="EMPLOYEE",
//            joinColumns=@JoinColumn(name="ID"),
//            inverseJoinColumns=@JoinColumn(name="DEPT_ID"))
    private Collection<Employee> employees;

    public void setRoleName(String roleName){
        this.roleName = roleName;
    }

    public String getRoleName(){return roleName;}

}
