package com.threegorges.demo.repository;

import com.threegorges.demo.domain.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;



@Repository
@Transactional
public interface EmployeeRepository extends JpaRepository<Employee, String> {

//    @Query("select e from Employee e where e.name=:username and e.password=:password")
//    Employee findByUsernameAndPassword(@Param("username")String name, @Param("password") String password);

//    @Query("select e from Employee e where e.name=:#{#employee.name} and e.password=:#{#employee.password}")
//    Employee findByUsernameAndPassword(@Param("employee")Employee employee);

    @Query("select e from Employee e where e.name=:#{#employee.name}")
    Employee findByUsername(@Param("employee")Employee employee);
}