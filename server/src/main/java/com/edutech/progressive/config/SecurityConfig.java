<<<<<<< HEAD
ckage com.edutech.progressive.config;
=======
package com.edutech.progressive.config;
>>>>>>> a620306e1a8595f58f09e291e62fe35606b4afd0

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .authorizeRequests()
                .anyRequest().permitAll() // Allow all requests without authentication
                .and()
                .csrf().disable(); // Disable CSRF protection if it's not needed
    }
}