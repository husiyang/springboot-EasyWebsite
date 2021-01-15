package com.threegorges.demo.controller;

import com.threegorges.demo.domain.Employee;
import com.threegorges.demo.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpSession;

@Controller
public class LoginController {

    @Autowired private EmployeeRepository employeeRepository;


    /**
     * 登录页面
     *
     * @return 页面url
     */
    @GetMapping("/login")
    public String login() {
        return "login";
    }

    /**
     * 注册页面
     *
     * @return 页面url
     */
    @GetMapping("register")
    public String register() {
        return "register";
    }

/*
    登陆功能手动cache实现
    @PostMapping("/login")
    public String Login(@RequestParam("username") String username, @RequestParam("password") String password){
        if (employeeCache.isLogin(username, password)){
            return "redirect:/user1";
        }else {
            return "login";
        }
    }
*/


    @PostMapping("/login")
    public String Login(@RequestParam("username") String username,@RequestParam("password") String password, HttpSession httpSession, Model model) {
        Employee employee = new Employee(username);
        employee.setPassword(password);
        if (employeeRepository.findByUsername(employee).isMatchUser(password)) {
            httpSession.setAttribute("loginEmployee", employee);
            return "redirect:/user";
        } else {
            model.addAttribute("msg", "incorrect username or password");
            return "login";
        }
    }

    @PostMapping("/logout")
    public String Logout(HttpSession httpSession){
        httpSession.setAttribute("loginEmployee",null);
        return "redirect:/login";
    }

    @PostMapping("/register")
    public String Register(@RequestParam("username") String username,@RequestParam("password") String password, Model model) {
        Employee employee = new Employee(username);
        employee.setPassword(password);
        if (employeeRepository.findByUsername(employee) != null) {
            model.addAttribute("msg", "user has existed");
            return "register";
        } else {
            employeeRepository.save(employee);
            return "redirect:/login";
        }
    }
}

/*    //注册功能手动cache实现
    @PostMapping("/register")
    public String Register(@RequestParam("username") String username, @RequestParam("password") String password){
        Employee employee = new Employee();
        employee.setName(username);
        employee.setPassword(password);
        employeeService.save(employee)fin;
        if (employeeCache.getEmployeeByName(username) != null){
            return "redirect:/user1";
        } else {
            return "register";
        }
    }*/

/*    //登陆功能
    @PostMapping("/login")
    public String Login(@RequestParam("username") String username, @RequestParam("password") String password, Map<String,Object> map){
        Employee employee= employeeService.findByUsernameAndPassword(username,password);
        if(employee != null){
            return "user";
        } else {
            map.put("msg","错误");
            return "login";
        }
    }*/


