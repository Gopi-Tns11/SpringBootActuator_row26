package com.example.monitoring.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfig {

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {

        http
            .authorizeHttpRequests(auth -> auth
            		.requestMatchers(
            			    "/actuator/health",
            			    "/actuator/health/liveness",
            			    "/actuator/health/readiness"
            			).permitAll()
                .requestMatchers("/actuator/**").authenticated()
                .anyRequest().permitAll()
            )
            .httpBasic(httpBasic -> {});
        return http.build();
    }

    @Bean
    public InMemoryUserDetailsManager userDetailsService() {

        UserDetails user = User
                .withUsername("Gopi")
                .password("{noop}Gopi2411")
                .roles("ACTUATOR")
                .build();

        return new InMemoryUserDetailsManager(user);
    }
}