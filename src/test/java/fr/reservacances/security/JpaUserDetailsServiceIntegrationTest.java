package fr.reservacances.security;

import fr.reservacances.config.JpaUserDetailsService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

@SpringBootTest
class JpaUserDetailsServiceIntegrationTest {
    private static final String USER_USERNAME = "user1";

    @Autowired
    private JpaUserDetailsService service;

    @Test
    void shouldFindByUsernameReturnsUserDetails() {
        // given

        // when
        UserDetails result = this.service.loadUserByUsername("user1");

        // then
        Assertions.assertEquals(USER_USERNAME, result.getUsername());
    }

    @Test
    void shouldFindByUsernameThrows() {
        // given

        // when & then
        Assertions.assertThrows(
            UsernameNotFoundException.class,
            () -> this.service.loadUserByUsername("user-not-exists")
        );
    }
}
