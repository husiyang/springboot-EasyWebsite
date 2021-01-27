package com.threegorges.demo.domain;

import com.threegorges.demo.repository.EmployeeRepository;
import com.threegorges.demo.repository.MenuRepository;
import org.springframework.ui.Model;

import java.util.List;


public class CurrentEmployee {
    private Role role;

    private List<Menu> menus;

    private String name;

    public void setModel(Model model){
        model.addAttribute("menus",this.menus);
        model.addAttribute("role",this.role);
        model.addAttribute("name",this.name);
    }

    public CurrentEmployee(Employee employee, EmployeeRepository employeeRepository, MenuRepository menuRepository){
        this.role = employeeRepository.findByUsername(employee).getRole();
        this.menus = menuRepository.findMenusByRole(this.role);
        this.name = employee.getName();
    }

    public Role getRole() {
        return role;
    }

    public List<Menu> getMenus() {
        return menus;
    }

    //    private void generateMenu(Role role){
//        List<Menu> m = new ArrayList<>();
//        m.addAll(role.getMenuList());
//        menus.addAll(m);
//    }

}
