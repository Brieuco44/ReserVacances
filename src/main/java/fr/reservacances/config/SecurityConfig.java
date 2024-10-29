package fr.reservacances.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Configuration
@EnableMethodSecurity(prePostEnabled = true) // Active les annotations @PreAuthorize
public class SecurityConfig {

    @Bean // Configuration des accès (Authorization)
    SecurityFilterChain filterChain(HttpSecurity http, JwtHeaderFilter jwtHeaderFilter) throws Exception {
        http.authorizeHttpRequests(authorize -> {
            authorize.requestMatchers("/**").permitAll(); // Test full open
        });

        http.csrf(AbstractHttpConfigurer::disable);

        http.addFilterBefore(jwtHeaderFilter, UsernamePasswordAuthenticationFilter.class);


        return http.build();
    }

    @Bean
        // Configuration de l'encodeur de mot de passe
    PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    AuthenticationManager authenticationManager(AuthenticationConfiguration config) throws Exception {
        return config.getAuthenticationManager();
    }
}
