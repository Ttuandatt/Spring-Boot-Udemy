package com.luv2code.springboot.cruddemo.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class DemoSecurityConfig {

    // This code configures an in-memory user details manager with three users: john, mary, and susan.
    // Each user has a username, password, and roles assigned.
    // We will use database authentication in the next section, but for now, this is a simple way to set up users for testing purposes.
    @Bean
    public InMemoryUserDetailsManager userDetailsManager(){
        UserDetails john = User.builder().username("john").password("{noop}123").roles("EMPLOYEE").build();
        UserDetails mary = User.builder().username("mary").password("{noop}123").roles("EMPLOYEE","MANAGER").build();
        UserDetails susan = User.builder().username("susan").password("{noop}123").roles("EMPLOYEE", "MANAGER", "ADMIN").build();

        return new InMemoryUserDetailsManager(john,mary,susan);
    }

    @Bean
    public SecurityFilterChain roleRestriction(HttpSecurity http) throws Exception {
        http.authorizeHttpRequests(configurer->
                configurer
                        .requestMatchers(HttpMethod.GET, "/api/employees").hasRole("EMPLOYEE")
                        .requestMatchers(HttpMethod.GET, "api/employees/**").hasRole("EMPLOYEE")
                        .requestMatchers(HttpMethod.POST, "api/employees").hasRole("MANAGER")
                        .requestMatchers(HttpMethod.PUT, "api/employees/**").hasRole("MANAGER")
                        .requestMatchers(HttpMethod.PATCH, "api/employees/**").hasRole("MANAGER")
                        .requestMatchers(HttpMethod.DELETE, "api/employees/**").hasRole("ADMIN")
        );

        //use HTTP Basic authentication
        http.httpBasic(Customizer.withDefaults());

        // disable CSRF (cross-site request forgery) protection
        // Note: Disabling CSRF is not recommended for production applications, but it is acceptable for testing purposes.
        http.csrf(csrf -> csrf.disable());

        return http.build();
    }
}

