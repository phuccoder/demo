package com.example.demo.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;


@Configuration
@EnableWebSecurity
public class SecurityConfig {


    @Bean
    public BCryptPasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    
    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
            .authorizeRequests(authorizeRequests ->
                authorizeRequests
                .antMatchers("/register","/").permitAll()
                .antMatchers("/user/**","/login").hasAnyRole("USER", "ADMIN")
                .antMatchers("/**/**","/**").hasRole("ADMIN")
                .antMatchers("/allUsers/**").hasAnyRole("USER","ADMIN")
                .anyRequest().authenticated()
            )
            .exceptionHandling(exceptionHandling ->
                exceptionHandling
                    .accessDeniedPage("/403")
            )
            .formLogin(formLogin ->
                formLogin
                    .loginPage("/login")
                    .loginProcessingUrl("/j_spring_security_login")
                    .defaultSuccessUrl("/user")
                    .failureUrl("/login?message=error")
                    .usernameParameter("username")
                    .passwordParameter("password")
                    .permitAll()
            )
            .logout(logout ->
                logout
                    .logoutUrl("/j_spring_security_logout")
                    .logoutSuccessUrl("/login")
            );
        return http.build();
    }
}