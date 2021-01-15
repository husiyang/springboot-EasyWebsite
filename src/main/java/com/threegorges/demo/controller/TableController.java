package com.threegorges.demo.controller;

import com.threegorges.demo.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class TableController {

    @Autowired
    private EmployeeRepository employeeRepository;

    @GetMapping("/jq_grid")
    public String jq_grid(){
        return "jq_grid";
    }

    @GetMapping("/table_basic")
    public String table_basic(){
        return "table_basic";
    }

    @GetMapping("/table_foo_table")
    public String table_foo_table(){
        return "table_foo_table";
    }

    @GetMapping("/contacts")
    public String contacts(){
        return "contacts";
    }

    @GetMapping("/mailbox")
    public String mailbox(){
        return "mailbox";
    }

    @GetMapping("/profile")
    public String profile(){
        return "profile";
    }

    @PostMapping("/table_foo_table")
    public String getEmployeeAll(Model model, Pageable pageable){
        if (pageable == null){
            pageable = PageRequest.of(0,5);
        }
        model.addAttribute("employees",employeeRepository.findAll(pageable));
        return "table_foo_table";
    }

}
