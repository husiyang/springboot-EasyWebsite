package com.threegorges.demo.domain;


import com.threegorges.demo.repository.RoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;

import java.util.ArrayList;
import java.util.List;

public class CurrentEmployee {
    private Role role;

    private List<Menu> menus;

    @Autowired private RoleRepository roleRepository;

    public void setModel(Model model){
        model.addAttribute("menus",menus);
        model.addAttribute("role",role);
    }

    public CurrentEmployee(Employee employee){
        this.role = roleRepository.findByEmployees(employee);
        generateMenu(this.role);
    }

    private void generateMenu(Role role){
        List<Menu> m = new ArrayList<>();
        m.addAll(role.getMenuList());
        menus.addAll(m);
    }

}
