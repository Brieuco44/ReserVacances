package fr.reservacances.api.voiture;

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

import fr.reservacances.TestUtil;
import fr.reservacances.request.voiture.CreateOrUpdateVoitureRequest;

@SpringBootTest
@AutoConfigureMockMvc
public class VoitureApiControllerIntegrationTest {
    private static final String ENDPOINT = "/api/voiture";
    private static final String ENDPOINT_ID = ENDPOINT + "/{id}";

    private static final String VOITURE_ID = "voiture1";
    private static final String VILLE_ID = "Ville1";
    private static final String MODELE_ID = "ModeleVoiture1";

    @Autowired
    private MockMvc mockMvc;

    // GET
    @Test
    void shouldFindAllStatusOk() throws Exception {
        // given

        // when
        ResultActions result = this.mockMvc.perform(MockMvcRequestBuilders.get(ENDPOINT));

        // then
        result
                .andExpect(MockMvcResultMatchers.status().isOk());
    }

    // // CREATE
    @Test
    void shouldCreateStatusForbidden() throws Exception {
        // given
        CreateOrUpdateVoitureRequest request = CreateOrUpdateVoitureRequest.builder()
                .prix(150)
                .modeleVoitureId(MODELE_ID)
                .villeId(VILLE_ID)
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

    @Test
    @WithMockUser(roles = "CAR_MANAGER")
    void shouldCreateStatusCreated() throws Exception {
        // given
        CreateOrUpdateVoitureRequest request = CreateOrUpdateVoitureRequest.builder()
                .prix(150)
                .modeleVoitureId(MODELE_ID)
                .villeId(VILLE_ID)
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

    // // UPDATE
    @Test
    void shouldUpdateStatusForbidden() throws Exception {
        // given
        CreateOrUpdateVoitureRequest request = CreateOrUpdateVoitureRequest.builder()
                .prix(150)
                .modeleVoitureId(MODELE_ID)
                .villeId(VILLE_ID)
                .build();

        // when
        ResultActions result = this.mockMvc.perform(
                MockMvcRequestBuilders
                        .put(ENDPOINT_ID, VOITURE_ID)
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(TestUtil.json(request)));

        // then
        result.andExpect(MockMvcResultMatchers.status().isForbidden());
    }

    @Test
    @WithMockUser(roles = "CAR_MANAGER")
    void shouldUpdateStatusCreated() throws Exception {
        // given
        CreateOrUpdateVoitureRequest request = CreateOrUpdateVoitureRequest.builder()
                .prix(150)
                .modeleVoitureId(MODELE_ID)
                .villeId(VILLE_ID)
                .build();

        // when
        ResultActions result = this.mockMvc.perform(
                MockMvcRequestBuilders
                        .put(ENDPOINT_ID, VOITURE_ID)
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(TestUtil.json(request)));

        // then
        result.andExpect(MockMvcResultMatchers.status().isOk());
    }

}
