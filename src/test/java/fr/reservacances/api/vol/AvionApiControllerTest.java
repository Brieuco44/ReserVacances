package fr.reservacances.api.vol;

import fr.reservacances.TestUtil;
import fr.reservacances.exception.EntityNotFoundException;
import fr.reservacances.repository.vol.ModelAvionRepository;
import fr.reservacances.request.voiture.CreateOrUpdateMarqueRequest;
import fr.reservacances.request.vol.CreateOrUpdateAvionRequest;
import fr.reservacances.response.vol.AvionInfoResponse;
import fr.reservacances.repository.vol.CompagnieRepository;
import fr.reservacances.repository.vol.AvionRepository;
import fr.reservacances.model.vol.ModeleAvion;
import fr.reservacances.model.vol.Compagnie;
import fr.reservacances.model.vol.Avion;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.*;
import org.springframework.http.MediaType;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
@Sql(scripts = "classpath:/vol.sql", executionPhase = Sql.ExecutionPhase.BEFORE_TEST_CLASS)
public class AvionApiControllerTest {

    private static final String ENDPOINT = "/api/vol/avion";
    private static final String ENDPOINT_ID = ENDPOINT + "/{id}";

    private static final String COMPAGNIE_ID = "a26cb918-3d9c-49c8-9c79-3cde3eab0b6f";
    private static final String AVION_ID = "93eeb9ac-0e5f-47c6-ae38-65758d0d5d34";
    private static final String MODELE_AVION_ID = "5b9a27f7-6781-4af9-8f0a-4d8a6c77c8e1";

    @Autowired
    private MockMvc mockMvc;

    // Helper method to build request objects
    private CreateOrUpdateAvionRequest buildRequest(String modeleAvionId, String compagnieId) {
        return CreateOrUpdateAvionRequest.builder()
                .modeleAvionId(modeleAvionId)
                .compagnieId(compagnieId)
                .build();
    }

    // GET All
    @Test
    @DirtiesContext
    void shouldFindAllStatusOk() throws Exception {
        // Act
        ResultActions result = this.mockMvc.perform(MockMvcRequestBuilders.get(ENDPOINT));

        // Assert
        result.andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$.length()").isNotEmpty());
    }

    // CREATE Tests
    @Test
    void shouldCreateStatusForbidden() throws Exception {
        // Arrange
        CreateOrUpdateAvionRequest request = buildRequest(MODELE_AVION_ID, "compagnie-id-1");

        // Act
        ResultActions result = this.mockMvc.perform(
                MockMvcRequestBuilders
                        .post(ENDPOINT)
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(TestUtil.json(request))
        );

        // Assert
        result.andExpect(MockMvcResultMatchers.status().isForbidden());
    }

    @Test
    @WithMockUser(roles = "VOL_MANAGER")
    void shouldCreateStatusCreated() throws Exception {
        // Arrange
        CreateOrUpdateAvionRequest request = buildRequest(MODELE_AVION_ID, COMPAGNIE_ID);

        // Act
        ResultActions result = this.mockMvc.perform(
                MockMvcRequestBuilders
                        .post(ENDPOINT)
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(TestUtil.json(request))
        );

        // Assert
        result.andExpect(MockMvcResultMatchers.status().isCreated())
                .andExpect(MockMvcResultMatchers.jsonPath("$.id").exists());
    }

    // UPDATE Tests
    @Test
    void shouldUpdateStatusForbidden() throws Exception {
        // Arrange
        CreateOrUpdateAvionRequest request = buildRequest(MODELE_AVION_ID, "compagnie-id-1");

        // Act
        ResultActions result = this.mockMvc.perform(
                MockMvcRequestBuilders
                        .put(ENDPOINT_ID, "avion-id-1")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(TestUtil.json(request))
        );

        // Assert
        result.andExpect(MockMvcResultMatchers.status().isForbidden());
    }

    @Test
    @WithMockUser(roles = "VOL_MANAGER")
    void shouldUpdateStatusOk() throws Exception {
        // Arrange
        CreateOrUpdateAvionRequest request = buildRequest(MODELE_AVION_ID, COMPAGNIE_ID);

        // Act
        ResultActions result = this.mockMvc.perform(
                MockMvcRequestBuilders
                        .put(ENDPOINT_ID, AVION_ID)
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(TestUtil.json(request))
        );

        // Assert
        result.andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$.id").value(AVION_ID));
    }
}
