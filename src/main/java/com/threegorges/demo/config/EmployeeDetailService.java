package com.threegorges.demo.config;

import com.threegorges.demo.domain.Employee;
import com.threegorges.demo.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class EmployeeDetailService implements UserDetailsService {

    @Autowired private EmployeeRepository employeeRepository;

    @Autowired private PasswordEncoder passwordEncoder;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        Employee v1 = new Employee(username);
        Employee employee = employeeRepository.findByUsername(v1);
        if (employee == null){
            throw new UsernameNotFoundException("not found");
        }

        List<GrantedAuthority> authorities = new ArrayList<GrantedAuthority>();
        authorities.add(new SimpleGrantedAuthority("ROLE_"+employee.getRole().name()));
        User user = new User(employee.getName(),passwordEncoder.encode("123456"),authorities);
        return user;
    }
}
