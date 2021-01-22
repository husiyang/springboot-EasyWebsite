package com.threegorges.demo.domain;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.io.Serializable;
import java.util.*;


@Entity
@Table(name = "ROLE")
public class Role implements Serializable {

    @Id
    @GeneratedValue(generator = "uuid.hex")
    @GenericGenerator(name = "uuid.hex", strategy = "org.hibernate.id.UUIDHexGenerator")
    private String roleId;

    private String roleName;

    @OneToMany(cascade = CascadeType.ALL)
    private Collection<Employee> employees;

    @OneToMany(cascade = CascadeType.ALL)
    private Collection<Menu> menus = new ArrayList<>();

    public void setRoleId(String id){this.roleId = id;}

    public void setRoleName(String roleName){
        this.roleName = roleName;
    }

    public void setEmployees(Collection<Employee> employees){ this.employees = employees;}

    public void setMenus(Collection<Menu> menus){
        this.menus = menus;
    }

    public String getRoleId(){return roleId;}

    public String getRoleName(){return roleName;}

    public Collection<Employee> getEmployees(){return employees;}

    public Collection<Menu> getMenuList(){
        return menus;
    }

}
