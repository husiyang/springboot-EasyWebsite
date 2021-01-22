package com.threegorges.demo.repository;

import com.threegorges.demo.domain.Employee;
import com.threegorges.demo.domain.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;


@Repository
@Transactional
public interface RoleRepository extends JpaRepository<Role, String> {

    @Query("select e from Role e where e.roleName=:#{#employee.role}")
    Role findByEmployees(@Param("employee")Employee employee);
}
