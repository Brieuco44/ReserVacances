package fr.reservacances.api.vol;

import fr.reservacances.TestUtil;
import fr.reservacances.request.vol.CreateOrUpdateVolRequest;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import java.time.LocalDateTime;

@SpringBootTest
@AutoConfigureMockMvc
class VolIntegrationTest {

    private static final String ENDPOINT = "/api/vol"; // Exemple d'endpoint, assurez-vous qu'il soit correct
    private static final String ENDPOINT_ID = "/api/vol/{id}"; // Exemple d'endpoint, assurez-vous qu'il soit correct
    private static final String DATE_DEBUT = "2024-10-21T11:20:00";
    private static final String DATE_FIN = "2024-10-31T15:20:00";
    private static final String aeroportDepartId = "3b7b2e63-e9a0-4a5c-b6f6-1f2bb4938a84";
    private static final String aeroportArriveeId = "92b12348-8bc9-4e67-b3be-36af95bcfc9c";
    private static final String avionId = "e6c89c5c-bd6f-45f6-8a7f-39ab0e59dcbd";
    private static final String VOLID = "c6b2c7bb-3046-4b4f-9087-9a76a77e7e4f";
    private static final double prixAdulte = 120.0;
    private static final double prixEnfant = 70.0;

    @Autowired
    private MockMvc mockMvc;

    @Test
    @WithMockUser(roles = "VOL_MANAGER")
    void shouldCreated() throws Exception {
        // given
        CreateOrUpdateVolRequest request = CreateOrUpdateVolRequest.builder()
                .dateDebut(LocalDateTime.parse(DATE_DEBUT))
                .dateFin(LocalDateTime.parse(DATE_FIN))
                .aeroportDepartId(aeroportDepartId) // Correction de la typo ici
                .aeroportArriveeId(aeroportArriveeId)
                .avionId(avionId)
                .prixAdulte(prixAdulte)
                .prixEnfant(prixEnfant)
                .build();

        // when
        ResultActions result = this.mockMvc.perform(
                MockMvcRequestBuilders
                        .post(ENDPOINT)
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(TestUtil.json(request)));

        // then
        result.andExpect(MockMvcResultMatchers.status().isCreated());
    }

    // CREATE
    @Test
    void shouldCreateStatusForbidden() throws Exception {
        // given
        CreateOrUpdateVolRequest request = CreateOrUpdateVolRequest.builder()
                .dateDebut(LocalDateTime.parse(DATE_DEBUT))
                .dateFin(LocalDateTime.parse(DATE_FIN))
                .aeroportDepartId(aeroportDepartId)
                .aeroportArriveeId(aeroportArriveeId)
                .avionId(avionId)
                .prixAdulte(prixAdulte)
                .prixEnfant(prixEnfant)
                .build();

        // when
        ResultActions result = this.mockMvc.perform(
                MockMvcRequestBuilders
                        .post(ENDPOINT)
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(TestUtil.json(request)));

        // then
        result.andExpect(MockMvcResultMatchers.status().isForbidden());
    }

    // UPDATE
    @Test
    void shouldUpdateStatusForbidden() throws Exception {
        // given
        CreateOrUpdateVolRequest request = CreateOrUpdateVolRequest.builder()
                .dateDebut(LocalDateTime.parse(DATE_DEBUT))
                .dateFin(LocalDateTime.parse(DATE_FIN))
                .aeroportDepartId(aeroportDepartId)
                .aeroportArriveeId(aeroportArriveeId)
                .avionId(avionId)
                .prixAdulte(prixAdulte)
                .prixEnfant(prixEnfant)
                .build();

        // when
        ResultActions result = this.mockMvc.perform(
                MockMvcRequestBuilders
                        .put(ENDPOINT_ID, VOLID)
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(TestUtil.json(request)));

        // then
        result.andExpect(MockMvcResultMatchers.status().isForbidden());
    }

    // UPDATE
    @Test
    @WithMockUser(roles = "VOL_MANAGER")
    void shouldUpdateStatusOk() throws Exception {
        // given
        CreateOrUpdateVolRequest request = CreateOrUpdateVolRequest.builder()
                .dateDebut(LocalDateTime.parse(DATE_DEBUT))
                .dateFin(LocalDateTime.parse(DATE_FIN))
                .aeroportDepartId(aeroportDepartId)
                .aeroportArriveeId(aeroportArriveeId)
                .avionId(avionId)
                .prixAdulte(prixAdulte)
                .prixEnfant(prixEnfant)
                .build();

        // when
        ResultActions result = this.mockMvc.perform(
                MockMvcRequestBuilders
                        .put(ENDPOINT_ID, VOLID)
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(TestUtil.json(request)));

        // then
        result.andExpect(MockMvcResultMatchers.status().isOk());
    }
}
