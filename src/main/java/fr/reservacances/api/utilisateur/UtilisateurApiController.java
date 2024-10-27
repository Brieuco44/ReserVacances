package fr.reservacances.api.utilisateur;


import fr.reservacances.request.utilisateur.UpdateRequest;
import fr.reservacances.response.config.MessageResponse;
import fr.reservacances.response.utilisateur.UtilisateurInfoResponse;
import org.springframework.beans.BeanUtils;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import fr.reservacances.config.JwtUtil;
import fr.reservacances.exception.utilisateur.UtilisateurNotFoundException;
import fr.reservacances.model.utilisateur.Role;
import fr.reservacances.model.utilisateur.Utilisateur;
import fr.reservacances.repository.utilisateur.UtilisateurRepository;
import fr.reservacances.request.utilisateur.AuthRequest;
import fr.reservacances.request.utilisateur.SubscribeRequest;
import fr.reservacances.response.utilisateur.UtilisateurResponse;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;

@RestController
@RequestMapping("/api/utilisateur")
@RequiredArgsConstructor
@Log4j2
public class UtilisateurApiController {

    private final UtilisateurRepository repository;
    private final PasswordEncoder passwordEncoder;
    private final AuthenticationManager authenticationManager;

    @PostMapping("/auth")
    public UtilisateurResponse auth(@Valid @RequestBody AuthRequest request) {
        try {

            Authentication authentication = new UsernamePasswordAuthenticationToken(request.getUsername(), request.getPassword());

            authentication = this.authenticationManager.authenticate(authentication);

            SecurityContextHolder.getContext().setAuthentication(authentication);

            // Optional<Utilisateur> identifiant = this.repository.findByUsername(request.getUsername());
            String token = JwtUtil.generate(this.repository.findByUsername(request.getUsername()).orElseThrow(UtilisateurNotFoundException::new));

            log.debug("Token *** généré!");

         return UtilisateurResponse.builder()
                .success(true)
                .token(token)
                .build()
            ;
        }

        catch (BadCredentialsException e) {
            return UtilisateurResponse.builder()
                .success(false)
                .build()
            ;
        }
    }

    @PostMapping("/create")
    @ResponseStatus(HttpStatus.CREATED)
    public UtilisateurInfoResponse create(@Valid @RequestBody SubscribeRequest request) {
        Utilisateur utilisateur = new Utilisateur();
        Role role = new Role();

        // ger role with id from request
        role.setId(request.getRole_id());

        utilisateur.setRole(role);

        BeanUtils.copyProperties(request, utilisateur);

        utilisateur.setMotDePasse(this.passwordEncoder.encode(request.getPassword()));

        this.repository.save(utilisateur);

        return this.convertInfo(utilisateur);
    }

    @GetMapping("/get")
    @PreAuthorize("isAuthenticated()")
    public UtilisateurInfoResponse get() {
        String utilisateurid = (String) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        System.out.println("utilisateurid: " + utilisateurid);
        Utilisateur utilisateur = this.repository.findById(utilisateurid).orElseThrow(UtilisateurNotFoundException::new);
        return this.convertInfo(utilisateur);
    }

    @PutMapping("/update")
    @PreAuthorize("isAuthenticated()")
    public UtilisateurInfoResponse update(@RequestBody UpdateRequest request) {
        String utilisateurid = (String) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        Utilisateur utilisateur = this.repository.findById(utilisateurid).orElseThrow(UtilisateurNotFoundException::new);

        BeanUtils.copyProperties(request, utilisateur);

        utilisateur.setMotDePasse(this.passwordEncoder.encode(request.getPassword())); // update password if changed

        this.repository.save(utilisateur);

        return this.convertInfo(utilisateur);
    }

    @DeleteMapping("/delete")
    @PreAuthorize("isAuthenticated() and hasRole('ROLE_ADMIN')")
    public MessageResponse delete(@RequestBody String id) {
        this.repository.deleteById(id);
        return new MessageResponse("Utilisateur deleted");
    }

    @PostMapping("/logout")
    @PreAuthorize("isAuthenticated()")
    public MessageResponse logout() {
        SecurityContextHolder.clearContext();
        return new MessageResponse("Logout successful");
    }

    private UtilisateurInfoResponse convertInfo(Utilisateur utilisateur) {
        UtilisateurInfoResponse response = UtilisateurInfoResponse.builder().build();
        BeanUtils.copyProperties(utilisateur, response);
        return response;
    }
}
