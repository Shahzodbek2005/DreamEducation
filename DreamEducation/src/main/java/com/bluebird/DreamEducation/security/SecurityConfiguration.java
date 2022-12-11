package com.bluebird.DreamEducation.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpRequest;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.provisioning.UserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfiguration {

    @Autowired
    UnauthorizedResponseStructure unauthorizedResponseStructure;

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception{
        http.
                csrf().disable().
                authorizeRequests().
                antMatchers(HttpMethod.GET).permitAll().
                anyRequest().authenticated().and().httpBasic().
                authenticationEntryPoint(unauthorizedResponseStructure);
         return http.build();
    }

    @Bean
    public UserDetailsService users(){
        UserDetails admin = User.builder().username("khorunaliyev").password("1328").roles("ADMIN").build();
        UserDetails user = User.builder().username("tursunali").password("khorunaliyev").roles("USER").build();
        return new InMemoryUserDetailsManager(admin, user);
    }
}
