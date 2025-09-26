package com.willmayrink.iWannaBeLike.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity httpSecurity) throws Exception {
        httpSecurity.authorizeHttpRequests(
                authorize -> authorize.requestMatchers("/login", "/css/**", "/js/**","/img/**").permitAll().anyRequest().authenticated()).formLogin(
                        form -> form.loginPage("/login").defaultSuccessUrl("/role_models", true).permitAll()).logout(
                                logout -> logout.permitAll());
        return httpSecurity.build();
    }
}
