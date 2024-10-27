package fr.reservacances.api;

import fr.reservacances.TestUtil;
import fr.reservacances.api.utilisateur.UtilisateurApiController;
import fr.reservacances.model.utilisateur.Utilisateur;
import fr.reservacances.repository.utilisateur.UtilisateurRepository;
import fr.reservacances.request.utilisateur.AuthRequest;
import fr.reservacances.request.utilisateur.SubscribeRequest;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.MediaType;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.util.Optional;
import java.util.stream.Stream;

@ExtendWith(MockitoExtension.class)
class UserApiControllerTest {
    private static final String ENDPOINT = "/api/utilisateur";
    private static final String ENDPOINT_AUTH = ENDPOINT + "/auth";
    private static final String ENDPOINT_SUBSCRIBE = ENDPOINT + "/create";

    private static final String PRENOM = "John";
    private static final String NOM = "Doe";
    private static final String USER_USERNAME = "JohnDoe";
    private static final String USER_PASSWORD = "1234azert*";
    private static final String USER_TELEPHONE = "0601020304";
    private static final String USER_EMAIL = "johnd@gmail.com";
    private static final String USER_ID = "293afe03-43d6-4af6-adc3-2b051ae7573c";


    @Mock
    private UtilisateurRepository repository;

    @Mock
    private PasswordEncoder passwordEncoder;
    
    @Mock
    private AuthenticationManager authenticationManager;

    @InjectMocks
    private UtilisateurApiController ctrl;

    private MockMvc mockMvc;

    @BeforeEach
    public void setup() {
        this.mockMvc = MockMvcBuilders.standaloneSetup(this.ctrl).build();
    }

    @Test
    void shouldAuthStatusOk() throws Exception {
        // given
        AuthRequest request = AuthRequest.builder()
            .username(USER_USERNAME)
            .password(USER_PASSWORD)
            .build()
        ;

        Mockito.when(this.repository.findByUsername(USER_USERNAME)).thenReturn(Optional.of(new Utilisateur()));

        // when
        ResultActions result = this.mockMvc.perform(
            MockMvcRequestBuilders
                .post(ENDPOINT_AUTH)
                .contentType(MediaType.APPLICATION_JSON)
                .content(TestUtil.json(request))
        );

        // then
        result.andExpect(MockMvcResultMatchers.status().isOk());

        Mockito.verify(this.repository).findByUsername(USER_USERNAME);
    }

    @Test
    void shouldAuthStatusOkEvenIfBadCredentialsThrown() throws Exception {
        // given
        AuthRequest request = AuthRequest.builder()
            .username(USER_USERNAME)
            .password(USER_PASSWORD)
            .build()
        ;

        Mockito.when(this.authenticationManager.authenticate(Mockito.any())).thenThrow(BadCredentialsException.class);

        // when
        ResultActions result = this.mockMvc.perform(
            MockMvcRequestBuilders
                .post(ENDPOINT_AUTH)
                .contentType(MediaType.APPLICATION_JSON)
                .content(TestUtil.json(request))
        );

        // then
        result.andExpect(MockMvcResultMatchers.status().isOk());
    }

    @ParameterizedTest
    @MethodSource("provideBadAuthRequests")
    void shouldAuthStatusBadRequest(AuthRequest request) throws Exception {
        // given

        // when
        ResultActions result = this.mockMvc.perform(
            MockMvcRequestBuilders
                .post(ENDPOINT_AUTH)
                .contentType(MediaType.APPLICATION_JSON)
                .content(TestUtil.json(request))
        );

        // then
        result.andExpect(MockMvcResultMatchers.status().isBadRequest());

        Mockito.verify(this.repository, Mockito.never()).save(Mockito.any());
    }

    @Test
    void shouldSubscribeStatusCreated() throws Exception {
        // given
        SubscribeRequest request = SubscribeRequest.builder()
            .nom(NOM)
            .prenom(PRENOM)
            .username(USER_USERNAME)
            .password(USER_PASSWORD)
            .telephone(USER_TELEPHONE)
            .email(USER_EMAIL)
            .role_id(USER_ID)
            .build()
        ;

        // when
        ResultActions result = this.mockMvc.perform(
            MockMvcRequestBuilders
                .post(ENDPOINT_SUBSCRIBE)
                .contentType(MediaType.APPLICATION_JSON)
                .content(TestUtil.json(request))
        );

        // then
        result.andExpect(MockMvcResultMatchers.status().isCreated());

        Mockito.verify(this.passwordEncoder).encode(USER_PASSWORD);
        Mockito.verify(this.repository).save(Mockito.any());
    }

    @ParameterizedTest
    @MethodSource("provideBadSubscribeRequests")
    void shouldCreateStatusBadRequest(SubscribeRequest request) throws Exception {
        // given

        // when
        ResultActions result = this.mockMvc.perform(
            MockMvcRequestBuilders
                .post(ENDPOINT_SUBSCRIBE)
                .contentType(MediaType.APPLICATION_JSON)
                .content(TestUtil.json(request))
        );

        // then
        result.andExpect(MockMvcResultMatchers.status().isBadRequest());

        Mockito.verify(this.passwordEncoder, Mockito.never()).encode(Mockito.any());
        Mockito.verify(this.repository, Mockito.never()).save(Mockito.any());
    }
 
    public static Stream<Arguments> provideBadAuthRequests() {
        return Stream.of(
            Arguments.of(
                AuthRequest.builder().build()
            ),

            Arguments.of(
                AuthRequest.builder()
                    .username(" ")
                    .password(USER_PASSWORD)
                    .build()
            ),

            Arguments.of(
                AuthRequest.builder()
                    .username(USER_USERNAME)
                    .password("")
                    .build()
            ),

            Arguments.of(
                AuthRequest.builder()
                    .username(USER_USERNAME)
                    .build()
            )
        );
    }
 
    public static Stream<Arguments> provideBadSubscribeRequests() {
        return Stream.of(
            Arguments.of(
                SubscribeRequest.builder().build()
            ),

            Arguments.of(
                SubscribeRequest.builder()
                    .username(USER_USERNAME)
                    .username(" ")
                    .password(USER_PASSWORD)
                    .build()
            ),

            Arguments.of(
                SubscribeRequest.builder()
                    .nom(NOM)
                    .username(USER_USERNAME)
                    .password("")
                    .build()
            ),

            Arguments.of(
                SubscribeRequest.builder()
                    .username(USER_USERNAME)
                    .password(USER_PASSWORD)
                    .build()
            )
        );
    }
}
