package com.global.studentAPI.security;

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

    private final String [] public_EndPoints = {
            "/system/student",
            "/system/students"
    };


    //defines which URL paths should be secured
    @Override
    protected void configure(HttpSecurity http) throws Exception {

        http
                    //disable cookies
                .csrf().disable()
                .cors().disable()
                    //all end points need password except public end points
                .authorizeRequests()
                .antMatchers(public_EndPoints).permitAll()
                //.antMatchers(public_EndPoints).permitAll()
                .anyRequest().authenticated()
                .and()
                .httpBasic();


    }


    //used to encode passwords
    @Bean
    PasswordEncoder passwordEncoder (){
        return new BCryptPasswordEncoder();
    }

    // to manage users who can use system
    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth
                .inMemoryAuthentication()
                .withUser("backend").password(passwordEncoder().encode("123")).roles("ADMIN")
                .and()
                .withUser("sharkawi").password(passwordEncoder().encode("123")).roles("user");
    }
}
