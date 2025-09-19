package org.ssupstart.ems.systemconfig;


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
                .csrf(csrf -> csrf.disable()) // Disable CSRF (or selectively ignore for /h2-console/**)
                .headers(headers -> headers
                        .frameOptions(frameOptions -> frameOptions.disable()) // ✅ Modern way to disable X-Frame-Options
                )
                .authorizeHttpRequests(auth -> auth
                        .requestMatchers("/h2-console/**", "/ems/**").permitAll()
                        .anyRequest().authenticated()
                );

        return http.build();
    }

}
