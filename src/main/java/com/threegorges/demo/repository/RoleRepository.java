package com.threegorges.demo.repository;

import com.threegorges.demo.domain.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface RoleRepository extends JpaRepository<Role, String> {

    @Query("select r from Role r where r.roleId = ?1")
    Role findRoleByRoleId(String roleId);
}
