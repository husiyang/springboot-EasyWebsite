package com.threegorges.demo.domain;

import org.hibernate.annotations.GenericGenerator;
import org.springframework.util.Assert;

import javax.persistence.*;
import java.io.Serializable;

import static com.threegorges.demo.Util.MD5.string2MD5;


@Entity
@Table(name = "EMPLOYEE")
public class Employee implements Serializable {


    @Id
    @GeneratedValue(generator = "uuid.hex")
    @GenericGenerator(name = "uuid.hex", strategy = "org.hibernate.id.UUIDHexGenerator")
    private String id;

    private Integer age;

    private String name;

    private String password;

    private String desc;

    @ManyToOne(cascade=CascadeType.ALL)
    @JoinColumn(name = "ROLE_ID")
    private Role role;

    protected Employee(){

    }

    public Employee(String name) {
        Assert.hasText(name,"name null");
        this.name = name;
        this.password = "123456";
    }

    public Employee(String name,Integer age,String desc){
        this(name);
        if( 61 > age && age > 20){
           this.desc = desc;
           this.age = age;
       }
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public void setPassword(String password) {
        this.password = encodeByMD5(password);
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public void setRole(Role role){this.role = role;}

    public String getId() {
        return id;
    }

    public Integer getAge() {
        return age;
    }

    public String getName() {
        return name;
    }

    public String getDesc() {
        return desc;
    }

    public Role getRole() {
        return role;
    }

    public boolean isMatchUser(String password){
        return this.password.equals(encodeByMD5(password));
    }

    @Transient
    private String[] passwordArray = new String[3];
    @Transient
    private int size = 0;
    public boolean updatePassword(String oldPassword,String newPassword){
        Assert.hasText(oldPassword,"old is null");
        Assert.hasText(newPassword,"new is null");
        String v1 = this.password;
        if(v1.equals(encodeByMD5(oldPassword))){
            this.password = encodeByMD5(newPassword);
            if (size > 2) return true;
            passwordArray[size] = this.password;
            size++;
        }else {
            return false;
        }
        return true;
    }

    public boolean passwordRollback(int index){
        if(index > 3) return false;
        this.password = passwordArray[index-1];
        return true;
    }

    private String encodeByMD5(String plaintext) {
        return string2MD5(plaintext);
    }
}
