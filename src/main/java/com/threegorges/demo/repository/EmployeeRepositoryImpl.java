package com.threegorges.demo.repository;

import com.threegorges.demo.domain.Role;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Transactional
public class EmployeeRepositoryImpl {
    public void test(){
        Role r1 = new Role();
        r1.setRoleName("Admin");

        Role r2 = new Role();
        r2.setRoleName("VIP");

        Role r3 = new Role();
        r3.setRoleName("Normal");

//        Person p1 = new Person("Tom");
//        p1.getDepartments().add(d1);
//        p1.getDepartments().add(d2);
//
//        Person p2 = new Person("Jack");
//        p2.getDepartments().add(d1);
//        p2.getDepartments().add(d2);
//
//        d1.getPersons().add(p1);
//        d1.getPersons().add(p2);


        em.persist(r1);
        em.persist(r2);
        em.persist(r3);
//        em.persist(d1);
//        em.persist(d2);
    }
    @PersistenceContext
    private EntityManager em;
}
