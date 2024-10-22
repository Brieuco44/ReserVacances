package fr.reservacances.security;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;

@Configuration
@EnableMethodSecurity(prePostEnabled = true) // Active les annotations @PreAuthorize
public class SecurityConfig {
  
    // A COMPLETER
}
