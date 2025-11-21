package com.example.demosecurity.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.provisioning.JdbcUserDetailsManager;
import org.springframework.security.provisioning.UserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

import javax.sql.DataSource;

@Configuration
public class DemoSecurityConfig {
    private static final String EMPLOYEE = "EMPLOYEE";
    private static final String MANAGER = "MANAGER";
    private static final String ADMIN = "ADMIN";


    // add support for JDBC ... no more hardcoded users
    @Bean
    public UserDetailsManager userDetailsManager(DataSource dataSource) {
        JdbcUserDetailsManager jdbcUserDetailsManager = new JdbcUserDetailsManager((dataSource));

        // define query to retrieve a user by username
        jdbcUserDetailsManager.setUsersByUsernameQuery(
                "select user_id, pw, active from members where user_id=?"
        );

        // define query to retrieve the authorities/roles by username
        jdbcUserDetailsManager.setAuthoritiesByUsernameQuery(
                "select user_id, role from roles where user_id=?"
        );

        return jdbcUserDetailsManager;
    }

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http.authorizeHttpRequests(configurer ->
                configurer
                        .requestMatchers("/").hasRole(EMPLOYEE)
                        .requestMatchers("/", "/showMyLoginPage", "/access-denied").permitAll()
                        .requestMatchers("/manager/**").hasRole(MANAGER)
                        .requestMatchers("/admin/**").hasRole(ADMIN)
        )
                .formLogin(form ->
                        form
                                .loginPage("/showMyLoginPage") // custom login page
                                .loginProcessingUrl("/authenticateTheUser") // login form POST action URL. This URL will be called in html form in templates folder
                                .permitAll() // allow everyone to see login page

                )
                .logout(logout -> logout.permitAll()) // allow everyone to see logout page
                .exceptionHandling(handling ->
                        handling.accessDeniedPage("/access-denied") // custom access denied page
                );

        return http.build();
    }

}
