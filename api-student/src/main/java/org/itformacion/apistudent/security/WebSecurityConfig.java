package org.itformacion.apistudent.security;

import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.SecurityFilterChain;

@RequiredArgsConstructor
@Configuration
@EnableWebSecurity
public class WebSecurityConfig {
    public static final String ADMIN = "admin";
    public static final String USER = "user";
    private final JwtAuthConverter jwtAuthConverter;
    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws
            Exception {
        http.authorizeHttpRequests()
                .antMatchers(HttpMethod.GET, "/api/v1/students",
                        "/api/v1/students/**").permitAll()
                .antMatchers(HttpMethod.PUT, "/api/v1/students").hasAnyRole(ADMIN, USER)
                .antMatchers(HttpMethod.POST, "/api/v1/students").hasAnyRole(ADMIN)
                .antMatchers(HttpMethod.DELETE, "/api/v1/students").hasAnyRole(ADMIN)
                .anyRequest().authenticated();
        http.oauth2ResourceServer()
                .jwt()
                .jwtAuthenticationConverter(jwtAuthConverter);
        http.sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS);
        return http.build();
    }
}