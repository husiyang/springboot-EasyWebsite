package com.threegorges.demo.repository;

import com.threegorges.demo.domain.Menu;
import com.threegorges.demo.domain.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface MenuRepository extends JpaRepository<Menu, String> {

    @Query("select m from Menu m where m.role = ?1")
    List<Menu> findMenusByRole(Role role);
}
