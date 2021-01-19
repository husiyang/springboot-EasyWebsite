package com.threegorges.demo.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.csrf().disable();

        http.authorizeRequests()
                .antMatchers("/","/login","/register","/jquery-2.1.1.min.js","/css/**","/favicon.ico","/img/**","/js/**","/h2-console","/h2-console/**").permitAll()
                .antMatchers("/**").hasRole("admin")
                .antMatchers("/user","/contacts","/mailbox","/profile").hasRole("user")
                .antMatchers("/jq_grid","/table_basic","table_foo_table","/user","/contacts","/mailbox","/profile").hasRole("vip");
        http.formLogin().loginPage("/login");
        http.logout().logoutSuccessUrl("/login");
        http.rememberMe().rememberMeParameter("remember");
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {

    }

    @Bean
    public PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }
}
