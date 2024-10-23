package fr.reservacances.config;

import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;

@Service
public class SecurityService {
    public boolean isCarManager(Authentication authentication) {
        // Vérifiez si l'utilisateur a le rôle "CAR_MANAGER"
        return authentication.getAuthorities().stream()
                .anyMatch(grantedAuthority -> grantedAuthority.getAuthority().equals("ROLE_CAR_MANAGER"));
    }
}
