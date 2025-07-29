package com.luv2code.springboot.cruddemo.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.provisioning.JdbcUserDetailsManager;
import org.springframework.security.provisioning.UserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

import javax.sql.DataSource;

@Configuration
public class DemoSecurityConfig {

    /*
    // In-memory user setup for testing purposes
    // Each user has username, password, and role(s)
    @Bean
    public InMemoryUserDetailsManager userDetailsManager(){
        UserDetails john = User.builder().username("john").password("{noop}123").roles("EMPLOYEE").build();
        UserDetails mary = User.builder().username("mary").password("{noop}123").roles("EMPLOYEE", "MANAGER").build();
        UserDetails susan = User.builder().username("susan").password("{noop}123").roles("EMPLOYEE", "MANAGER", "ADMIN").build();

        return new InMemoryUserDetailsManager(john, mary, susan);
    }
    */

    // Using database-backed authentication instead of in-memory users
    @Bean
    public UserDetailsManager userDetailsManager(DataSource dataSource) {
        // JdbcUserDetailsManager:
        // - Retrieves user credentials and authorities from a relational database
        // - Requires a schema with tables `users` and `authorities` (or equivalent)
        // - Spring Security will use this to authenticate users and load their roles
        // In general, we use data from a database to manage users and roles
        JdbcUserDetailsManager jdbcUserDetailsManager = new JdbcUserDetailsManager(dataSource);

        // define query to load user by username
        jdbcUserDetailsManager.setUsersByUsernameQuery(
                "select user_id, pw, active from members where user_id = ?"
        );

        // define query to load authorities/roles by username
        jdbcUserDetailsManager.setAuthoritiesByUsernameQuery(
                "select user_id, role from roles where user_id = ?"
        );

        return jdbcUserDetailsManager;
    }

    @Bean
    public SecurityFilterChain roleRestriction(HttpSecurity http) throws Exception {
        http.authorizeHttpRequests(configurer ->
                configurer
                        // Only users with role EMPLOYEE can perform GET requests
                        .requestMatchers(HttpMethod.GET, "/api/employees").hasRole("EMPLOYEE")
                        .requestMatchers(HttpMethod.GET, "api/employees/**").hasRole("EMPLOYEE")

                        // Only users with role MANAGER can POST, PUT, or PATCH
                        .requestMatchers(HttpMethod.POST, "api/employees").hasRole("MANAGER")
                        .requestMatchers(HttpMethod.PUT, "api/employees/**").hasRole("MANAGER")
                        .requestMatchers(HttpMethod.PATCH, "api/employees/**").hasRole("MANAGER")

                        // Only users with role ADMIN can DELETE
                        .requestMatchers(HttpMethod.DELETE, "api/employees/**").hasRole("ADMIN")
        );

        // Use HTTP Basic authentication (username/password in browser popup or headers)
        http.httpBasic(Customizer.withDefaults());

        // Disable CSRF protection (okay for REST APIs or testing, but not recommended for production web apps)
        http.csrf(csrf -> csrf.disable());

        return http.build();
    }
}
