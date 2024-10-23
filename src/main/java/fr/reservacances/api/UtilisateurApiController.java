package fr.reservacances.api;


import fr.reservacances.config.JwtUtil;
import fr.reservacances.model.utilisateur.Role;
import fr.reservacances.model.utilisateur.Utilisateur;
import fr.reservacances.repository.UtilisateurRepository;
import fr.reservacances.request.AuthRequest;
import fr.reservacances.request.SubscribeRequest;
import fr.reservacances.response.UtilisateurResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.http.HttpStatus;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/api/utilisateur")
@RequiredArgsConstructor
public class UtilisateurApiController {

    private final UtilisateurRepository repository;
    private final PasswordEncoder passwordEncoder;
    private final AuthenticationManager authenticationManager;

    @PostMapping("/auth")
    public String auth(@RequestBody AuthRequest request) {
        try {

            Authentication authentication = new UsernamePasswordAuthenticationToken(request.getUsername(), request.getPassword());

            authentication = this.authenticationManager.authenticate(authentication);

            SecurityContextHolder.getContext().setAuthentication(authentication);

            Optional<Utilisateur> identifiant = this.repository.findByUsername(request.getUsername());

            String id = "";
            if (identifiant.isEmpty()) {
                id = "";
            }else {
                id = identifiant.get().getId();
            }

            return JwtUtil.generate(request.getUsername(), id);
        }

        catch (BadCredentialsException e) {
            return "";
        }
    }

    @PostMapping("/create")
    @ResponseStatus(HttpStatus.CREATED)
    public String create(@RequestBody SubscribeRequest request) {
        Utilisateur utilisateur = new Utilisateur();
        Role role = new Role();

        // ger role with id from request
        role.setId(request.getRole_id());

        utilisateur.setRole(role);

        BeanUtils.copyProperties(request, utilisateur);

        utilisateur.setMotDePasse(this.passwordEncoder.encode(request.getPassword()));

        this.repository.save(utilisateur);

        return utilisateur.getId();
    }

    private UtilisateurResponse convert(Utilisateur utilisateur) {
        UtilisateurResponse response = UtilisateurResponse.builder().build();
        BeanUtils.copyProperties(utilisateur, response);
        return response;
    }
}
