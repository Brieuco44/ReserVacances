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
import fr.reservacances.request.voiture.CreateOrUpdateMarqueRequest;

@SpringBootTest
@AutoConfigureMockMvc
public class MarqueApiControllerIntegrationTest {

    private static final String ENDPOINT = "/api/marque";
    private static final String ENDPOINT_ID = ENDPOINT + "/{id}";

    private static final String VILLE_ID = "Ville1";
    private static final String MARQUE_ID = "Marque1";

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

    // CREATE
    @Test
    void shouldCreateStatusForbidden() throws Exception {
        // given
        CreateOrUpdateMarqueRequest request = CreateOrUpdateMarqueRequest.builder()
                .nom("Ville non mise à jour (forbidden)")
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
        CreateOrUpdateMarqueRequest request = CreateOrUpdateMarqueRequest.builder()
                .nom("Ville créée")
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

    // UPDATE
    @Test
    void shouldUpdateStatusForbidden() throws Exception {
        // given
        CreateOrUpdateMarqueRequest request = CreateOrUpdateMarqueRequest.builder()
                .nom("Ville non mise à jour (forbidden)")
                .villeId(VILLE_ID)
                .build();

        // when
        ResultActions result = this.mockMvc.perform(
                MockMvcRequestBuilders
                        .put(ENDPOINT_ID, MARQUE_ID)
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(TestUtil.json(request)));

        // then
        result.andExpect(MockMvcResultMatchers.status().isForbidden());
    }

    @Test
    @WithMockUser(roles = "CAR_MANAGER")
    void shouldUpdateStatusCreated() throws Exception {
        // given
        CreateOrUpdateMarqueRequest request = CreateOrUpdateMarqueRequest.builder()
                .nom("Ville non mise à jour (forbidden)")
                .villeId(VILLE_ID)
                .build();

        // when
        ResultActions result = this.mockMvc.perform(
                MockMvcRequestBuilders
                        .put(ENDPOINT_ID, MARQUE_ID)
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(TestUtil.json(request)));

        // then
        result.andExpect(MockMvcResultMatchers.status().isOk());
    }

}
