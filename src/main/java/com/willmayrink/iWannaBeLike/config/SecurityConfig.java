package com.willmayrink.iWannaBeLike.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
                .authorizeHttpRequests(authorize -> authorize
                        .requestMatchers("/login", "/register").permitAll() // Permite acesso a páginas de login e registro
                        .anyRequest().authenticated() // Exige autenticação para todas as outras páginas
                )
                .formLogin(form -> form
                        .loginPage("/login") // Define a URL da sua página de login
                        .defaultSuccessUrl("/home", true) // Redireciona para /home após login bem-sucedido
                        .permitAll()
                )
                .logout(logout -> logout
                        .logoutUrl("/logout") // Define a URL para fazer logout
                        .logoutSuccessUrl("/login?logout") // Redireciona após logout bem-sucedido
                        .permitAll()
                );
        return http.build();
    }
}