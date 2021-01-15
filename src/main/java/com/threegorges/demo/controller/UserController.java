package com.threegorges.demo.controller;

import com.threegorges.demo.domain.Employee;
import com.threegorges.demo.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import javax.servlet.http.HttpSession;

@Controller
public class UserController {

    @Autowired
    private EmployeeRepository employeeRepository;
    /**
     * 用户页面
     *
     * @param model 视图
     * @return 页面url
     */
    @GetMapping("/user")
    public String user(Model model) {
        model.addAttribute("employees", employeeRepository.findAll());
        model.asMap();
        return "user";
    }

    @PostMapping("/user/delete")
    public String Delete(@Param("username") String username) {
        Employee employee = new Employee(username);
        Employee v1 = employeeRepository.findByUsername(employee);
        if (v1 != null) {
            employeeRepository.delete(v1);
        }
        return "redirect:/user";
    }

    @PostMapping("/user/password")
    public String UpdatePassword(@Param("oldPassword") String oldPassword, @Param("newPassword") String newPassword, HttpSession httpSession, Model model) {
        Employee employee = (Employee) httpSession.getAttribute("loginEmployee");
        if (!employee.updatePassword(oldPassword, newPassword)) {
            model.addAttribute("msg", "wrong old password");
        } else {
            Employee v1 = employeeRepository.findByUsername(employee);
            employeeRepository.delete(v1);
            employeeRepository.save(employee);
        }
        return "redirect:/user";
    }

    @PostMapping("/user/age")
    public String UpdateAge(@Param("age") Integer age, HttpSession httpSession){
        Employee employee = (Employee) httpSession.getAttribute("loginEmployee");
        Employee v1 = employeeRepository.findByUsername(employee);
        employeeRepository.delete(v1);
        employee.setAge(age);
        employeeRepository.save(employee);
        return "redirect:/user";
    }

    @PostMapping("/user/desc")
    public String UpdateDesc(@Param("desc") String desc, HttpSession httpSession){
        Employee employee = (Employee) httpSession.getAttribute("loginEmployee");
        Employee v1 = employeeRepository.findByUsername(employee);
        employeeRepository.delete(v1);
        employee.setDesc(desc);
        employeeRepository.save(employee);
        return "redirect:/user";
    }
}
