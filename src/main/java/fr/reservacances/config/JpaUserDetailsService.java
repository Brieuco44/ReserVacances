package fr.reservacances.config;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import fr.reservacances.model.utilisateur.Utilisateur;
import fr.reservacances.repository.utilisateur.UtilisateurRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;

@Service
@RequiredArgsConstructor
@Log4j2
public class JpaUserDetailsService implements UserDetailsService{
    private final UtilisateurRepository utilisateurRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Utilisateur utilisateur = this.utilisateurRepository.findByUsername(username).orElseThrow(() -> new UsernameNotFoundException("User not found"));

        return org.springframework.security.core.userdetails.User
            .withUsername(username)
            .password(utilisateur.getMotDePasse())
            .build()
        ;
    }
}
